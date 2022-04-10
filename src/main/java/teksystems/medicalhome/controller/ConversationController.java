package teksystems.medicalhome.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.ConversationDAO;
import teksystems.medicalhome.formbean.ConversationFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ConversationController {

    @Autowired //inject DAO class into controller class
    private ConversationDAO conversationDAO;

    /*Entry point/route for conversation page*/
    @RequestMapping(value = "/user/conversation")
    public ModelAndView conversation() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/conversation");

        //seed model with empty form bean
        ConversationFormBean form = new ConversationFormBean();
        response.addObject("form", form);
        return response;
    }

    /*create new conversation when user submits form*/

   @RequestMapping(value = "/user/conversationSubmit", method = RequestMethod.POST)
   public ModelAndView conversationSubmit(@Valid ConversationFormBean form, BindingResult bindingResult){
       ModelAndView response = new ModelAndView();

       /*Begin form validation logic*/
       List<String> errorMessages = new ArrayList<>();

       if(bindingResult.hasErrors()){
           for(ObjectError error : bindingResult.getAllErrors()){
               log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
           }
           response.addObject("form",form);
           response.addObject("bindingResult", bindingResult);

           response.setViewName("user/conversation");
           return response;
       }

       return response;
   }







}
