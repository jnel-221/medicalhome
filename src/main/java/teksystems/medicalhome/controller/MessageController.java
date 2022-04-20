package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private ConversationDAO conversationDAO;

    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserConversationDAO userConversationDAO;

    //method loads chat view using conversation id as path variable
    @RequestMapping(value = "/user/message/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView message(@PathVariable("id") Integer id, MessageFormBean form){
        ModelAndView response = new ModelAndView();

        //get logged-in user information, to pull user id from logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);

        //get conversation by id;
        Conversation conversation = conversationDAO.findById(id);
        //get user-conversations by tied to conversation;
        List<UserConversation> userConversations = userConversationDAO.findByConversation(conversation);
        userConversations.forEach(uc ->{
            log.info(uc.getUser().getFirstName());
            log.info(uc.getUser().getLastName());
            log.info(uc.getUser().getImgUrl());
            log.info(uc.getUser().getSpecialty());
            log.info(uc.getUser().getCredential());
        });

        List<User> users = new ArrayList<>();
        userConversations.forEach(uc ->{
            users.add(uc.getUser());
        });

        Message message = new Message();
        message.setMessage(form.getMessage());
        message.setConversation(conversation);
        message.setUser(user);

        messageDAO.save(message);

        response.addObject("users", users);
        response.addObject("conversation", conversation);
        response.addObject("form", form);
        response.setViewName("user/message");
        return response;
    }


    //serve homepage to authenticated users
    @RequestMapping(value = "/index/home", method = RequestMethod.GET)
    private ModelAndView indexLoggedIn() throws Exception {
        ModelAndView response = new ModelAndView();
        List<Conversation> conversations;

        //get logged-in user information, to pull user id from logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);
        log.info(String.valueOf(user));
        log.info("You're in the index/home route after userDao findByEmail is called");
        log.info(String.valueOf(user));

        //get userconversations by userID, loop through, grab conversations and add them to conversation list


        //load conversations to model
        //response.addObject("user",user);
        response.setViewName("index");
        return response;
    }

    //this method is called after user submits a message; will need to load page with info from most recently saved conversation.
//    @RequestMapping(value = "/user/messageSubmit", method = RequestMethod.POST)
//    public ModelAndView messageSubmit(@Valid MessageFormBean form, @PathVariable("id") Integer id){ //@PathVariable("id") Integer id,
//        ModelAndView response = new ModelAndView();
//
//        //get logged-in user information, to pull user id from logged-in user
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = userDAO.findByEmail(username);
//
//        //create instance of message class
//        response.addObject("form",form);
//        response.setViewName("redirect:/user/message/");
//        return response;
//    }
}
