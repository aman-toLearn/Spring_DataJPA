package com.aman;

import com.aman.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeService service = context.getBean(EmployeeService.class);
		//service.getAllEmps();
		//service.getEmpsByDept("Tech");
		//service.getEmpsByGender("M");
		service.getEmpsByGenderAndDept("M","Tech");
	}





}
