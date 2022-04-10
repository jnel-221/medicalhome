package teksystems.medicalhome.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import teksystems.medicalhome.database.dao.ConversationDAO;
import teksystems.medicalhome.formbean.ConversationFormBean;

@Slf4j
@Controller
public class ConversationController {

    @Autowired //inject DAO class into controller class
    private ConversationDAO conversationDAO;

    /*Provide entry point/route for conversation page*/
    @RequestMapping(value = "/user/conversation")
    public ModelAndView createConversation() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("user/conversation");

        //seed model with empty form bean
        ConversationFormBean form = new ConversationFormBean();
        response.addObject("form", form);
        return response;
    }

    







}
