package com.example.enrollapi.controllers;


import com.example.enrollapi.model.Dependents;
import com.example.enrollapi.model.Enrollee;
import com.example.enrollapi.services.EnrolleeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnrolleeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EnrolleeService enrolleeService;

    Enrollee enrollee;

    @Before
    public void setUp() {
        Dependents dependents = new Dependents(101L, "Jobs", new Date(13081989));
        Set dependentsSet = new HashSet<>();
        dependentsSet.add(dependents);
        enrollee = new Enrollee(101L, "Steve", true,
                "8390613173", new Date(13081987), dependentsSet);
    }

    @Test
    public void shouldReturnOkResponseWhenGetTheEnrolleeForInput() throws Exception {
        Long input = 101L;
        Mockito.when(enrolleeService.getEnrolleeById(input)).thenReturn(enrollee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/101");
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOkResponseWhenCreateOrUpdateEnrollee() throws Exception {
        Mockito.when(enrolleeService.createOrUpdateEnrollee(enrollee)).thenReturn(enrollee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/enrollee");
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

}