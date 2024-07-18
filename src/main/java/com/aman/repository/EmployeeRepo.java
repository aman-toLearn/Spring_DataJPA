package com.aman.repository;

import com.aman.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

    public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


        //custom queries

    @Query("from Employee")
    public List<Employee> getAllEmpRecords();









    // select * from employee where emp_dept = :dept
    public List<Employee> findByempDept(String dept);

    //select * from employee where emp_gender = :gender
    public  List<Employee>findByempGender(String gender);

    //select * from employee where emp_gender=:gender and emp_dept =:dept
    public List<Employee> findByEmpGenderAndEmpDept(String gender, String dept);

    //select * from employee where emp_salary>= : salary
     public List<Employee> findByEmpSalaryGreaterThanEqual(float salary);

}
