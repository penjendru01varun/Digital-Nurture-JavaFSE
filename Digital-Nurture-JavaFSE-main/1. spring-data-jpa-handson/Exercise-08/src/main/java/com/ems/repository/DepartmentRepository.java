package com.ems.repository;

import com.ems.entity.Department;
import com.ems.projection.DepartmentNameView;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
    List<DepartmentNameView> findAllProjectedBy();
}
