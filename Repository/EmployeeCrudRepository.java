package com.imooc.Repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrudRepository extends CrudRepository <Employee, Integer>{

    

}
