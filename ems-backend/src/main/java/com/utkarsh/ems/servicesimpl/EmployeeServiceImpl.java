package com.utkarsh.ems.servicesimpl;

import com.utkarsh.ems.dao.EmployeeRepository;
import com.utkarsh.ems.dto.EmployeeDto;
import com.utkarsh.ems.exceptions.ResourceNotFoundException;
import com.utkarsh.ems.mapper.EmployeeMapper;
import com.utkarsh.ems.pojo.Employee;
import com.utkarsh.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
