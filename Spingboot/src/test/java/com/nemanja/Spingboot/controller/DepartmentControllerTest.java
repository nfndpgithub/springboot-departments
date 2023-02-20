package com.nemanja.Spingboot.controller;

import com.nemanja.Spingboot.Entity.Department;
import com.nemanja.Spingboot.Service.DepartmentService;
import com.nemanja.Spingboot.error.DepartmentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {
        department=Department.builder().dapartmentId(1L).departmentName("itsss").departmentAddress("Mihaila Tolbuhina")
                .departmentCode("111").build();

    }

    @Test
    void saveDepartment() throws Exception {
         Department inputDepartment=Department.builder().departmentName("itsss").departmentAddress("Mihaila Tolbuhina")
                 .departmentCode("111").build();


        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(post("/department").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"departmentName\":\"itsss\",\n" +
                "    \"departmentAddress\":\"Mihaila Tolbuhina\",\n" +
                "    \"departmentCode\":\"111\"\n" +
                "}")).andExpect(status().isOk());

    }

    @Test
    void getDapartmentById() throws Exception {
        Mockito.when(departmentService.getDapartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/department/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}