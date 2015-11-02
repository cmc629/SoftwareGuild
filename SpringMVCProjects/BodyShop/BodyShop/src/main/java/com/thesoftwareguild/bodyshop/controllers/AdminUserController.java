package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.StaticPageDao;
import com.thesoftwareguild.bodyshop.daos.UserDao;
import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import com.thesoftwareguild.bodyshop.dtos.User;
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
@RequestMapping({"/manageUsers"})
public class AdminUserController {
    
    private UserDao uDao;
    
    @Inject
    public AdminUserController(UserDao uDao) {
        this.uDao = uDao;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        List<User> users = uDao.listUsers();
        
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        
        return "manageUser";

    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User create(@Valid @RequestBody User user) {
        
        User created = uDao.addUser(user);
        
        return created;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable("id") Integer id) {
        
        User user = uDao.getUser(id);
        
        return user;
        
    }
//    
//    @RequestMapping(value = "/", method = RequestMethod.PUT)
//    @ResponseBody
//    public StaticPage edit(@Valid @RequestBody StaticPage staticPage) {
//        
//        sDao.update(staticPage);
//        
//        return staticPage;
//        
//    }
//    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id) {
        
        uDao.deleteUser(id);
        
    }
    
    @RequestMapping(value = "/viewProfile/{id}", method = RequestMethod.GET)
    public String viewProfile(@PathVariable("id") Integer id, Model model) {
        
        User user = uDao.getUser(id);
        
        model.addAttribute("user", user);
        
        return "viewProfile";
        
    }
}
