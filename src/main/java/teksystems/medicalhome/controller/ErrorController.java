package teksystems.medicalhome.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    //404 errors
    @ExceptionHandler(AccessDeniedException.class)
    @RequestMapping(value = "/error/404")
    public String error404(HttpServletRequest request) {
        String originalUrl = (String) request.getAttribute("javax.servlet.forward.request_url");
        log.error("Requested URL not found : "+ request.getMethod()+ " " + originalUrl);
        return "error/404";
    }

    //this method is for all 500 errors for any Exception that is thrown.
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllExceptions(HttpServletRequest request, Exception ex) {

        log.error("Error page exception : " + getRequestURL(request), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("error/500");

        String stackTrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));

        model.addObject("requestUrl",  getRequestURL(request));
        model.addObject("message", ex.getMessage());
        model.addObject("stackTrace", stackTrace);

        if ( ex.getCause() != null ) {
            Throwable root = ExceptionUtils.getRootCause(ex);
            model.addObject("rootcause", root);

            String roottrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));
            model.addObject("roottrace", roottrace);
        }

        return model;
    }

    private String getHTMLStackTrace(String[] stack) {
        StringBuffer result = new StringBuffer();

        for (String frame : stack) {
            if (frame.contains("teksystems")) {
                result.append(" &nbsp; &nbsp; &nbsp;" + frame.trim().substring(3) + "<br>\n");
            } else if ( frame.contains("Caused by:")) {
                result.append("Caused By: " + frame + "<br>");
            }
        }

        return result.toString();
    }

    private String getRequestURL(HttpServletRequest request){
        String result = request.getRequestURL().toString();
        if(request.getQueryString() != null) {
            result = result + "?" + request.getQueryString();
        }
        return result;
    }


}
