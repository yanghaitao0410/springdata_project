package com.imooc.domain;

import javax.persistence.*;

/**
 * 雇员:  先开发实体类===>自动生成数据表
 * @Table : 指定该实体类对应的表名，若不指定默认为实体类大写
 */
@Entity
@Table(name = "emp_crud")
public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
