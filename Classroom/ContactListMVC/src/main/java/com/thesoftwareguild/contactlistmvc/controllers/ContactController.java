/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.controllers;

import com.thesoftwareguild.contactlistmvc.dao.ContactDao;
import com.thesoftwareguild.contactlistmvc.models.Contact;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Christian Choi
 */
@Controller
@RequestMapping(value="/contact")
public class ContactController {
    
    private ContactDao contactDao;
    
    @Inject //Spring knows to inject dao into controller whenever we generate our dao
    public ContactController(ContactDao dao) {
        this.contactDao = dao;
    }
    
    //@Valid - checks to see if model is good and follows all validation
    @RequestMapping(value="/", method = RequestMethod.POST)
    @ResponseBody //the thing im returning, serialize to JSON
    public Contact add(@Valid @RequestBody Contact contact) {
        
        Contact addedContact = contactDao.add(contact);
        
        return addedContact;
    }
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") Integer id, Model model) {
        
        Contact contact = contactDao.get(id);
        
        model.addAttribute("contact", contact);
        
        return "editForm";
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Contact edit(@Valid @RequestBody Contact contact) {
        
        contactDao.update(contact);
        
        return contact;
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED) //returns a 200 response code
    public void delete(@PathVariable("id") Integer id) {
        
        contactDao.remove(id);
        
    }
    
    
    @RequestMapping(value="/{id}")
    @ResponseBody
    public Contact view(@PathVariable("id") Integer id) {
        
        Contact contact = contactDao.get(id);
        
        return contact;
    }
}