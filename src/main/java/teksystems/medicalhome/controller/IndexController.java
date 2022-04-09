package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.UserDAO;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    private UserDAO patientDAO;

    //serve homepage
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private ModelAndView index() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        return response;
    }
}
