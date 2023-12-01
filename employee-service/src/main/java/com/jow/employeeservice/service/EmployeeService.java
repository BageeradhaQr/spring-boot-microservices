package com.jow.employeeservice.service;

import com.jow.employeeservice.dto.APIResponseDto;
import com.jow.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public APIResponseDto  getEmployeeById(Long id);

}
