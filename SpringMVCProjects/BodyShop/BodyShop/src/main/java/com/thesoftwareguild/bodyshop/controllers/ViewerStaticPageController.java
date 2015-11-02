package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.StaticPageDao;
import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/pages"})
public class ViewerStaticPageController {
    
    private StaticPageDao sDao;
    
    @Inject
    public ViewerStaticPageController(StaticPageDao sDao) {
        this.sDao = sDao;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String index(@PathVariable("id") Integer id, Model model) {
        
        StaticPage page = sDao.get(id);
        
        List<StaticPage> pages = sDao.list();
        
        model.addAttribute("page", page);
        model.addAttribute("pages", pages);
        
        return "viewStaticPage";

    }
    
}
