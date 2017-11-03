package com.imooc.Repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Repository.class, idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee, Integer> {

    Employee findByName(String name);
}
