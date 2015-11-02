/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.contactlistmvc.dao;

import com.thesoftwareguild.contactlistmvc.models.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Christian Choi
 */
public class ContactDaoDbImpl implements ContactDao {
    
    private static final String SQL_INSERT_CONTACT = "INSERT INTO contact (FIRST_NAME, LAST_NAME, COMPANY, PHONE, EMAIL) VALUES (?, ?, ?, ?, ?)"; //number of values set has to match number of fields set in query
    private static final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_SELECT_CONTACT = "SELECT * FROM contact WHERE ID = ?";
    private static final String SQL_UPDATE_CONTACT = "UPDATE contact SET FIRST_NAME = ?, LAST_NAME = ?, COMPANY = ?, PHONE = ?, EMAIL = ? WHERE ID = ?";
    private static final String SQL_REMOVE_CONTACT = "DELETE FROM contact WHERE ID = ?";
    private static final String SQL_GET_ALL_CONTACTS = "SELECT * FROM contact";
    
    private JdbcTemplate jdbcTemplate;
    
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Contact add(Contact contact) {
        
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getCompany(),
                    contact.getPhone(),
                    contact.getEmail()
                ); //jdbc engine is going to tell mySQL in a safe way
        //use parameterized queries rather than concatenated ones to prevent SQL injection
        
        Integer id = jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class); //cast to Integer
        contact.setId(id);
        
        return contact;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Contact get(Integer id) {
        
        Contact contact = jdbcTemplate.queryForObject(SQL_SELECT_CONTACT, new ContactMapper(), id);
        
        return contact;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(Integer id) {
        
        jdbcTemplate.update(SQL_REMOVE_CONTACT, id);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Contact contact) {
        
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getCompany(),
                    contact.getPhone(),
                    contact.getEmail(),
                    contact.getId()
                );
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Contact> list() {
        
        List<Contact> result = jdbcTemplate.query(SQL_GET_ALL_CONTACTS, new ContactMapper());
        return result;
        
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class ContactMapper implements RowMapper<Contact> {
        //each row turned into a contact obj
        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            
            Contact contact = new Contact();
            //ask result set for column id, get the return value and set it to contact id. do that for the other fields
            contact.setId(rs.getInt("ID"));
            contact.setFirstName(rs.getString("FIRST_NAME"));
            contact.setLastName(rs.getString("LAST_NAME"));
            contact.setCompany(rs.getString("COMPANY"));
            contact.setPhone(rs.getString("PHONE"));
            contact.setEmail(rs.getString("EMAIL"));
            
            return contact;
        }
        
    }
    
    
    
}
