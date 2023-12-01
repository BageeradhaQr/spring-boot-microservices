package com.jow.departmentservice.service;

import com.jow.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartmentByCode(String code);
}
