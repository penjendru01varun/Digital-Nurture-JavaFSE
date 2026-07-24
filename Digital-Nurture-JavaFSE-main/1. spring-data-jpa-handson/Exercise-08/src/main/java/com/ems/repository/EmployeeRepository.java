package com.ems.repository;

import com.ems.entity.Employee;
import com.ems.projection.EmployeeDto;
import com.ems.projection.EmployeeNameView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee getEmployeeByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId")
    List<Employee> getEmployeesByDepartment(@Param("deptId") Long deptId);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByNameContaining(String name, Pageable pageable);

    List<EmployeeNameView> findAllProjectedBy();

    @Query("SELECT new com.ems.projection.EmployeeDto(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDto> findEmployeeDtos();
}
