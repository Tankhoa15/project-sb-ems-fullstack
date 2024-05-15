package com.ntkhoa.ems.service.impl;

import com.ntkhoa.ems.dto.EmployeeDTO;
import com.ntkhoa.ems.entity.Employee;
import com.ntkhoa.ems.mapper.EmployeeMapper;
import com.ntkhoa.ems.repository.EmployeeRepository;
import com.ntkhoa.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = repo.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }
}
