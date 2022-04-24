package teksystems.medicalhome.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.ConversationDAO;
import teksystems.medicalhome.database.dao.UserConversationDAO;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserConversation;
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
       List<User> usersMenu;

        //get logged-in user info
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String username = authentication.getName();
       User user = userDAO.findByEmail(username);
       String userAcct = user.getAcctType();

       /*Begin form validation logic*/
       List<String> errorMessages = new ArrayList<>();

       if(bindingResult.hasErrors()){
           for(ObjectError error : bindingResult.getAllErrors()){
               errorMessages.add(error.getDefaultMessage());
              // log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
           }

           if(userAcct.equals("patient")){
               usersMenu = userDAO.findByAcctType("provider");
           }else{
               usersMenu = userDAO.myFindAll();
           }
           response.addObject("usersMenu", usersMenu);
           response.addObject("form",form);
           response.addObject("bindingResult", bindingResult);
           response.setViewName("user/conversation");
           return response;
       }
        /*end form validation*/

       //create new instance of Conversation class, save conversation
       Conversation conversation = conversationDAO.findById(form.getId());
       if(conversation == null){
           conversation = new Conversation();
       }
       conversation.setSubject(form.getSubject());
       conversationDAO.save(conversation);

       //create new instance of UserConversation, save userConversation w/logged-in user info
       UserConversation userConversation = new UserConversation();
       userConversation.setConversation(conversation);
       userConversation.setUser(user);
       userConversationDAO.save(userConversation);

       //get participant ids from search field, add new instance of userConversation
       //for each participant selected.
       List<Integer> userIds = form.getUserId();
       for (Integer uId: userIds
            ) {
          User participant = userDAO.findById(uId);
          UserConversation userConversation1 = new UserConversation();
            userConversation1.setUser(participant);
            userConversation1.setConversation(conversation);
          userConversationDAO.save(userConversation1);
       }

       response.addObject("form", form);

       //redirect to message view
       response.setViewName("redirect:/user/message/"+conversation.getId());
       return response;
   }

}
