package com.aman.repository;

import com.aman.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

    // select * from employee where emp_dept = :dept
    public List<Employee> findByempDept(String dept);

    //select * from employee where emp_gender = :gender
    public  List<Employee>findByempGender(String gender);

    //select * from employee where emp_gender=:gender and emp_dept =:dept
    public List<Employee> findByEmpGenderAndEmpDept(String gender, String dept);


}
