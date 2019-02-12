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
 * DAO Interface for Salary to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public interface SalaryDao {

    /**
     * Get a list of Salaries
     *
     * @return a list of Salaries
     */
    List<Salary> view();

    /**
     * A count of the Salary table
     *
     * @return int value representing the count of the table
     */
    int viewCount();

    /**
     * Adding a Salary to the table
     *
     * @param empNo
     * @param salary
     * @param fromDate
     * @param toDate
     * @return
     */
    public boolean add(int empNo, int salary, Date fromDate, Date toDate);

    /**
     * Getting Salary by providing the primary key columns
     *
     * @param empNo
     * @param fromDate
     * @return
     */
    public Salary getById(int empNo, Date fromDate);
}
