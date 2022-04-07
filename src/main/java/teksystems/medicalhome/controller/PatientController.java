package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.PatientDAO;
import teksystems.medicalhome.formbean.RegisterFormBean;

@Slf4j
@Controller //tells Spring this is a controller
public class PatientController {
    @Autowired
    private PatientDAO patientDAO;

    //create entry point for user registration page
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        RegisterFormBean form = new RegisterFormBean();
        return response;
    }
}
