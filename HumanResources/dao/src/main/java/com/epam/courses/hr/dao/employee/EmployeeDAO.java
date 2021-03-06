package com.epam.courses.hr.dao.employee;

import com.epam.courses.hr.model.Employee;

import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeDAO {
    Stream<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Optional<Employee> add(Employee employee);
    void update(Employee employee);
    void delete(Integer id);
}
