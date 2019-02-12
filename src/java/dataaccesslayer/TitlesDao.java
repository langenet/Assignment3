/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import datatransferobjects.Title;
import java.util.Date;
import java.util.List;

/**
 * DAO Interface for Title to View, Add, GetByID.
 *
 * @author Robert Lange and Alexander Riccio
 */
public interface TitlesDao {

    /**
     * Get a list of Titles
     *
     * @return a list of Title
     */
    List<Title> view();

    /**
     * A count of the Title table
     *
     * @return int value representing the count of the table
     */
    int viewCount();

    /**
     * Adding a Title to the table
     *
     * @param empNo
     * @param title
     * @param fromDate
     * @param toDate
     * @return
     */
    public boolean add(int empNo, String title, Date fromDate, Date toDate);

    /**
     * Getting Title by providing the primary key columns
     *
     * @param empNo
     * @param title
     * @param fromDate
     * @return
     */
    public Title getById(int empNo, String title, Date fromDate);

}
