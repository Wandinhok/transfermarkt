package edu.iff.bsi.transfermarkt.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice (annotations = Controller.class)
public class ApplicationControllerAdvice {

    
     
    @ExceptionHandler(Exception.class)
    public String errorException(Exception e, Model model){
        model.addAttribute("msgErros", e.getMessage());
        return "error";
    }
    
}
