package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.MessageDAO;
import teksystems.medicalhome.database.dao.UserConversationDAO;
import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.User;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class MessageController {
    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserConversationDAO userConversationDAO;

//this method is called after user submits a conversation; will need to load page with info from most recently saved conversation.
    @RequestMapping(value = "user/message", method = RequestMethod.GET)
    public ModelAndView message(){
        ModelAndView response = new ModelAndView();
        //get all conversations,pop off most recent one, then display?
        response.setViewName("user/message");

        return response;
    }

    //this method is called after user submits a conversation; will need to load page with info from most recently saved conversation.
    @RequestMapping(value = "user/messageSubmit", method = RequestMethod.GET)
    public ModelAndView messageSubmit(){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/message");

        //get logged-in user information, to pull account-type from logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userDAO.findByEmail(username);




        return response;
    }
}
