package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.formbean.RegisterFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;


    /*provide entry point/route for user registration page*/
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        //seed model with empty form bean
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form",form);
        return response;
    }

    /*create new user when user submits form*/
    @RequestMapping(value = "/user/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception{
        ModelAndView response = new ModelAndView();
        /* begin form validation logic */
        List<String> errorMessages = new ArrayList<>();

        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                errorMessages.add(error.getDefaultMessage());
               // log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form",form);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("user/register");
            return response;
        }
        /* end form validation logic*/


        User user = userDAO.findById(form.getId());
        if(user == null){
            user = new User();
        }

        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setSpecialty(form.getSpecialty());
        user.setCredential(form.getCredential());
        user.setPassword(form.getPassword());

        //persist changes to user instance
        userDAO.save(user);

        //send form to model
        response.addObject("form",form);

        response.setViewName("user/register");//purpose is to connect to the jsp page
        return response;

    }


}
