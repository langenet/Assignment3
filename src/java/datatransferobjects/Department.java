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
public class Department implements DTO {

    private String deptNo;
    private String deptName;

    private Department(Builder builder) {

        this.deptNo = builder.deptNo;
        this.deptName = builder.deptName;
    }

    public static class Builder {

        private String deptNo;
        private String deptName;

        public Builder(String deptNo, String deptName) {

            this.deptNo = deptNo;
            this.deptName = deptName;
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
}
