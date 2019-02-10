/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;

/**
 *
 * @author Robert
 */
public class Employee implements DTO{
    private int empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
    private boolean isManager;
    private double salary;
    private String title;
    private String department;
    
    private Employee(Builder builder){
            
            this.empNo = builder.empNo;
            this.birthDate = builder.birthDate;
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.gender = builder.gender;
            this.hireDate = builder.hireDate;
            this.department = builder.department;
    }

    public static class Builder{
        private int empNo;
        private Date birthDate;
        private String firstName;
        private String lastName;
        private String gender;
        private Date hireDate;
        private boolean isManager;
        private double salary;
        private String title;
        private String department;
        
        public Builder( int empNo,
                Date birthDate,
                String firstName, 
                String lastName, 
                String gender,
                Date hireDate,
                String department){
            
            this.empNo = empNo;
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.hireDate = hireDate;
            this.department = department;
            
        }

        public Employee build(){
            return new Employee(this);
        }
        
        public Builder setIsManager(boolean isManager) {
            this.isManager = isManager;
            return this;
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }
    }
    
    // base class starts here
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}
