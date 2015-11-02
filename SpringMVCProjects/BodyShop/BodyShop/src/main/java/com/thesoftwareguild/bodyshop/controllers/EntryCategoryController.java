package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.EntryCategoryDao;
import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Aaron Alahverde
 */
@Controller
public class EntryCategoryController {
  
  private final EntryCategoryDao dao;
  
  @Inject
  public EntryCategoryController(EntryCategoryDao dao) {
    this.dao  = dao;
  }
  
  
  @RequestMapping(value="/entryCategory", method=RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody public EntryCategory createEntryCategory (@Valid @RequestBody EntryCategory ec) {
    dao.addEntryCategory(ec);
    return ec;
  }
  
  @RequestMapping(value="/entryCategory", method=RequestMethod.GET) 
  @ResponseBody public List <EntryCategory> getAllCategories() {
    return dao.list();
  }
  
  @RequestMapping(value="/entryCategory/{id}", method=RequestMethod.DELETE) 
  @ResponseBody public void deleteCategory(@PathVariable("id") Integer id) {
    dao.deleteEntryCategory(id);
  }
  
  @RequestMapping(value="/entryCategory/{id}", method=RequestMethod.PUT)
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody public void updateCategory(@PathVariable("id") Integer id ){
    dao.updateEntryCategory(dao.getEntryCategory(id));
  }
}
