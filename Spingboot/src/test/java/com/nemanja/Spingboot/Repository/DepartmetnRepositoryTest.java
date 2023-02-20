package com.nemanja.Spingboot.Repository;

import com.nemanja.Spingboot.Entity.Department;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmetnRepositoryTest {
    @Autowired
    private DepartmetnRepository repository;
    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department= Department.builder().departmentName("mechanical engerering").departmentAddress("Beograd")
                .departmentCode("ME-011").build();

        entityManager.persist(department);
    }
    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department=repository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"mechanical engerering");

    }
}