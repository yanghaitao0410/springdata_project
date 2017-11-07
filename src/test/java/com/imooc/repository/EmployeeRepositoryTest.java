package com.imooc.repository;

import com.imooc.Repository.EmployeeRepository;
import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }


    @Test
    public void testFindByName() {
        System.out.println(employeeRepository);
        //org.springframework.data.jpa.repository.support.SimpleJpaRepository@3eba57a7
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id: " + employee.getId()
                + ", name: " + employee.getName()
                + ", age: " + employee.getAge());
    }

    @Test
    public void testFindNameByStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 22);
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId()
                    + ", name: " + employee.getName()
                    + ", age: " + employee.getAge());
        }
    }

    @Test
    public void testFindNameByEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23);
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId() +
                    ", name: " + employee.getName() +
                    ", age: " + employee.getAge());
        }
    }

    @Test
    public void testFindNameByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId()
                    + ", name: " + employee.getName()
                    + ", age: " + employee.getAge());
        }
    }

    @Test
    public void testGetEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeebyMaxId();
        System.out.println("id: " + employee.getId() + ", name: " + employee.getName()
                + ", age: " + employee.getAge());
    }

    @Test
    public void testQueryParam1(){
        List<Employee> employees = employeeRepository.queryParam1("test1", 20);
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId()
                    + ", name: " + employee.getName()
                    + ", age: " + employee.getAge());
        }
    }

    @Test
    public void testQueryParam2(){
        List<Employee> employees = employeeRepository.queryParam2("test1", 20);
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId()
                    + ", name: " + employee.getName()
                    + ", age: " + employee.getAge());
        }
    }

    @Test
    public void queryLike1(){
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId()
                    + ", name: " + employee.getName()
                    + ", age: " + employee.getAge());
        }
    }

    @Test
    public void queryLike2(){
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println("id: " + employee.getId()
                    + ", name: " + employee.getName()
                    + ", age: " + employee.getAge());
        }
    }

    @Test
    public void testGetCount(){
        System.out.println("count: " + employeeRepository.getCount());
    }

}
