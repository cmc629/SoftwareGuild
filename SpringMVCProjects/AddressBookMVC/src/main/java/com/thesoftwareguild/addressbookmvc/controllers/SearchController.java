/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbookmvc.controllers;

import com.thesoftwareguild.addressbookmvc.daos.AddressBookDao;
import com.thesoftwareguild.addressbookmvc.models.Address;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Christian Choi
 */
@Controller
@RequestMapping({"/search"})
public class SearchController {
    
    private AddressBookDao aDao;
    
    @Inject
    public SearchController(AddressBookDao dao) {
        this.aDao = dao;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String search(Model model) {
        
        List<Address> addresses = aDao.list();

        model.addAttribute("addresses", addresses);
        
        return "search";
    }
    
    @RequestMapping(value = "/lastName", method = RequestMethod.POST)
    public String searchByLastName(@RequestParam("lastName") String lastName, Model model) {
        
        List<Address> addresses = aDao.searchByLastName(lastName);
        
        model.addAttribute("addresses", addresses);
        
        return "searchResult";
    }
    
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public String searchByCity(@RequestParam("city") String city, Model model) {
        
        List<Address> addresses = aDao.searchByCity(city);
        
        model.addAttribute("addresses", addresses);
        
        return "searchResult";
    }
    
    @RequestMapping(value = "/state", method = RequestMethod.POST)
    public String searchByState(@RequestParam("state") String state, Model model) {
        
        List<Address> addresses = aDao.searchByState(state);
        
        model.addAttribute("addresses", addresses);
        
        return "searchResult";
    }
    
    @RequestMapping(value = "/zip", method = RequestMethod.POST)
    public String searchByZip(@RequestParam("zip") String zip, Model model) {
        
        List<Address> addresses = aDao.searchByZip(zip);
        
        model.addAttribute("addresses", addresses);
        
        return "searchResult";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") Integer id, @Valid @ModelAttribute Address address, Model model, BindingResult bindingResult) {

        aDao.update(address);
        
        model.addAttribute("id", id);

        return "redirect:/search/view/{id}";

    }
    
    @RequestMapping(value = "/view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        
        Address address = aDao.get(id);
        
        model.addAttribute("address", address);
        
        return "searchView";
        
    }
    
}
