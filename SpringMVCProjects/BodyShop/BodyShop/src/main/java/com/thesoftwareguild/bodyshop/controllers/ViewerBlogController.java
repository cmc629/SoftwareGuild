/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.BlogEntryDao;
import com.thesoftwareguild.bodyshop.daos.StaticPageDao;
import com.thesoftwareguild.bodyshop.dtos.BlogEntry;
import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value="/blog")
public class ViewerBlogController {
    
    private StaticPageDao sDao;
    private BlogEntryDao bDao;
    
    @Inject
    public ViewerBlogController(StaticPageDao sDao, BlogEntryDao bDao){
        this.sDao = sDao;
        this.bDao = bDao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String viewBlog(Model model) {
        
        List<StaticPage> pages = sDao.list();
        
        model.addAttribute("pages", pages);
        
        List<BlogEntry> blogEntries = bDao.list();
        
        model.addAttribute("blogEntries", blogEntries);
        
        return "viewerBlog";
    }
    
    
    
}
