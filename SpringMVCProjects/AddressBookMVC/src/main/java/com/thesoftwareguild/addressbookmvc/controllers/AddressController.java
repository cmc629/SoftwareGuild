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
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping({"/addresses"})
public class AddressController {

    private AddressBookDao aDao;

    @Inject
    public AddressController(AddressBookDao dao) {
        this.aDao = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {

        List<Address> addresses = aDao.list();

        model.addAttribute("addresses", addresses);

        model.addAttribute("address", new Address());

        return "addresses";

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Address add(@Valid @RequestBody Address address) {

        Address addedAddress = aDao.create(address);

        return addedAddress;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Address edit(@Valid @RequestBody Address address) {

        aDao.update(address);

        return address;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {

        aDao.delete(id);

    }
    
    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Address view(@PathVariable("id") Integer id) {
        
        Address address = aDao.get(id);
        
        return address;
        
    }
    
    @RequestMapping(value = "/deleteFinal/{id}") 
    public String deleteInSearchView(@PathVariable("id") Integer id) {

        aDao.delete(id);

        return "redirect:/addresses";

    }

}
