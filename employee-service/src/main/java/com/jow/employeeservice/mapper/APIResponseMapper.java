package com.jow.employeeservice.mapper;

import com.jow.employeeservice.dto.APIResponseDto;
import com.jow.employeeservice.dto.DepartmentDto;
import com.jow.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface APIResponseMapper {

    APIResponseMapper MAPPER = Mappers.getMapper(APIResponseMapper.class);

    //to return apiresponse dto

    APIResponseDto mapToAPIResponseDto(Employee employee , DepartmentDto department);
}
