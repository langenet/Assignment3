/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Salary;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexr
 */
public interface SalaryDao {

    List<Salary> view();

    int viewCount();

    public boolean add(int empNo, int salary, Date fromDate, Date toDate);

    public Salary getById(int empNo, Date fromDate);
}
