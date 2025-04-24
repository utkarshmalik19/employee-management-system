package com.utkarsh.ems.dao;

import com.utkarsh.ems.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
