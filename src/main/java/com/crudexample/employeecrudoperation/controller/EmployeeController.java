package com.crudexample.employeecrudoperation.controller;

import com.crudexample.employeecrudoperation.CacheManager;
import com.crudexample.employeecrudoperation.dao.EmployeeRepository;
import com.crudexample.employeecrudoperation.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/getmsg/{name}")
     public String getMessage(@PathVariable String name)
    {
        
        Calendar c = Calendar.getInstance();
        int hours = c.get(Calendar.HOUR_OF_DAY);

        System.out.println(hours);

         if(hours>=0  && hours<=12 ){
             String greetings="Good Morning" + " " + name;
             return greetings;
         }else if(hours>=12 && hours<=16){
             String greetings="Good AfterNoon" + " " + name;
             return greetings;
         }else if(hours>=16 && hours<=21){
             String greetings="Good Evening" + " " + name;
             return greetings;
         }else if(hours>=21 && hours<=24){
             String greetings="Good Night" + " " + name;
             return greetings;
         }
         return "No Message";
     }
     //Cache is used to improve the performance of the application
    //It acts as a temporary storage area that the computer's processor can retrieve data from easily. This temporary storage area, known as a cache,
    // is more readily available to the processor than the computer's main memory source, typically some form of DRAM.

    //Create Employee
    //To perform create related actions we use PostMapping

    @PostMapping("/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        //return cache.put(employee.getEmpId(), employee).toString();
        return employeeRepository.save(employee);
    }

    //Search all Employees
    @GetMapping("/serachAllEmps")
    public Collection<Employee> getAllEmployees()
    {
        return CacheManager.cache.values();
        // return employeeRepository.findAll();
    }

    //Search Particular Employee by ID
    //to avoid null pointer exception we use Optional
    @GetMapping("/searchEmpById/{empId}")
    public Optional<Employee> getEmployee(@PathVariable int empId)
    {
        return Optional.ofNullable(CacheManager.cache.get(empId));
       // return employeeRepository.findById(empId);
    }

    //Update a specific employee only one at a time
    @PutMapping("/updateEmp/{empId}")
    public String updateEmployee(@PathVariable int empId,@RequestBody Employee employee)
    {
        Optional<Employee> employee1=employeeRepository.findById(empId);

        if(employee1.isPresent())
        {
            return employeeRepository.save(employee).toString();
        }
        else
        {
            return "The Employee with given ID " + empId + " is not present";
        }
    }

    //Delete specific Employee
    @DeleteMapping("/deleteEmp/{empId}")
    public String deleteEmployee(@PathVariable int empId)
    {
        Optional<Employee> employee1=employeeRepository.findById(empId);

        if (employee1.isPresent())
        {
            employeeRepository.deleteById(empId);
            return "The Employee is deleted as per mentioned by employee ID";
        }
        else
        {
            return "The Employee you are seeking to delete is not present";
        }
    }

}
