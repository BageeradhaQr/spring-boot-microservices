package com.jow.departmentservice.service.impl;

import com.jow.departmentservice.dto.DepartmentDto;
import com.jow.departmentservice.entity.Department;
import com.jow.departmentservice.repository.DepartmentRepository;
import com.jow.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());
        Department saveDepartment = departmentRepository.save(department);
        DepartmentDto dto = new DepartmentDto(saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode());
        return dto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {

        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode());

        return departmentDto;
    }
}
