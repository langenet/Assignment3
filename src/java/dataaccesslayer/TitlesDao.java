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
 *
 * @author Robert
 */
public interface TitlesDao {

    List<Title> view();

    public boolean add(int empNo, String title, Date fromDate, Date toDate);
}
