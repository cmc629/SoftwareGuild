/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Christian Choi
 */
public class Cache {
    
    private CacheEntry[] values;
    private int index = 0;
    
    //Constructor for Cache
    public Cache(int size) {
        values = new CacheEntry[size];
    }
    
    public int store(Object value) {
        
        CacheEntry entry = new CacheEntry();
        
        entry.timeInserted = System.currentTimeMillis(); //static method in System class to get time in milliseconds
        entry.value = value;
        
        values[index] = entry;
        
        return ++index;
    }
    
    public Object get(int index) {
        
        if (index < values.length) {
            
            CacheEntry entry = values[index];
            
            return entry.value;
        }
        
        return null;
    }
    //inner class
    public class CacheEntry {
        public long timeInserted = 0;
        public Object value = null;
        
    }
    
    
    
}
