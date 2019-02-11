/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.TitleService;
import datatransferobjects.Title;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexr
 */
public class TitleJUnitTest {

    public TitleJUnitTest() {
    }

    @Test
    public void testingTitleGetById() {

        int empNo = 10001;
        String title = "Senior Engineer";
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();
        Date toDate = new GregorianCalendar(9999, 0, 1).getTime();
        
        TitleService titleService = new TitleService();

        Title titleValue = titleService.getById(empNo, title, fromDate);
        assertTrue(titleValue.getToDate().equals(toDate));
    }
}
