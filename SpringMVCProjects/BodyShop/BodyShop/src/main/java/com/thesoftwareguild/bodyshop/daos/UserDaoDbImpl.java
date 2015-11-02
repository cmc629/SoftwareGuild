/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.User;
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
public class UserDaoDbImpl implements UserDao {

    private final String SQL_INSERT_USER = "INSERT INTO user (FIRST_NAME, LAST_NAME, GENDER, AGE, EMAIL, PHONE, STREET_NUMBER, STREET_NAME, CITY, STATE, ZIP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    private final String SQL_UPDATE_USER = "UPDATE user SET FIRST_NAME = ?, LAST_NAME = ?, GENDER = ?, AGE = ?, EMAIL = ?, PHONE = ?, STREET_NUMBER = ?, STREET_NAME = ?, CITY = ?, STATE = ?, ZIP = ? WHERE USER_ID = ?";
    private final String SQL_SELECT_USER = "SELECT * FROM user WHERE USER_ID = ?";
    private final String SQL_DELETE_USER = "DELETE FROM user WHERE USER_ID = ?";
    private final String SQL_GET_ALL_USERS = "SELECT * FROM user";

    //Search methods
    private final String SQL_SEARCH_BY_LAST_NAME = "SELECT * FROM user WHERE LAST_NAME = ?";
    private final String SQL_SEARCH_BY_EMAIL = "SELECT * FROM user WHERE EMAIL = ?";
    private final String SQL_SEARCH_BY_CITY = "SELECT * FROM user WHERE CITY = ?";
    private final String SQL_SEARCH_BY_STATE = "SELECT * FROM user WHERE STATE = ?";
    private final String SQL_SEARCH_BY_ZIP = "SELECT * FROM user WHERE ZIP = ?";

    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User addUser(User user) {

        jdbcTemplate.update(SQL_INSERT_USER,
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getAge(),
                user.getEmail(),
                user.getPhone(),
                user.getStreetNumber(),
                user.getStreetName(),
                user.getCity(),
                user.getState(),
                user.getZip());

        user.setUserId(jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class));

        return user;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        
        jdbcTemplate.update(SQL_UPDATE_USER, 
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getAge(),
                user.getEmail(),
                user.getPhone(),
                user.getStreetNumber(),
                user.getStreetName(),
                user.getCity(),
                user.getState(),
                user.getZip(),
                user.getUserId());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getUser(Integer userId) {
        
        return jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserMapper(), userId);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Integer userId) {
        
        jdbcTemplate.update(SQL_DELETE_USER, userId);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> listUsers() {
        
        return jdbcTemplate.query(SQL_GET_ALL_USERS, new UserMapper());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> searchByLastName(String lastName) {
        
        return jdbcTemplate.query(SQL_SEARCH_BY_LAST_NAME, new UserMapper(), lastName);
    
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> searchByEmail(String email) {
        
        return jdbcTemplate.query(SQL_SEARCH_BY_EMAIL, new UserMapper(), email);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> searchByCity(String city) {
        
        return jdbcTemplate.query(SQL_SEARCH_BY_CITY, new UserMapper(), city);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> searchByState(String state) {
        
        return jdbcTemplate.query(SQL_SEARCH_BY_STATE, new UserMapper(), state);
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> searchByZip(Integer zip) {
        
        return jdbcTemplate.query(SQL_SEARCH_BY_ZIP, new UserMapper(), zip);
        
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {

            User user = new User();
            user.setUserId(rs.getInt("USER_ID"));
            user.setFirstName(rs.getString("FIRST_NAME"));
            user.setLastName(rs.getString("LAST_NAME"));
            user.setGender(rs.getString("GENDER"));
            user.setAge(rs.getInt("AGE"));
            user.setEmail(rs.getString("EMAIL"));
            user.setPhone(rs.getString("PHONE"));
            user.setStreetNumber(rs.getInt("STREET_NUMBER"));
            user.setStreetName(rs.getString("STREET_NAME"));
            user.setCity(rs.getString("CITY"));
            user.setState(rs.getString("STATE"));
            user.setZip(rs.getInt("ZIP"));

            return user;

        }

    }

}
