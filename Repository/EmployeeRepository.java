package com.imooc.Repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee, Integer> {

    Employee findByName(String name);

    //where name like ?% and age < ?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    //where name like %? and age < ?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    //where name in(?, ?, ?) or age < ?
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    @Query("select emp from Employee emp where emp.id = (select max(id) from Employee emp1)")
    Employee getEmployeebyMaxId();

    /**
     * 使用命名参数或是索引参数查询
     * 查询匹配姓名和年龄的员工
     * @param name
     * @param age
     * @return
     */
    @Query("select emp from Employee emp where emp.name = ?1 and emp.age = ?2")
    List<Employee> queryParam1(String name, Integer age);

    /**
     * 使用索引参数的方法查询
     * @param name
     * @param age
     * @return
     */
    @Query("select emp from Employee emp where emp.name = :name and emp.age = :age")
    List<Employee> queryParam2(@Param("name")String name, @Param("age")Integer age);

    /**
     * 使用like模糊查询 前后匹配 ：占位符方式
     * @param name
     * @return
     */
    @Query("select emp from Employee emp where emp.name like %?1%")
    List<Employee> queryLike1(String name);

    /**
     * 使用like模糊查询 前后匹配 ：索引参数方式
     * @param name
     * @return
     */
    @Query("select emp from Employee emp where emp.name like %:name%")
    List<Employee> queryLike2(@Param("name")String name);

    /**
     * 使用原生sql语句，需要将nativeQuery设置为true 默认为false
     * 此时的employee为数据库中的表名
     * @return
     */
    @Query(nativeQuery = true, value = "select count(1) from employee")
    Long getCount();

    @Modifying
    @Query("update Employee emp set emp.age = :age where emp.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);



}
