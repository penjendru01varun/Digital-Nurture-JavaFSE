package com.ems.controller;

import com.ems.entity.primary.Department;
import com.ems.entity.primary.Employee;
import com.ems.entity.secondary.DepartmentAudit;
import com.ems.repository.primary.DepartmentRepository;
import com.ems.repository.primary.EmployeeRepository;
import com.ems.repository.secondary.DepartmentAuditRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentAuditRepository auditRepository;

    public EmployeeController(EmployeeRepository employeeRepository,
                              DepartmentRepository departmentRepository,
                              DepartmentAuditRepository auditRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.auditRepository = auditRepository;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department saved = departmentRepository.save(department);
        auditRepository.save(new DepartmentAudit(saved.getId(), "CREATED", "system"));
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
            employee.setDepartment(dept);
        }
        Employee saved = employeeRepository.save(employee);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @GetMapping("/audit/department/{departmentId}")
    public List<DepartmentAudit> getAuditByDepartment(@PathVariable Long departmentId) {
        return auditRepository.findByDepartmentId(departmentId);
    }
}
