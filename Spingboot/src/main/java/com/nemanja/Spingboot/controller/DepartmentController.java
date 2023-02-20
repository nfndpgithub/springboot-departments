package com.nemanja.Spingboot.controller;

import com.nemanja.Spingboot.Entity.Department;
import com.nemanja.Spingboot.Service.DepartmentService;
import com.nemanja.Spingboot.error.DepartmentNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/department")
@Slf4j
public class DepartmentController {
    private DepartmentService service;


    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department){
        log.info("inside saveDepartment of DepartmentController");
        return  service.saveDepartment(department);

    }
    @GetMapping
    public List<Department> getDapartments(){
        log.info("inside getDapartments of DepartmentController");
        return  service.getDepartments();
    }
    @GetMapping("/{id}")
    public Department getDapartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return  service.getDapartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        service.deleteDepartmentById(id);
        return "department was deleted";
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department){
        return service.updateDepartment(id, department);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmetnByName(@PathVariable("name")String name){
        return service.getDepartmetnByName(name);
    }



}
