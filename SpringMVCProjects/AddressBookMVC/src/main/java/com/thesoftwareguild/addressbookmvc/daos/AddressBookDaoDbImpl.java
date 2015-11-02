/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.addressbookmvc.daos;

import com.thesoftwareguild.addressbookmvc.models.Address;
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
public class AddressBookDaoDbImpl implements AddressBookDao {
    
    private static final String SQL_INSERT_ADDRESS = "INSERT INTO address (FIRST_NAME, LAST_NAME, STREET_NUMBER, STREET_NAME, CITY, STATE, ZIP) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_SELECT_ADDRESS = "SELECT * FROM address WHERE ID = ?";
    private static final String SQL_UPDATE_ADDRESS = "UPDATE address SET FIRST_NAME = ?, LAST_NAME = ?, STREET_NUMBER = ?, STREET_NAME = ?, CITY = ?, STATE = ?, ZIP = ? WHERE ID = ?";
    private static final String SQL_DELETE_ADDRESS = "DELETE FROM address WHERE ID = ?";
    private static final String SQL_GET_ALL_ADDRESSES = "SELECT * FROM address";
    private static final String SQL_SEARCH_BY_LAST_NAME = "SELECT * FROM address WHERE LAST_NAME = ?";
    private static final String SQL_SEARCH_BY_CITY = "SELECT * FROM address WHERE CITY = ?";
    private static final String SQL_SEARCH_BY_STATE = "SELECT * FROM address WHERE STATE = ?";
    private static final String SQL_SEARCH_BY_ZIP = "SELECT * FROM address WHERE ZIP = ?";
    
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address create(Address address) {
        
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetNumber(),
                address.getStreetName(),
                address.getCity(),
                address.getState(),
                address.getZip());
        
        Integer id = jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class);
        address.setId(id);
        
        return address;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Address address) {
        
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getStreetNumber(),
                address.getStreetName(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getId());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Address get(Integer id) {
        
        Address address = jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS, new AddressMapper() , id);
        
        return address;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        
        jdbcTemplate.update(SQL_DELETE_ADDRESS, id);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> list() {
        
        List<Address> result = jdbcTemplate.query(SQL_GET_ALL_ADDRESSES, new AddressMapper());
        return result;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByLastName(String lastName) {
        
        List<Address> result = jdbcTemplate.query(SQL_SEARCH_BY_LAST_NAME, new AddressMapper(), lastName);
        return result;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByCity(String city) {
        
        List<Address> result = jdbcTemplate.query(SQL_SEARCH_BY_CITY, new AddressMapper(), city);
        return result;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByState(String state) {

        List<Address> result = jdbcTemplate.query(SQL_SEARCH_BY_STATE, new AddressMapper(), state);
        return result;
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Address> searchByZip(String zip) {
        
        List<Address> result = jdbcTemplate.query(SQL_SEARCH_BY_ZIP, new AddressMapper(), zip);
        return result;
        
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            
            Address address = new Address();
            address.setId(rs.getInt("ID"));
            address.setFirstName(rs.getString("FIRST_NAME"));
            address.setLastName(rs.getString("LAST_NAME"));
            address.setStreetNumber(rs.getString("STREET_NUMBER"));
            address.setStreetName(rs.getString("STREET_NAME"));
            address.setCity(rs.getString("CITY"));
            address.setState(rs.getString("STATE"));
            address.setZip(rs.getString("ZIP"));
            
            return address;
            
        }
        
    }
    
}
