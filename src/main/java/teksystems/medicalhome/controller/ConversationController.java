package teksystems.medicalhome.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.ConversationDAO;
import teksystems.medicalhome.database.dao.UserConversationDAO;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.formbean.ConversationFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ConversationController {

    @Autowired
    private ConversationDAO conversationDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserConversationDAO userConversationDAO;


    /*Entry point/route for conversation page*/
    @RequestMapping(value = "/user/conversation")
    public ModelAndView conversation() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/conversation");
        List<User> usersMenu;

        //get logged-in user information, to pull account-type from logged-in user
        //need to pop this out into its own method so it can be utilized as needed w/o repeating
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);
        String userAcct = user.getAcctType();

        //load select menu based on users acctType, if patient load only providers, if provider, load all users.
        if(userAcct.equals("patient")){
            usersMenu = userDAO.findByAcctType("provider");
        }else{
            usersMenu = userDAO.findAll();
        }

        /*seed model with empty form bean, users data for dropdown menu,
         & logged-in user id for userId field */
        ConversationFormBean form = new ConversationFormBean();
        response.addObject("form", form);
        response.addObject("usersMenu", usersMenu);
        response.addObject("user",user);
        response.setViewName("user/conversation");
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
        /*end form validation*/

       //create new instance of Conversation class
       Conversation conversation = conversationDAO.findById(form.getId());
       if(conversation == null){
           conversation = new Conversation();
       }

       conversation.setSubject(form.getSubject());
       conversationDAO.save(conversation);

       //can't do this here, as convID won't exist until after this method executes.
       //TO DO: set userConversation with userID & convID for each user selected (including logged in user).
       //start with logged in user, need to figure out how pass group of users from front end to server/controller.
       //loop over each user and log out userID and convID
       //after successfull logging, persist each to DB


       //send form to model
       response.addObject("form", form);

       //TO DO: re-route to message view after it's created
       response.setViewName("user/conversation");
       return response;
   }

}
