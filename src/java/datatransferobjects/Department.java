/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Objects;

/**
 * Data Transfer Object for the Department Table
 * @author Robert Lange and Alexander Riccio
 */
public class Department {

    private String deptNo;
    private String deptName;

    private Department(Builder builder) {

        this.deptNo = builder.deptNo;
        this.deptName = builder.deptName;
    }


    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.deptNo);
        hash = 29 * hash + Objects.hashCode(this.deptName);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.deptNo, other.deptNo)) {
            return false;
        }
        if (!Objects.equals(this.deptName, other.deptName)) {
            return false;
        }
        return true;
    }
    public static class Builder {
        
        private String deptNo;
        private String deptName;
        public Department build;
        
        public Builder(String deptNo, String deptName) {
            this.deptNo = deptNo;
            this.deptName = deptName;
        }
        
        public Department build(){
            return new Department(this);
        }
        
        public Builder setDeptNo(String deptNo) {
            this.deptNo = deptNo;
            return this;
        }
        
        public Builder setDeptName(String deptName) {
            this.deptName = deptName;
            return this;
        }
        
    }
    
    
}
