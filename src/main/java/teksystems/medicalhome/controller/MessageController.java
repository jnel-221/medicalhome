package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.ConversationDAO;
import teksystems.medicalhome.database.dao.MessageDAO;
import teksystems.medicalhome.database.dao.UserConversationDAO;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.Message;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserConversation;
import teksystems.medicalhome.formbean.MessageFormBean;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class MessageController {

    private ConversationDAO conversationDAO;

    private MessageDAO messageDAO;

    private UserDAO userDAO;

    private UserConversationDAO userConversationDAO;

    @Autowired
    public MessageController(ConversationDAO conversationDAO, MessageDAO messageDAO, UserDAO userDAO, UserConversationDAO userConversationDAO) {
        this.conversationDAO = conversationDAO;
        this.messageDAO = messageDAO;
        this.userDAO = userDAO;
        this.userConversationDAO = userConversationDAO;
    }

    //Possible to-do: separate get from post, redirect to get after post complete; pass convID on hidden input field.
    //method loads chat view using conversation id as path variable
    @RequestMapping(value = "/user/message/{id}", method = RequestMethod.GET)
    public ModelAndView message(@PathVariable("id") Integer id, MessageFormBean form) {
        ModelAndView response = new ModelAndView();

        //get logged-in user information, to pull user id from logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);

        //get conversation by id;
        Conversation conversation = conversationDAO.findById(id);
        //get user-conversations by conversation;
        List<UserConversation> userConversations = userConversationDAO.findByConversation(conversation);
        userConversations.forEach(uc -> {
            log.info(uc.getUser().getFirstName());
            log.info(uc.getUser().getLastName());
            log.info(uc.getUser().getImgUrl());
            log.info(uc.getUser().getSpecialty());
            log.info(uc.getUser().getCredential());
        });

        //get users from userconversation objects and store in User list.
        List<User> users = new ArrayList<>();
        userConversations.forEach(uc -> {
            users.add(uc.getUser());
        });

        //get all messages in conversation
        List<Message> messages = messageDAO.findMessageByConversation(conversation);

        //add data to ModelAndView
        response.addObject("messages", messages); //add messages
        response.addObject("user", user);//add logged-in user info
        response.addObject("users", users);//add list of participants
        response.addObject("conversation", conversation); //add conversation information
        response.addObject("form", form);
        response.setViewName("user/message");

        return response;
    }

    @RequestMapping(value = "/user/message/{id}", method = RequestMethod.POST)
    public ModelAndView messageSubmit(@PathVariable("id") Integer id, @Valid MessageFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        /* begin form validation logic */
       List<String> errorMessages = new ArrayList<>();

       if(bindingResult.hasErrors()){
           for(ObjectError error : bindingResult.getAllErrors()){
               errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
           }
           response.addObject("form",form);
           response.addObject("bindingResult", bindingResult);

           response.setViewName("redirect:/user/message/"+id);
           return response;
       }
       /* end form validation logic*/

        //get logged-in user information, to pull user id from logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);

        //get conversation by id;
        Conversation conversation = conversationDAO.findById(id);

        //create Message instance, set values and save to db.
        Message message = new Message();
        message.setMessage(form.getMessage());
        message.setConversation(conversation);
        message.setUser(user);
        messageDAO.save(message);

        response.setViewName("redirect:/user/message/"+ conversation.getId());
        return response;
    }
}


