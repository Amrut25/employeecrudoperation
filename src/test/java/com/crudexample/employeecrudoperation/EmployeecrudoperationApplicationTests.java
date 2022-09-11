package com.crudexample.employeecrudoperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;

//This is Test runner class
@SpringBootTest
class EmployeecrudoperationApplicationTests {

	@Test
	void contextLoads() {
	}
	//This is my test runner class
	//Here you can add your Test cases with the help of @Test annotation

	@Test
	@Order(2)
	public void testGetAllEmployees() throws URISyntaxException {
		System.out.println("The test started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/serachAllEmps";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	@Order(1)
	public void testParticularGetEmployee() throws URISyntaxException {
		System.out.println("The test started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/searchEmpById/4";
		URI uri=new URI(url);
		ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
	}

}
