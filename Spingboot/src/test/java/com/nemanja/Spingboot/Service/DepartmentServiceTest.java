package com.nemanja.Spingboot.Service;

import com.nemanja.Spingboot.Entity.Department;
import com.nemanja.Spingboot.Repository.DepartmetnRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmetnRepository repository;
    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("itsss")
                .departmentAddress("Mihaila Tolbuhina").departmentCode("111")
                .dapartmentId(1L).build();

        Mockito.when(repository.findByDepartmentNameIgnoreCase("itsss")).thenReturn(department);
    }
    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="itsss";
        Department found= departmentService.getDepartmetnByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}