package com.crudexample.employeecrudoperation;

import com.crudexample.employeecrudoperation.dao.EmployeeRepository;
import com.crudexample.employeecrudoperation.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CacheManager {

    //to improve the performance of application i have applied cache in application
    //Cache is a data structure created with hashmap and i have written cron job to load the cache from database
    //cron job -->cache load-->All database entries are get kept in cache and when we want to fetch that data ,we directly fetch
    // it from the cache memory and not from database by doing this performance of the application get increased.

    @Autowired
    EmployeeRepository employeeRepository;

    public static HashMap<Integer, Employee> cache=new HashMap<>();

    @Scheduled(cron = "* * * * * *")//this is cron expression to call this function according to specific time shown by expression
    public void loadCache()
    {
        System.out.println("Cache Loading Started");

        List<Employee> employeeList=employeeRepository.findAll();
        employeeList.forEach(employee -> cache.put(employee.getEmpId(),employee));

        System.out.println("Cache Loading Ended");

    }
}
