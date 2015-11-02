/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmvc.validation;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Christian Choi
 */
@ControllerAdvice //tells spring we're giving it a before/after. Apply this advice to all controllers in system. Similar to AOP
public class RestValidationHandler {
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class) //we've created an advice that wraps around all of our controller methods and will only be valid when the MethodARgumentNotValidException is thrown
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody //tells spring to serialize to JSON
    public ValidationErrorContainer processValidationErrors(MethodArgumentNotValidException e) { //if validation fails, handler will step in. Also the body in our controllers will never execute
        
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        //create container
        ValidationErrorContainer errors = new ValidationErrorContainer();
        
        for (FieldError currentError : fieldErrors) {
            
            errors.addValidationError(currentError.getField(), currentError.getDefaultMessage());
            
        }
        
        return errors; //spring will try to serialize this collection to JSON
        
    }
    
}
