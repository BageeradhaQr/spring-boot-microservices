package com.jow.employeeservice.service;

import com.jow.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
public interface APIClient {
    //build get department api
    @GetMapping("department-service/api/departments/getDepartment/{code}")
    public DepartmentDto getDepartment(@PathVariable String code);
}
