/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object for the Employee Table
 *
 * @author Robert Lange and Alexander Riccio
 */
public class Employee {

    private int empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;

    private Employee(Builder builder) {

        this.empNo = builder.empNo;
        this.birthDate = builder.birthDate;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.hireDate = builder.hireDate;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.empNo;
        hash = 53 * hash + Objects.hashCode(this.birthDate);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.gender);
        hash = 53 * hash + Objects.hashCode(this.hireDate);
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

    public static class Builder {

        private int empNo;
        private Date birthDate;
        private String firstName;
        private String lastName;
        private String gender;
        private Date hireDate;

        public Builder(int empNo,
                Date birthDate,
                String firstName,
                String lastName,
                String gender,
                Date hireDate) {

            this.empNo = empNo;
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.hireDate = hireDate;

        }

        public Employee build() {
            return new Employee(this);
        }

        public Builder setEmpNo(int empNo) {
            this.empNo = empNo;
            return this;

        }

        public Builder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;

        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;

        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;

        }

        public Builder setHireDate(Date hireDate) {
            this.hireDate = hireDate;
            return this;
        }
    }

}
