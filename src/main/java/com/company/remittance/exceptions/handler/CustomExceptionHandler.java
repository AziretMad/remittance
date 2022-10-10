package com.company.remittance.exceptions.handler;

import com.company.remittance.exceptions.GrantImpossibleException;
import com.company.remittance.exceptions.InvalidCodeException;
import com.company.remittance.exceptions.InvalidPersonNumberException;
import com.company.remittance.exceptions.NotEnoughFundsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({
            EntityNotFoundException.class,
            GrantImpossibleException.class,
            NotEnoughFundsException.class,
            InvalidCodeException.class,
            InvalidPersonNumberException.class
    })
    public String handleException(HttpServletRequest req, RedirectAttributes attributes, Exception e) {
        attributes.addFlashAttribute("error", e.getMessage());
        return "redirect:" + req.getHeader("Referer");
    }
}
