package com.epam.courses.hr.dao.employee;

import com.epam.courses.hr.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EmployeeDAOImpl implements EmployeeDAO{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);
    private static final String SELECT_ALL =
            "select employeeId, firstName, LastName, departmentId, salary from employee";
    private static final String FIND_BY_ID =
            "select  employeeId, firstName, lastName, departmentId, salary from employee where employeeId = :employeeId";
    private static final String INSERT =
            "insert into employee (firstName, lastName, departmentId, salary) values (:firstName, :lastName, :departmentId, :salary) ";
    private static final String UPDATE
            = "update employee set firstName = :firstName," +
            " lastName = :lastName," +
            " departmentId = :departmentId," +
            " salary = :salary " +
            " where employeeId = :employeeId";
    private static final String REMOVE =
            "delete from employee where employeeId = :employeeId";
    private static final String EMPLOYEE_ID = "employeeId";
    private static final String FIRST_NAME= "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String DEPARTMENT_ID = "departmentId";
    private static final String SALARY = "salary";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Stream<Employee> findAll() {
        List<Employee> employees = namedParameterJdbcTemplate.query(SELECT_ALL,new EmployeeRowMapper());
        return employees.stream();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(EMPLOYEE_ID, id);
        Employee employee = namedParameterJdbcTemplate.queryForObject(FIND_BY_ID,sqlParameterSource,
                BeanPropertyRowMapper.newInstance(Employee.class));
        return Optional.of(employee);
    }

    @Override
    public Optional<Employee> add(Employee employee) {
        return Optional.of(employee)
                .map(this::insertEmployee)
                .orElseThrow( () -> new IllegalArgumentException("There are some problems"));
    }

    private MapSqlParameterSource initData(Employee employee){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(FIRST_NAME, employee.getFirstName());
        mapSqlParameterSource.addValue(LAST_NAME, employee.getLastName());
        mapSqlParameterSource.addValue(DEPARTMENT_ID, employee.getDepartmentId());
        mapSqlParameterSource.addValue(SALARY, employee.getSalary());
        return mapSqlParameterSource;
    }
    private Optional<Employee> insertEmployee(Employee employee) {
        MapSqlParameterSource mapSqlParameterSource = initData(employee);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Integer result = namedParameterJdbcTemplate.update(INSERT,mapSqlParameterSource, keyHolder);
        LOGGER.debug("add( result update = {}, keyholder = {})", result, keyHolder.getKey().intValue());
        employee.setEmployeeId(keyHolder.getKey().intValue());
        return Optional.of(employee);
    }

    @Override
    public void update(Employee employee) {
        Optional.of(namedParameterJdbcTemplate.update(UPDATE, new BeanPropertySqlParameterSource(employee)))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to update department in DB"));
    }

    private boolean successfullyUpdated(Integer rowNum) {
        return rowNum > 0;
    }

    @Override
    public void delete(Integer id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(EMPLOYEE_ID, id);
        Optional.of(namedParameterJdbcTemplate.update(REMOVE, mapSqlParameterSource))
                .filter(this::successfullyUpdated)
                .orElseThrow(() -> new RuntimeException("Failed to remove department in DB"));

    }

    private class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt(EMPLOYEE_ID));
            employee.setFirstName(resultSet.getString(FIRST_NAME));
            employee.setLastName(resultSet.getString(LAST_NAME));
            employee.setDepartmentId(resultSet.getInt(DEPARTMENT_ID));
            employee.setSalary(resultSet.getBigDecimal(SALARY));
            return employee;
        }
    }
}
