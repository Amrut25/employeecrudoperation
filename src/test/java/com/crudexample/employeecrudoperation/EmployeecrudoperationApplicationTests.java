package com.crudexample.employeecrudoperation;

import com.crudexample.employeecrudoperation.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;

//This is Test runner class
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeecrudoperationApplicationTests {

	@Test
	@Order(1)
	void contextLoads() {
	}
	//This is my test runner class
	//Here you can add your Test cases with the help of @Test annotation
	//This is for Junit testing

	@Test
	@Order(2)
	public void testGetAllEmployees() throws URISyntaxException {
		System.out.println("The test1 started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/serachAllEmps";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	@Order(3)
	public void testParticularGetEmployee() throws URISyntaxException {
		System.out.println("The test2 started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/searchEmpById/4";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	@Order(4)
	public void testCreateEmployee() throws URISyntaxException {
		System.out.println("The test3 Started");
		Employee employee=new Employee();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Employee> request= new HttpEntity<Employee>(employee,headers);
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/addEmployee";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.postForEntity(uri, request,String.class);
		Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
	}

	@Test
	@Order(5)
	public void testUpdateEmployee() throws URISyntaxException {
		System.out.println("The test4 Started");
		Employee employee=new Employee(15,"Amrut Redekar","Kolhapur",50000);
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Employee> request= new HttpEntity<Employee>(employee,headers);
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/updateEmp/15";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.exchange(uri,HttpMethod.PUT,request,String.class);
		Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
	}

	@Test
	@Order(6)
	public void testDeleteEmployee() throws URISyntaxException {
		System.out.println("The test5 Started");
		Employee employee=new Employee();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Employee> request= new HttpEntity<Employee>(employee,headers);
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/deleteEmp/15";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
		Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
	}



}
