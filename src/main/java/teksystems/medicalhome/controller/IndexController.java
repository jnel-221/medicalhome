package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import teksystems.medicalhome.database.dao.UserDAO;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.User;

import java.io.File;
import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDAO;

    //serve homepage to un-authenticated users
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private ModelAndView index() throws Exception{
        ModelAndView response = new ModelAndView();

        response.setViewName("index");
        return response;
    }

    //serve homepage to authenticated users
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView indexLoggedIn() throws Exception {
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

    //serve upload form
    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public ModelAndView upload() throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("upload");
        return response;
    }

    //post method for upload form
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ModelAndView uploadPost(@RequestParam("file") MultipartFile file) throws Exception{
        ModelAndView response = new ModelAndView();
        response.setViewName("upload");
        log.info("uploaded file: "+file.getOriginalFilename()+ " size: " + file.getSize());

       File targetFile = new File("C:/documents/asdf.txt");
       FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
        return response;
    }
}
