package com.nemanja.Spingboot.Service;

import com.nemanja.Spingboot.Entity.Department;
import com.nemanja.Spingboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDapartmentById(Long id) throws DepartmentNotFoundException;


    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmetnByName(String name);
}
