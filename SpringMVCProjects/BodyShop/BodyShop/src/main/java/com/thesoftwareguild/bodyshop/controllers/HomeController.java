package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.StaticPageDao;
import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private StaticPageDao sDao;

    @Inject
    public HomeController(StaticPageDao sDao) {
        this.sDao = sDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        List<StaticPage> pages = sDao.list();

        model.addAttribute("pages", pages);

        return "index";

    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String viewRegister(Model model) {

        List<StaticPage> pages = sDao.list();

        model.addAttribute("pages", pages);

        return "viewerRegister";
    }
    
    @RequestMapping(value = "/signin/", method = RequestMethod.GET)
    public String viewSignIn(Model model) {

        List<StaticPage> pages = sDao.list();

        model.addAttribute("pages", pages);

        return "viewerSignIn";
    }
}
