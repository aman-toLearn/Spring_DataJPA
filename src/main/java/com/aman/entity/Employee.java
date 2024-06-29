package com.aman.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private  Integer empId;
    private String empName;
    private Double empSalary;

    private String empGender;
    private String empDept;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empGender='" + empGender + '\'' +
                ", empDept='" + empDept + '\'' +
                '}';
    }

    public Employee(Integer empId, String empName, Double empSalary, String empGender, String empDept) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empGender = empGender;
        this.empDept = empDept;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }
}
