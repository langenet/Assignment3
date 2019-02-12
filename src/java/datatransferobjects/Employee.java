/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Robert
 */
public class Employee{
    private int empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
    private boolean isManager;
    private int salary;
    private String title;
    private Department department;
    
    private Employee(Builder builder){
            
            this.empNo = builder.empNo;
            this.birthDate = builder.birthDate;
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.gender = builder.gender;
            this.hireDate = builder.hireDate;
    }

    public static class Builder{
        private int empNo;
        private Date birthDate;
        private String firstName;
        private String lastName;
        private String gender;
        private Date hireDate;
        private boolean isManager;
        private int salary;
        private String title;
        private Department department;
        
        public Builder( int empNo,
                Date birthDate,
                String firstName, 
                String lastName, 
                String gender,
                Date hireDate){
            
            this.empNo = empNo;
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.hireDate = hireDate;
            
        }

        public Employee build(){
            return new Employee(this);
        }
        
        public Builder setIsManager(boolean isManager) {
            this.isManager = isManager;
            return this;
        }

        public Builder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Builder setDepartment(Department department) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.empNo;
        hash = 29 * hash + Objects.hashCode(this.birthDate);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.gender);
        hash = 29 * hash + Objects.hashCode(this.hireDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.empNo != other.empNo) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.hireDate, other.hireDate)) {
            return false;
        }
        return true;
    }
    
    
}
