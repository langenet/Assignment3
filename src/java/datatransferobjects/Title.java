/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;
import java.util.Objects;

/**
 * Data Transfer Object for the Title Table
 *
 * @author Robert Lange and Alexander Riccio Lange and Alexander Riccio
 */
public class Title {

    private int empNo;
    private String title;
    private Date fromDate;
    private Date toDate;

    private Title(Builder builder) {

        this.empNo = builder.empNo;
        this.title = builder.title;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }


    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        hash = 53 * hash + this.empNo;
        hash = 53 * hash + Objects.hashCode(this.title);
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
        final Title other = (Title) obj;
        if (this.empNo != other.empNo) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
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
        private String title;
        private Date fromDate;
        private Date toDate;
        
        public Builder(int empNo,
                String title,
                Date fromDate,
                Date toDate) {
            
            this.empNo = empNo;
            this.title = title;
            this.fromDate = fromDate;
            this.toDate = toDate;
        }
        
        public Title build() {
            return new Title(this);
        }
        
        public Builder setEmpNo(int empNo) {
            this.empNo = empNo;
            return this;
            
        }
        
        public Builder setTitle(String title) {
            this.title = title;
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
