package com.restaurantmanagement.api;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.restaurantmanagement.service.RestaurantService;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestaurantService restaurantService;

    @Test
    void listsBranchesAsJson() throws Exception {
        when(restaurantService.getBranches()).thenReturn(List.of(
                Map.of("code", "Hyd", "name", "Hyderabad")));

        mockMvc.perform(get("/api/branches"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("Hyd"))
                .andExpect(jsonPath("$[0].name").value("Hyderabad"));
    }

    @Test
    void rejectsInvalidEmployeePayload() throws Exception {
        mockMvc.perform(post("/api/employees")
                        .contentType("application/json")
                        .content("""
                                {
                                  "empId": 0,
                                  "name": "",
                                  "designation": "Waiter",
                                  "email": "not-an-email",
                                  "branch": "Hyd",
                                  "age": 15,
                                  "salary": -1,
                                  "gender": "MM"
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").exists());

        verifyNoInteractions(restaurantService);
    }
}
