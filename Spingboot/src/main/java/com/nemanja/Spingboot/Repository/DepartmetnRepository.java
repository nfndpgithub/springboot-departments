package com.nemanja.Spingboot.Repository;

import com.nemanja.Spingboot.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmetnRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String name);
    public Department findByDepartmentNameIgnoreCase(String name);
}
