package com.jow.departmentservice.repository;

import com.jow.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentCode(String code);
}
