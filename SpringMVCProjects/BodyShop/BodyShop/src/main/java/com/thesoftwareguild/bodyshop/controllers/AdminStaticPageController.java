package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.StaticPageDao;
import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import java.util.List;
import java.util.Map;
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

@Controller
@RequestMapping({"/manageStaticPages"})
public class AdminStaticPageController {
    
    private StaticPageDao sDao;
    
    @Inject
    public AdminStaticPageController(StaticPageDao sDao) {
        this.sDao = sDao;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        List<StaticPage> list = sDao.list();
        
        model.addAttribute("list", list);
        
        return "manageStaticPage";

    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public StaticPage create(@Valid @RequestBody StaticPage staticPage) {
        
        StaticPage created = sDao.create(staticPage);
        
        return created;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StaticPage get(@PathVariable("id") Integer id) {
        
        StaticPage sp = sDao.get(id);
        
        return sp;
        
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public StaticPage edit(@Valid @RequestBody StaticPage staticPage) {
        
        sDao.update(staticPage);
        
        return staticPage;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {
        
        sDao.delete(id);
        
    }
}
