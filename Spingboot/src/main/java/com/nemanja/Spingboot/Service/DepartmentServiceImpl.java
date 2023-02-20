package com.nemanja.Spingboot.Service;

import com.nemanja.Spingboot.Entity.Department;
import com.nemanja.Spingboot.Repository.DepartmetnRepository;
import com.nemanja.Spingboot.error.DepartmentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    DepartmetnRepository repository;

    @Override
    public Department saveDepartment(Department department) {

        return  repository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDapartmentById(Long id) throws DepartmentNotFoundException {

        Optional<Department>department= repository.findById(id);
        if(!department.isPresent())
            throw new DepartmentNotFoundException("there is no such department");

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department depDB=repository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        return repository.save(depDB);
    }

    @Override
    public Department getDepartmetnByName(String name) {
        return repository.findByDepartmentNameIgnoreCase(name);
    }
}
