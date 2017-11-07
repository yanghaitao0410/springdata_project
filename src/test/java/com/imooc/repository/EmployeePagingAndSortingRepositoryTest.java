package com.imooc.repository;

import com.imooc.Repository.EmployeeRepository;
import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx = null;

    private PagingAndSortingRepository pagingAndSortingRepository = null;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        pagingAndSortingRepository = ctx.getBean(PagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void pagingTest(){
        //page是从0开始的
        Pageable pageable = new PageRequest(0, 5);
        Page page = pagingAndSortingRepository.findAll(pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前页面的数据的集合：" + page.getContent());
        System.out.println("当前是第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());
        System.out.println("每个页面可以展示的记录数：" + page.getSize());
    }


    /**
     * 测试按照id降序排列，
     * 查询第一页的5条数据
     */
    @Test
    public void pagingAndSortingTest(){

        /**
         * direction：排序规则（升序、降序 或别的）
         * property：按照那个字段进行
         */
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        //page是从0开始的
        Pageable pageable = new PageRequest(0, 5, sort);
        Page page = pagingAndSortingRepository.findAll(pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前页面的数据的集合：" + page.getContent());
        System.out.println("当前是第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());
        System.out.println("每个页面可以展示的记录数：" + page.getSize());
    }

}
