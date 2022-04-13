package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    //need to make an error/404
    @ExceptionHandler(AccessDeniedException.class)
    @RequestMapping(value = "/error/404")
    public String error404(HttpServletRequest request) {
        String originalUrl = (String) request.getAttribute("javax.servlet.forward.request_url");
        log.error("Requested URL not found : "+ request.getMethod()+ " " + originalUrl);
        return "error/404";
    }
}
