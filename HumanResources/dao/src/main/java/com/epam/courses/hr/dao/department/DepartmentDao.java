package com.epam.courses.hr.dao.department;

import com.epam.courses.hr.model.Department;

import java.util.Optional;
import java.util.stream.Stream;

public interface DepartmentDao {
    Stream<Department> findAll();
    Optional<Department> findById(Integer id);
    Optional<Department> add(Department department);
    void update(Department department);
    void delete(int departmentId);
}