/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.controllers;

import com.thesoftwareguild.contactlistmvc.dao.ContactDao;
import com.thesoftwareguild.contactlistmvc.models.Contact;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Christian Choi
 */
@Controller
public class HomeController {
    
    private ContactDao contactDao;
    
    @Inject //Spring knows to inject dao into controller whenever we generate our dao
    public HomeController(ContactDao dao) {
        this.contactDao = dao;
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) {
        
        List<Contact> contacts = contactDao.list();
        
        model.addAttribute("contacts", contacts);
        model.addAttribute("contact", new Contact());
        
        return "index";
        
    }
    
}
