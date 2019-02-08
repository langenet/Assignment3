/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatransferobjects;

import java.util.Date;

/**
 *
 * @author alexr
 */
public class DepartmentEmployee implements DTO {

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
}
