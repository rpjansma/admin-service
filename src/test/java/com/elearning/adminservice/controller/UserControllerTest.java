package com.elearning.adminservice.controller;

import com.elearning.adminservice.service.UserService;
import com.elearning.adminservice.service.integration.UserServiceApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    UserService userService;

    @Mock
    UserServiceApi userServiceApi;

    UserController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void getAllUsers() throws Exception {
        controller = new UserController(userService, userServiceApi);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/v1/users/")).andExpect(status().isOk());
    }

    @Test
    void getExternalUserById() throws Exception {
        controller = new UserController(userService, userServiceApi);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();


        mockMvc.perform(get("/api/v1/users/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists());
    }

    @Test
    void getExternalUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}