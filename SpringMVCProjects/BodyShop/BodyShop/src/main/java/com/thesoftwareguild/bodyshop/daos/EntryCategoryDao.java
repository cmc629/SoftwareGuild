package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import java.util.List;


/**
 *
 * @author Aaron Alahverde
 */
public interface EntryCategoryDao {
  
  public EntryCategory addEntryCategory(EntryCategory entryCategory);
  
  public void updateEntryCategory(EntryCategory entryCategory);
  
  public void deleteEntryCategory(Integer entryCategoryId);
  
  public EntryCategory getEntryCategory(Integer entryCategoryId);
  
  public List<EntryCategory> list();
  
  
}
