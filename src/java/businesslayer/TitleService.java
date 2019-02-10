/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import dataaccesslayer.TitlesDao;
import dataaccesslayer.TitlesDaoImpl;
import datatransferobjects.Title;
import java.util.List;

/**
 *
 * @author alexr
 */
public class TitleService {
            private TitlesDao titleDaoImpl = new TitlesDaoImpl();


    public List<Title> view() {
        return titleDaoImpl.view();
    }

}
