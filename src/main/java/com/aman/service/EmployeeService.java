package com.aman.service;

import com.aman.entity.Employee;
import com.aman.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
//        System.out.println(this.employeeRepo.getClass().getName());
    }

    //finder method

    public void getEmpsByGenderAndDept(String gender , String dept){
        List<Employee> byempGenderAndempDept = employeeRepo.findByEmpGenderAndEmpDept(gender, dept);
    byempGenderAndempDept.forEach(System.out::println);
    }
    public void getEmpsByGender(String gender){
        List<Employee> byempGender = employeeRepo.findByempGender(gender);
        byempGender.forEach(System.out::println);
    }

    public void getEmpsByDept(String dept){
        List<Employee> byempDept = employeeRepo.findByempDept(dept);
        byempDept.forEach(System.out::println);

    }

    public void saveEmployee(){
        Employee  emp = new Employee();
        emp.setEmpId(1);
        emp.setEmpName("JK");
        emp.setEmpDept("Tech");
        emp.setEmpGender("M");
        emp.setEmpSalary(40000.00);

        employeeRepo.save(emp);
    }

//save multiple
    public void saveMultipleEmployee(){
        Employee  emp1 = new Employee();
        emp1.setEmpId(105);
        emp1.setEmpName("JK");
        emp1.setEmpDept("Tech");
        emp1.setEmpGender("M");
        emp1.setEmpSalary(40000.00);

        Employee  emp2 = new Employee();
        emp2.setEmpId(104);
        emp2.setEmpName("JK");
        emp2.setEmpDept("Tech");
        emp2.setEmpGender("M");
        emp2.setEmpSalary(40000.00);

        List<Employee> list = Arrays.asList(emp1, emp2);

        employeeRepo.saveAll(list);

    }

    //get

    public void getEmp(){
        Optional<Employee> byId = employeeRepo.findById(1);
        if(byId.isPresent()) {
            Employee employee = byId.get();
            System.out.println(employee);
        }
    }
//get multiple
    public void getEmps(){
        List<Integer> empIds = Arrays.asList(104, 105);

        Iterable<Employee> itr = employeeRepo.findAllById(empIds);

        itr.forEach(System.out::println);


    }

    //get all

    public void getAllEmps(){


        Iterable<Employee> all = employeeRepo.findAll();
        all.forEach(System.out::println);
    }



}
