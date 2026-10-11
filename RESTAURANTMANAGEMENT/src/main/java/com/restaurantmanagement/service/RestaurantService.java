package com.restaurantmanagement.service;

import com.restaurantmanagement.api.RestaurantController.EmployeeRequest;
import com.restaurantmanagement.api.RestaurantController.MenuRequest;
import com.restaurantmanagement.api.RestaurantController.OrderRequest;
import com.restaurantmanagement.api.RestaurantController.ReservationRequest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RestaurantService {
    private static final List<Map<String, String>> BRANCHES = List.of(
            Map.of("code", "Hyd", "name", "Hyderabad"),
            Map.of("code", "Blr", "name", "Bangalore"),
            Map.of("code", "Chn", "name", "Chennai"));

    private final JdbcTemplate jdbcTemplate;

    public RestaurantService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, String>> getBranches() {
        return BRANCHES;
    }

    public List<Map<String, Object>> getEmployees(String branch) {
        if (branch == null) {
            return jdbcTemplate.queryForList("SELECT empID AS empId, empName AS name, empAge AS age, "
                    + "empDesignation AS designation, empGender AS gender, empSal AS salary, "
                    + "empEmail AS email, empBranch AS branch FROM employee ORDER BY empID");
        }
        return jdbcTemplate.queryForList("SELECT empID AS empId, empName AS name, empAge AS age, "
                + "empDesignation AS designation, empGender AS gender, empSal AS salary, "
                + "empEmail AS email, empBranch AS branch FROM employee WHERE empBranch=? ORDER BY empID", branch);
    }

    public Map<String, Object> addEmployee(EmployeeRequest request) {
        jdbcTemplate.update("INSERT INTO employee(empID, empName, empAge, empDesignation, empGender, "
                + "empSal, empEmail, empBranch) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                request.empId(), request.name(), request.age(), request.designation(), request.gender(),
                request.salary(), request.email(), request.branch());
        return findEmployee(request.empId());
    }

    public Map<String, Object> updateEmployee(int id, EmployeeRequest request) {
        int updated = jdbcTemplate.update("UPDATE employee SET empName=?, empAge=?, empDesignation=?, "
                        + "empGender=?, empSal=?, empEmail=?, empBranch=? WHERE empID=?",
                request.name(), request.age(), request.designation(), request.gender(), request.salary(),
                request.email(), request.branch(), id);
        requireUpdated(updated, "Employee", id);
        return findEmployee(id);
    }

    public void removeEmployee(int id) {
        requireUpdated(jdbcTemplate.update("DELETE FROM employee WHERE empID=?", id), "Employee", id);
    }

    private Map<String, Object> findEmployee(int id) {
        return jdbcTemplate.queryForMap("SELECT empID AS empId, empName AS name, empAge AS age, "
                + "empDesignation AS designation, empGender AS gender, empSal AS salary, "
                + "empEmail AS email, empBranch AS branch FROM employee WHERE empID=?", id);
    }

    public List<Map<String, Object>> getMenu(String branch) {
        String query = "SELECT DishID AS dishId, DishName AS name, Price AS price, "
                + "FoodType AS foodType, Branch AS branch FROM menu";
        if (branch == null) {
            return jdbcTemplate.queryForList(query + " ORDER BY Branch, DishID");
        }
        return jdbcTemplate.queryForList(query + " WHERE Branch=? ORDER BY DishID", branch);
    }

    public Map<String, Object> addMenuItem(MenuRequest request) {
        jdbcTemplate.update("INSERT INTO menu(DishID, DishName, Price, FoodType, Branch) VALUES (?, ?, ?, ?, ?)",
                request.dishId(), request.name(), request.price(), request.foodType(), request.branch());
        return findMenuItem(request.branch(), request.dishId());
    }

    public Map<String, Object> updateMenuItem(String branch, int dishId, MenuRequest request) {
        int updated = jdbcTemplate.update("UPDATE menu SET DishName=?, Price=?, FoodType=?, Branch=? "
                        + "WHERE Branch=? AND DishID=?",
                request.name(), request.price(), request.foodType(), request.branch(), branch, dishId);
        requireUpdated(updated, "Menu item", dishId);
        return findMenuItem(request.branch(), dishId);
    }

    public void removeMenuItem(String branch, int dishId) {
        requireUpdated(jdbcTemplate.update("DELETE FROM menu WHERE Branch=? AND DishID=?", branch, dishId),
                "Menu item", dishId);
    }

    private Map<String, Object> findMenuItem(String branch, int dishId) {
        return jdbcTemplate.queryForMap("SELECT DishID AS dishId, DishName AS name, Price AS price, "
                + "FoodType AS foodType, Branch AS branch FROM menu WHERE Branch=? AND DishID=?", branch, dishId);
    }

    public List<Map<String, Object>> getOrders(String status) {
        String query = "SELECT ID AS id, Item AS item, Qty AS quantity, Stat AS status FROM orders";
        if (status == null) {
            return jdbcTemplate.queryForList(query + " ORDER BY ID, Item");
        }
        return jdbcTemplate.queryForList(query + " WHERE Stat=? ORDER BY ID, Item", status);
    }

    public Map<String, Object> addOrderItem(OrderRequest request) {
        if (jdbcTemplate.queryForObject("SELECT COUNT(*) FROM menu WHERE DishName=?",
                Integer.class, request.item()) == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu item not found: " + request.item());
        }
        jdbcTemplate.update("INSERT INTO orders(ID, Item, Qty, Stat) VALUES (?, ?, ?, 'p')",
                request.id(), request.item(), request.quantity());
        return findOrderItem(request.id(), request.item());
    }

    public Map<String, Object> updateOrderItem(int id, String item, int quantity) {
        int updated = jdbcTemplate.update("UPDATE orders SET Qty=? WHERE ID=? AND Item=?", quantity, id, item);
        requireUpdated(updated, "Order item", id);
        return findOrderItem(id, item);
    }

    public void removeOrderItem(int id, String item) {
        requireUpdated(jdbcTemplate.update("DELETE FROM orders WHERE ID=? AND Item=?", id, item), "Order item", id);
    }

    public void cancelOrder(int id) {
        requireUpdated(jdbcTemplate.update("DELETE FROM orders WHERE ID=?", id), "Order", id);
    }

    public Map<String, Object> completeOrder(int id) {
        requireUpdated(jdbcTemplate.update("UPDATE orders SET Stat='d' WHERE ID=?", id), "Order", id);
        return Map.of("id", id, "status", "d");
    }

    public Map<String, Object> makePayment(int id, int paidAmount) {
        List<Map<String, Object>> items = jdbcTemplate.queryForList(
                "SELECT o.Item AS item, o.Qty AS quantity, m.Price AS unitPrice, "
                        + "(o.Qty * m.Price) AS amount FROM orders o "
                        + "JOIN menu m ON m.DishName=o.Item WHERE o.ID=? ORDER BY o.Item", id);
        if (items.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found: " + id);
        }
        int total = items.stream().mapToInt(item -> ((Number) item.get("amount")).intValue()).sum();
        if (paidAmount < total) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Insufficient payment; total due is " + total);
        }
        return Map.of("orderId", id, "items", items, "totalAmount", total,
                "paidAmount", paidAmount, "change", paidAmount - total);
    }

    private Map<String, Object> findOrderItem(int id, String item) {
        return jdbcTemplate.queryForMap("SELECT ID AS id, Item AS item, Qty AS quantity, "
                + "Stat AS status FROM orders WHERE ID=? AND Item=?", id, item);
    }

    public List<Map<String, Object>> getReservations(String branch) {
        String query = "SELECT ID AS id, custName AS customerName, Branch AS branch, "
                + "`Count` AS guests, TimeSlot AS timeSlot, TimeIn AS timeIn, Stat AS status, "
                + "tcat AS tableCategory FROM reservation";
        if (branch == null) {
            return jdbcTemplate.queryForList(query + " ORDER BY Branch, ID");
        }
        return jdbcTemplate.queryForList(query + " WHERE Branch=? ORDER BY ID", branch);
    }

    @Transactional
    public Map<String, Object> makeReservation(ReservationRequest request) {
        LocalDateTime requestedAt = LocalDateTime.now().with(request.timeSlot());
        if (!requestedAt.isAfter(LocalDateTime.now())) {
            requestedAt = requestedAt.plusDays(1);
        }
        if (requestedAt.isBefore(LocalDateTime.now().plusHours(4))) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Reservations must be made at least 4 hours in advance");
        }
        int category = tableCategory(request.guests());
        jdbcTemplate.update("INSERT INTO reservation(ID, custName, Branch, `Count`, TimeSlot, TimeIn, Stat, tcat) "
                        + "VALUES (?, ?, ?, ?, ?, NULL, 'r', ?)",
                request.id(), request.customerName(), request.branch(), request.guests(),
                request.timeSlot(), category);
        return findReservation(request.id());
    }

    @Transactional
    public Map<String, Object> occupyReservation(int id) {
        Map<String, Object> reservation = findReservation(id);
        if (!"r".equalsIgnoreCase(String.valueOf(reservation.get("status")))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Reservation is not awaiting occupancy");
        }
        String branch = String.valueOf(reservation.get("branch"));
        int category = ((Number) reservation.get("tableCategory")).intValue();
        String seatColumn = seatColumn(category);
        int updated = jdbcTemplate.update("UPDATE seating SET " + seatColumn + "=" + seatColumn
                + "-1 WHERE Branch=? AND " + seatColumn + ">0", branch);
        if (updated == 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No suitable table is available");
        }
        jdbcTemplate.update("UPDATE reservation SET Stat='o', TimeIn=? WHERE ID=?", LocalTime.now(), id);
        return findReservation(id);
    }

    @Transactional
    public void cancelReservation(int id) {
        Map<String, Object> reservation = findReservation(id);
        if ("o".equalsIgnoreCase(String.valueOf(reservation.get("status")))) {
            String seatColumn = seatColumn(((Number) reservation.get("tableCategory")).intValue());
            jdbcTemplate.update("UPDATE seating SET " + seatColumn + "=" + seatColumn + "+1 WHERE Branch=?",
                    reservation.get("branch"));
        }
        requireUpdated(jdbcTemplate.update("DELETE FROM reservation WHERE ID=?", id), "Reservation", id);
    }

    private Map<String, Object> findReservation(int id) {
        return jdbcTemplate.queryForMap("SELECT ID AS id, custName AS customerName, Branch AS branch, "
                + "`Count` AS guests, TimeSlot AS timeSlot, TimeIn AS timeIn, Stat AS status, "
                + "tcat AS tableCategory FROM reservation WHERE ID=?", id);
    }

    public List<Map<String, Object>> getSeating(String branch) {
        String query = "SELECT Branch AS branch, Seats3 AS seats3, seats5 AS seats5, "
                + "Seats10 AS seats10 FROM seating";
        if (branch == null) {
            return jdbcTemplate.queryForList(query + " ORDER BY Branch");
        }
        return jdbcTemplate.queryForList(query + " WHERE Branch=?", branch);
    }

    private static int tableCategory(int guests) {
        if (guests <= 3) {
            return 3;
        }
        if (guests <= 5) {
            return 5;
        }
        return 10;
    }

    private static String seatColumn(int category) {
        return switch (category) {
            case 3 -> "Seats3";
            case 5 -> "Seats5";
            case 10 -> "Seats10";
            default -> throw new IllegalArgumentException("Unsupported table category: " + category);
        };
    }

    private static void requireUpdated(int rowCount, String entity, int id) {
        if (rowCount == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, entity + " not found: " + id);
        }
    }
}
