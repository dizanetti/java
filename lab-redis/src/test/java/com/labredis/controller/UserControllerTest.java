package com.labredis.controller;

import com.labredis.model.User;
import com.labredis.usecase.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    private static final String URL_TEMPLATE = "/user";
    private static final String URL_TEMPLATE_USER_FIND = "/user/find/1";
    private static final String URL_TEMPLATE_USER_UPDATE = "/user/update/1";
    private static final String URL_TEMPLATE_USER_DELETE = "/user/delete/1";

    private static final long ID_USER = 1L;

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void test() {
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());

        mockMvc.perform(get(URL_TEMPLATE))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void test2() {
        when(userService.findById(any())).thenReturn(new User());

        mockMvc.perform(get(URL_TEMPLATE_USER_FIND))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void test3() {
        when(userService.save(any())).thenReturn(new User());

        mockMvc.perform(post(URL_TEMPLATE)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\",\"followers\":10}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void test4() {
        when(userService.update(any(), any())).thenReturn(new User());

        mockMvc.perform(put(URL_TEMPLATE_USER_UPDATE)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test\",\"followers\":100}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void test5() {
        when(userService.delete(any())).thenReturn(ID_USER);

        mockMvc.perform(delete(URL_TEMPLATE_USER_DELETE))
                .andExpect(status().isOk());
    }
}