/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.SalaryDao;
import dataaccesslayer.SalaryDaoImpl;
import datatransferobjects.Salary;
import java.util.List;

/**
 *
 * @author alexr
 */
public class SalaryService {
            private SalaryDao salaryDaoImpl = new SalaryDaoImpl();


    public List<Salary> view() {
        return salaryDaoImpl.view();
    }
}
