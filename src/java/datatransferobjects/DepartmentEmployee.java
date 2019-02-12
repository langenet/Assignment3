/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object for the Department Employee Table
 *
 * @author Robert Lange and Alexander Riccio
 */
public class DepartmentEmployee {

    private int empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;

    private DepartmentEmployee(Builder builder) {

        this.empNo = builder.empNo;
        this.deptNo = builder.deptNo;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }


    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
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
        int hash = 3;
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
        final DepartmentEmployee other = (DepartmentEmployee) obj;
        if (this.empNo != other.empNo) {
            return false;
        }
        if (!Objects.equals(this.deptNo, other.deptNo)) {
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
        private String deptNo;
        private Date fromDate;
        private Date toDate;
        
        public Builder(int empNo,
                String deptNo,
                Date fromDate,
                Date toDate) {
            
            this.empNo = empNo;
            this.deptNo = deptNo;
            this.fromDate = fromDate;
            this.toDate = toDate;
        }
        
        public DepartmentEmployee build() {
            return new DepartmentEmployee(this);
        }
        
        public Builder setEmpNo(int empNo) {
            this.empNo = empNo;
            return this;
        }
        
        public Builder setDeptNo(String deptNo) {
            this.deptNo = deptNo;
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
