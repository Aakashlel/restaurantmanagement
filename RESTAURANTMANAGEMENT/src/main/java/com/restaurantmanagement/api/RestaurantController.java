package com.restaurantmanagement.api;

import com.restaurantmanagement.service.RestaurantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/branches")
    public List<Map<String, String>> branches() {
        return restaurantService.getBranches();
    }

    @GetMapping("/employees")
    public List<Map<String, Object>> employees(@RequestParam(required = false) String branch) {
        return restaurantService.getEmployees(branch);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addEmployee(@Valid @RequestBody EmployeeRequest request) {
        return restaurantService.addEmployee(request);
    }

    @PutMapping("/employees/{id}")
    public Map<String, Object> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeRequest request) {
        return restaurantService.updateEmployee(id, request);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployee(@PathVariable int id) {
        restaurantService.removeEmployee(id);
    }

    @GetMapping("/menu")
    public List<Map<String, Object>> menu(@RequestParam(required = false) String branch) {
        return restaurantService.getMenu(branch);
    }

    @PostMapping("/menu")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addMenuItem(@Valid @RequestBody MenuRequest request) {
        return restaurantService.addMenuItem(request);
    }

    @PutMapping("/menu/{branch}/{dishId}")
    public Map<String, Object> updateMenuItem(@PathVariable String branch, @PathVariable int dishId,
            @Valid @RequestBody MenuRequest request) {
        return restaurantService.updateMenuItem(branch, dishId, request);
    }

    @DeleteMapping("/menu/{branch}/{dishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMenuItem(@PathVariable String branch, @PathVariable int dishId) {
        restaurantService.removeMenuItem(branch, dishId);
    }

    @GetMapping("/orders")
    public List<Map<String, Object>> orders(@RequestParam(required = false) String status) {
        return restaurantService.getOrders(status);
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addOrderItem(@Valid @RequestBody OrderRequest request) {
        return restaurantService.addOrderItem(request);
    }

    @PutMapping("/orders/{id}/items/{item}")
    public Map<String, Object> updateOrderItem(@PathVariable int id, @PathVariable String item,
            @Valid @RequestBody QuantityRequest request) {
        return restaurantService.updateOrderItem(id, item, request.quantity());
    }

    @DeleteMapping("/orders/{id}/items/{item}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeOrderItem(@PathVariable int id, @PathVariable String item) {
        restaurantService.removeOrderItem(id, item);
    }

    @DeleteMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelOrder(@PathVariable int id) {
        restaurantService.cancelOrder(id);
    }

    @PatchMapping("/orders/{id}/complete")
    public Map<String, Object> completeOrder(@PathVariable int id) {
        return restaurantService.completeOrder(id);
    }

    @PostMapping("/orders/{id}/payment")
    public Map<String, Object> makePayment(@PathVariable int id, @Valid @RequestBody PaymentRequest request) {
        return restaurantService.makePayment(id, request.paidAmount());
    }

    @GetMapping("/reservations")
    public List<Map<String, Object>> reservations(@RequestParam(required = false) String branch) {
        return restaurantService.getReservations(branch);
    }

    @PostMapping("/reservations")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> makeReservation(@Valid @RequestBody ReservationRequest request) {
        return restaurantService.makeReservation(request);
    }

    @DeleteMapping("/reservations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelReservation(@PathVariable int id) {
        restaurantService.cancelReservation(id);
    }

    @PatchMapping("/reservations/{id}/occupy")
    public Map<String, Object> occupyReservation(@PathVariable int id) {
        return restaurantService.occupyReservation(id);
    }

    @GetMapping("/seating")
    public List<Map<String, Object>> seating(@RequestParam(required = false) String branch) {
        return restaurantService.getSeating(branch);
    }

    public record EmployeeRequest(
            @NotNull @Positive Integer empId,
            @NotBlank @Size(max = 100) String name,
            @NotBlank @Size(max = 30) String designation,
            @NotBlank @Email @Size(max = 100) String email,
            @NotBlank @Size(max = 3) String branch,
            @NotNull @Min(16) Integer age,
            @NotNull @Min(0) Integer salary,
            @NotBlank @Size(min = 1, max = 1) String gender) {
    }

    public record MenuRequest(
            @NotNull @Positive Integer dishId,
            @NotBlank @Size(max = 100) String name,
            @NotNull @Min(0) Integer price,
            @NotBlank @Size(max = 30) String foodType,
            @NotBlank @Size(max = 3) String branch) {
    }

    public record OrderRequest(
            @NotNull @Positive Integer id,
            @NotBlank @Size(max = 100) String item,
            @NotNull @Positive Integer quantity) {
    }

    public record QuantityRequest(@NotNull @Positive Integer quantity) {
    }

    public record PaymentRequest(@NotNull @Min(0) Integer paidAmount) {
    }

    public record ReservationRequest(
            @NotNull @Positive Integer id,
            @NotBlank @Size(max = 100) String customerName,
            @NotBlank @Size(max = 3) String branch,
            @NotNull @Min(1) @jakarta.validation.constraints.Max(10) Integer guests,
            @NotNull LocalTime timeSlot) {
    }
}
