package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.dao.UserRoleDAO;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserRole;
import teksystems.medicalhome.formbean.RegisterFormBean;

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
    @RequestMapping(value = "/user/search")
    public ModelAndView search(@RequestParam(required = false, name = "search") String search){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");
        List<User> users = new ArrayList<>();
        log.info("your click gets you one log inside the search method! Yay!");
        if(StringUtils.isBlank(search)){
            response.addObject("users", users);
            log.info("search field blank");
        } else {
            users = userDAO.findBySpecialty(search);
            for(User u : users){
                log.info(u.getFirstName());
            }

            response.addObject("users", users);
        }

        response.addObject("search", search);

        return response;
    }

}
