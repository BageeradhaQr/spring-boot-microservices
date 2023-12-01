package com.jow.employeeservice.service.impl;

import com.jow.employeeservice.dto.APIResponseDto;
import com.jow.employeeservice.dto.DepartmentDto;
import com.jow.employeeservice.dto.EmployeeDto;
import com.jow.employeeservice.entity.Employee;
import com.jow.employeeservice.mapper.APIResponseMapper;
import com.jow.employeeservice.mapper.EmployeeMapper;
import com.jow.employeeservice.repository.EmployeeRepository;
import com.jow.employeeservice.service.APIClient;
import com.jow.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;
    //injecting web client to perform reactive non-blocking (asynchronous) operations
    //private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //dto to entity
        Employee emp = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(emp);
        //entity to dto
        EmployeeDto dto = EmployeeMapper.MAPPER.mapToEmpDto(savedEmployee);
        return dto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        //use restTemplate to get department code for particular employee

        /*ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/api/departments/getDepartment/"+employee.getDepartmentCode()
                        , DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/
        /*DepartmentDto departmentDto =  webClient.get()
                .uri("http://localhost:8080/api/departments/getDepartment/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        //entity to dto
        //EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmpDto(employee);
        APIResponseDto apiResponseDto = APIResponseMapper.MAPPER.mapToAPIResponseDto(employee,departmentDto);
        return apiResponseDto;
    }
}
