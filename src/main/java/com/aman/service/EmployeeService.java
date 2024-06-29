package com.aman.service;

import com.aman.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private  EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
        System.out.println(this.employeeRepo.getClass().getName());
    }
}
