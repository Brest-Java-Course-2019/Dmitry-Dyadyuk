package com.epam.courses.hr.dao.employee;


import com.epam.courses.hr.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath:test-dao.xml"})
@Transactional
@Rollback
public class EmployeeDAOImplTest {


    private static final int EXPECTED_NUMBER = 9;
    private static final String EXPECTED_NAME = "Ivan" ;
    private static final String EXPECTED_LAST_NAME = "IVANOV";
    private static final Integer EXPECTED_DEPARTMENT_ID = 1;
    private static final BigDecimal EXPECTED_SALARY = BigDecimal.valueOf(500);
    private static final String NEW_NAME = "Deus";
    private static final String NEW_LAST_NAME = "Vult";
    private static final Integer NEW_DEPARTMENT_ID = 1;
    private static final BigDecimal NEW_SALARY = BigDecimal.valueOf(1200);
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void findAll(){
        Stream<Employee> employeeStream = employeeDAO.findAll();
        assertNotNull(employeeStream);
        assertEquals(EXPECTED_NUMBER, employeeDAO.findAll().count());
    }
    @Test
    public void findById(){
        Employee employee = employeeDAO.findById(1).get();
        assertNotNull(employee);
        assertEquals(EXPECTED_NAME.toLowerCase(), employee.getFirstName().toLowerCase());
        assertEquals(EXPECTED_LAST_NAME.toLowerCase(), employee.getLastName().toLowerCase());
        assertEquals(EXPECTED_DEPARTMENT_ID, employee.getDepartmentId());
        assertEquals(EXPECTED_SALARY, employee.getSalary());
    }

    @Test
    public void add(){
        Stream<Employee> listBeforeAdd = employeeDAO.findAll();
        Employee employee = new Employee();
        employee.setFirstName(NEW_NAME);
        employee.setLastName(NEW_LAST_NAME);
        employee.setDepartmentId(NEW_DEPARTMENT_ID);
        employee.setSalary(NEW_SALARY);
        Employee newEmployee = employeeDAO.add(employee).get();
        Stream<Employee> listAfterAdd = employeeDAO.findAll();
        assertEquals(1, listAfterAdd.count() - listBeforeAdd.count() );

    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setFirstName(NEW_NAME);
        employee.setLastName(NEW_LAST_NAME);
        employee.setDepartmentId(NEW_DEPARTMENT_ID);
        employee.setSalary(NEW_SALARY);
        Employee newEmployee = employeeDAO.add(employee).get();
        assertNotNull(newEmployee.getEmployeeId());
        employee.setFirstName(NEW_NAME + "_2");
        employee.setLastName(NEW_LAST_NAME + "_2");
        employee.setDepartmentId(NEW_DEPARTMENT_ID + 1);
        employee.setSalary(NEW_SALARY.add(BigDecimal.valueOf(10)));
        employeeDAO.update(employee);
        Employee updatedEmployee = employeeDAO.findById(employee.getEmployeeId()).get();
        assertEquals(NEW_NAME +"_2", updatedEmployee.getFirstName());
        assertEquals(NEW_LAST_NAME + "_2", updatedEmployee.getLastName());
    }

    @Test
    public void delete(){
        Stream<Employee> employeeStream = employeeDAO.findAll();
        Employee employee = employeeDAO.findById(1).get();
        employeeDAO.delete(employee.getEmployeeId());

        Assertions.assertThrows(DataAccessException.class,
                () -> {
             employeeDAO.findById(employee.getEmployeeId());
                });
    }

}
