package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.MessageDAO;
import teksystems.medicalhome.database.dao.UserConversationDAO;
import teksystems.medicalhome.database.dao.UserDAO;

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


    @RequestMapping(value = "user/message", method = RequestMethod.GET)
    public ModelAndView message(){
        ModelAndView response = new ModelAndView();
        response.setViewName("user/message");

        return response;
    }
}
