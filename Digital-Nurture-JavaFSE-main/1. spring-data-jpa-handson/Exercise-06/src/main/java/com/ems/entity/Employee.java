package com.ems.entity;

import jakarta.persistence.*;

@NamedQueries({
    @NamedQuery(name = "Employee.findByEmail",
                query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByDepartmentId",
                query = "SELECT e FROM Employee e WHERE e.department.id = :deptId")
})
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }
}
