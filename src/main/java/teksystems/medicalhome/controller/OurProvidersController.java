package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.User;

import java.util.List;

@Slf4j
@Controller
public class OurProvidersController {
    @Autowired
    private UserDAO userDAO;


    @RequestMapping(value="/ourProviders", method = RequestMethod.GET)
    public ModelAndView loadProviders() throws Exception{
        ModelAndView response = new ModelAndView();
        List<User> users = userDAO.findByAcctType("provider");

        response.setViewName("ourProviders");
        response.addObject("users", users);
        return response;
    }
}
