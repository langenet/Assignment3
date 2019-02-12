/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.DepartmentEmployeeService;
import businesslayer.DepartmentManagerService;
import businesslayer.TitleService;
import datatransferobjects.DepartmentManager;
import datatransferobjects.Title;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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

    @Test
    public void testingTitleAdd() {

        int empNo = 10001;
        String title = "Senior Engineer";
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();
        Date toDate = new GregorianCalendar(9999, 0, 1).getTime();

        TitleService titleService = new TitleService();
        assertTrue(titleService.add(empNo, title, fromDate, toDate));
    }

    @Test
    public void testingTitleView() {

        int empNo = 10001;
        String title = "Senior Engineer";
        Date fromDate = new GregorianCalendar(1986, 5, 26).getTime();
        Date toDate = new GregorianCalendar(9999, 0, 1).getTime();

        Title firstTitle = new Title.Builder(empNo,
                title,
                fromDate,
                toDate).build();

        empNo = 499999;
        title = "Engineer";
        fromDate = new GregorianCalendar(1997, 10, 30).getTime();
        toDate = new GregorianCalendar(9999, 0, 1).getTime();

        Title lastTitle = new Title.Builder(empNo,
                title,
                fromDate,
                toDate).build();

        TitleService titleService = new TitleService();

        List<Title> titles = titleService.view();

        assertTrue(titles.size() == titleService.viewCount());
        assertTrue(titles.contains(firstTitle));
        assertTrue(titles.contains(lastTitle));

    }
}
