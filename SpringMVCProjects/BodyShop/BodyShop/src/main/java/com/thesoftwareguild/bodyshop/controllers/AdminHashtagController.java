package com.thesoftwareguild.bodyshop.controllers;

import com.thesoftwareguild.bodyshop.daos.HashtagDao;
import com.thesoftwareguild.bodyshop.dtos.Hashtag;
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
public class AdminHashtagController {
  
  HashtagDao dao;
  
  @Inject
  public AdminHashtagController(HashtagDao dao) {
    this.dao = dao;
  }
  
  @RequestMapping(value="/hashtag", method=RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody public Hashtag createHashtag(@Valid @RequestBody Hashtag hashtag) {
    return dao.addHashtag(hashtag);
  }
  
  @RequestMapping(value="/hashtag/{id}", method=RequestMethod.GET)
  @ResponseBody public Hashtag getHashtag(@PathVariable("id") Integer id) {
    return dao.getHashtag(id);
  }
  
  @RequestMapping(value="/hashtag/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.ACCEPTED)
  @ResponseBody public void deleteHashtag(@PathVariable("id") Integer id) {
    dao.deleteHashtag(id);
  }
  
  
  
}
