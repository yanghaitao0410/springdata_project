package com.imooc.Repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
