package com.aman.service;

import com.aman.entity.Employee;
import com.aman.repository.EmployeeRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //custom queries
    public void getAllEmpRecords(){


        Iterable<Employee> all = employeeRepo.findAll();
        all.forEach(System.out::println);
    }

    public void get2AllEmpRecords(){

        Sort sort = Sort.by("empId").descending();

        Iterable<Employee> all = employeeRepo.findAll(sort);
        all.forEach(System.out::println);
    }

    // taking the column name as a input by which we want to sort
//                  Sorting
    public void get3AllEmpRecords(String column){

        Sort sort = Sort.by(column).descending();

        Iterable<Employee> all = employeeRepo.findAll(sort);
        all.forEach(System.out::println);


    }
//              Paging
    public  void getEmpsWithPagination(int pageSize,int pageNo){

        PageRequest of = PageRequest.of(pageNo-1, pageSize);

        Page<Employee> findAll = employeeRepo.findAll(of);
        List<Employee> content = findAll.getContent();
        content.forEach(System.out::println);


    }


//          QBE   query by example



public void getEmpsByQBE(){

    Employee employee = new Employee();
    employee.setEmpDept("Tech");
    employee.setEmpId(1);

              // this employee/entity object we need to convert to Example object
    Example<Employee> employeeExample = Example.of(employee);

    List<Employee> all = employeeRepo.findAll(employeeExample);
    all.forEach(e-> System.out.println(e));


}





















    //finder method

    public  void getEmpsBySalary(float salary){
        List<Employee> emps = employeeRepo.findByEmpSalaryGreaterThanEqual(salary);
        emps.forEach(System.out::println);
    }

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
