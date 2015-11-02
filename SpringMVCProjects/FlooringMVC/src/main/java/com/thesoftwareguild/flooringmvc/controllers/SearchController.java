/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.flooringmvc.controllers;

import com.thesoftwareguild.flooringmvc.daos.OrderDao;
import com.thesoftwareguild.flooringmvc.daos.ProductDao;
import com.thesoftwareguild.flooringmvc.daos.StateDao;
import com.thesoftwareguild.flooringmvc.models.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chris Myung
 */

@Controller
@RequestMapping(value="/search")
public class SearchController {
    
    private OrderDao oDao;
    private ProductDao pDao;
    private StateDao sDao;
    
    @Inject
    public SearchController(OrderDao dao, ProductDao pDao, StateDao sDao) {
        this.oDao = dao;
        this.pDao = pDao;
        this.sDao = sDao;
        
        pDao.load();
        sDao.load();
        
        
    }
    
    @RequestMapping(value="/orderNumber{orderNumber}", method=RequestMethod.POST)
    public String searchByOrderNumber(@RequestParam("orderNumber") Integer orderNumber, Model model) {
        
        Order order = oDao.get(orderNumber);
        
        model.addAttribute("order", order);
        
        return "idSearch";
        
    }
    
    @RequestMapping(value="/orderByDate{date}", method=RequestMethod.POST)
    public String searchByDate(@RequestParam("date") String date, Model model) {
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date dateObj = sdf.parse(date);
        
            List<Order> results = oDao.displayOrderByDate(dateObj);
            model.addAttribute("results", results);
            model.addAttribute("date", dateObj);
            
        } catch (ParseException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "dateSearch";
    }
    
    
}
