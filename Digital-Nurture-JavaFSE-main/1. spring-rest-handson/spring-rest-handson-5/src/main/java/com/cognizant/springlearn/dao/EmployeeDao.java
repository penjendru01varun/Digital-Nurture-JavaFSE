package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {
    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        if (EMPLOYEE_LIST == null) {
            ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
            EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(id)) {
                EMPLOYEE_LIST.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }
}
