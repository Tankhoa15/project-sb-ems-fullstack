package com.ntkhoa.ems.service.impl;

import com.ntkhoa.ems.dto.EmployeeDTO;
import com.ntkhoa.ems.entity.Employee;
import com.ntkhoa.ems.exception.ResourceNotFoundException;
import com.ntkhoa.ems.mapper.EmployeeMapper;
import com.ntkhoa.ems.repository.EmployeeRepository;
import com.ntkhoa.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        employee = repo.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exits with id: " + id));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = repo.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exits!"));

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        employee = repo.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee not exits!"));

        repo.deleteById(id);
    }
}
