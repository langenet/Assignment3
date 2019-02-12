/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object for the Salary Table
 *
 * @author Robert Lange and Alexander Riccio
 */
public class Salary {

    private int empNo;
    private int salary;
    private Date fromDate;
    private Date toDate;

    private Salary(Builder builder) {

        this.empNo = builder.empNo;
        this.salary = builder.salary;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }


    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.empNo;
        hash = 53 * hash + this.salary;
        hash = 53 * hash + Objects.hashCode(this.fromDate);
        hash = 53 * hash + Objects.hashCode(this.toDate);
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
        final Salary other = (Salary) obj;
        if (this.empNo != other.empNo) {
            return false;
        }
        if (this.salary != other.salary) {
            return false;
        }
        if (!Objects.equals(this.fromDate, other.fromDate)) {
            return false;
        }
        if (!Objects.equals(this.toDate, other.toDate)) {
            return false;
        }
        return true;
    }

  
    public static class Builder {
        
        private int empNo;
        private int salary;
        private Date fromDate;
        private Date toDate;
        
        public Builder(int empNo,
                int salary,
                Date fromDate,
                Date toDate) {
            
            this.empNo = empNo;
            this.salary = salary;
            this.fromDate = fromDate;
            this.toDate = toDate;
        }
        
        public Salary build() {
            return new Salary(this);
        }
        
        public Builder setEmpNo(int empNo) {
            this.empNo = empNo;
            return this;
        }
        
        public Builder setSalary(int salary) {
            this.salary = salary;
            return this;
            
        }
        
        public Builder setFromDate(Date fromDate) {
            this.fromDate = fromDate;
            return this;
            
        }
        
        public Builder setToDate(Date toDate) {
            this.toDate = toDate;
            return this;
            
        }
    }

}
