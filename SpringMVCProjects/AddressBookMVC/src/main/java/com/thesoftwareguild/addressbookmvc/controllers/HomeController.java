/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbookmvc.controllers;

import com.thesoftwareguild.addressbookmvc.daos.AddressBookDao;
import com.thesoftwareguild.addressbookmvc.models.Address;
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
    
    private AddressBookDao aDao;
    
    @Inject
    public HomeController(AddressBookDao dao) {
        this.aDao = dao;
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) {
        
        List<Address> addresses = aDao.list();
        
        model.addAttribute("addresses", addresses);
        
        return "index";
        
    }
    
}
