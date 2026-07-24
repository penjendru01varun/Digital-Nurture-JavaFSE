package com.ems.controller;

import com.ems.entity.Department;
import com.ems.projection.DepartmentNameView;
import com.ems.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department dept) {
        Department existing = departmentRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(dept.getName());
            return departmentRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

    @GetMapping("/names")
    public List<DepartmentNameView> getDepartmentNames() {
        return departmentRepository.findAllProjectedBy();
    }
}
