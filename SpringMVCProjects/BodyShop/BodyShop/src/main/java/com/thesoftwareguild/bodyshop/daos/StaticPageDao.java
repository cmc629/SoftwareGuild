/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.StaticPage;
import java.util.List;

/**
 *
 * @author Christian Choi
 */
public interface StaticPageDao {
    
   public StaticPage create(StaticPage staticPage);
   
   public void update(StaticPage staticPage);
   
   public StaticPage get(Integer id);
   
   public void delete(Integer id);
   
   public List<StaticPage> list();
    
}
