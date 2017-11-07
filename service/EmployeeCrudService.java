package com.imooc.service;

import com.imooc.Repository.EmployeeCrudRepository;
import com.imooc.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeCrudService {

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void save(){
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = null;
        for(int i = 0; i < 100; i++){
            employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100 - i);
            employees.add(employee);
        }
        employeeCrudRepository.save(employees);
    }
}
