package com.jow.employeeservice.controller;

import com.jow.employeeservice.dto.APIResponseDto;
import com.jow.employeeservice.dto.EmployeeDto;
import com.jow.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;
    @PostMapping("saveEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto dto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("getEmployeeById/{id}")
    public  ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id){
        APIResponseDto dto = employeeService.getEmployeeById(id);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
