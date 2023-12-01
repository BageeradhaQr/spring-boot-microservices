package com.jow.employeeservice.mapper;

import com.jow.employeeservice.dto.EmployeeDto;
import com.jow.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    //to return employee dto
    EmployeeDto mapToEmpDto(Employee employee);

    //to return employee entity

    Employee mapToEmployee(EmployeeDto employeeDto);
}
