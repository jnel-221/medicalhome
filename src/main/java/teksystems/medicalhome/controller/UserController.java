package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.dao.UserRoleDAO;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserRole;
import teksystems.medicalhome.formbean.RegisterFormBean;
import teksystems.medicalhome.formbean.SearchFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')") //authentication aka, access layer
public class UserController {

    @Autowired
    private UserDAO userDAO;


    //==================search for providers by specialty=====================================
   // @PreAuthorize("hasAuthority('ADMIN')")  can make this method available only to admins if needed w/ this annotation
   @RequestMapping(value = "/user/search", method = RequestMethod.GET)
   public ModelAndView search(SearchFormBean form){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/searchBySpecialty");
        List<User> users;
        log.info("your click gets you one log inside the search method! Yay!");
        if(StringUtils.isBlank(form.getSearch())){
            users = userDAO.findAll();
            response.addObject("users", users);
            log.info("search field has: "+ form.getSearch());
        } else {
            users = userDAO.findBySpecialty(form.getSearch());
            for(User u : users){
                log.info(u.getFirstName());
            }

            response.addObject("users", users);
        }


        response.addObject("form", form);

        response.setViewName("user/search");
        return response;
    }



}
