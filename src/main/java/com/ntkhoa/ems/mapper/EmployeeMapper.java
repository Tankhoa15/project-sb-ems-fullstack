package com.ntkhoa.ems.mapper;

import com.ntkhoa.ems.dto.EmployeeDTO;
import com.ntkhoa.ems.entity.Employee;

public class EmployeeMapper {

    // mapping entity to dto
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //mapping dto to entity
    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );
    }
}
