package com.jow.departmentservice.controller;

import com.jow.departmentservice.dto.DepartmentDto;
import com.jow.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    @PostMapping("saveDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return  new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }
    @GetMapping("getDepartment/{code}")
    public ResponseEntity<DepartmentDto> getDepartment( @PathVariable String code){
       DepartmentDto  departmentDto =  departmentService.getDepartmentByCode(code);
       return  new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
