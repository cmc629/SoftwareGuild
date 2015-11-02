/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.StaticPage;
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
public class StaticPageDaoDbImpl implements StaticPageDao {

    private static final String SQL_INSERT_STATIC_PAGE = "INSERT INTO static_page (TITLE, CONTENT) VALUES (?, ?)";
    private static final String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    private static final String SQL_UPDATE_STATIC_PAGE = "UPDATE static_page SET TITLE = ?, CONTENT = ? WHERE STATIC_PAGE_ID = ?";
    private static final String SQL_DELETE_STATIC_PAGE = "DELETE FROM static_page WHERE STATIC_PAGE_ID = ?";
    private static final String SQL_SELECT_STATIC_PAGE = "SELECT * FROM static_page WHERE STATIC_PAGE_ID = ?";
    private static final String SQL_GET_ALL_STATIC_PAGES = "SELECT * FROM static_page";
    
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StaticPage create(StaticPage staticPage) {

        jdbcTemplate.update(SQL_INSERT_STATIC_PAGE,
                staticPage.getTitle(),
                staticPage.getContent());

        Integer id = jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class);
        staticPage.setStaticPageId(id);

        return staticPage;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(StaticPage staticPage) {

        jdbcTemplate.update(SQL_UPDATE_STATIC_PAGE,
                staticPage.getTitle(),
                staticPage.getContent(),
                staticPage.getStaticPageId());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StaticPage get(Integer id) {

        return jdbcTemplate.queryForObject(SQL_SELECT_STATIC_PAGE, new PageMapper(), id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {

        jdbcTemplate.update(SQL_DELETE_STATIC_PAGE, id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<StaticPage> list() {
        
        return jdbcTemplate.query(SQL_GET_ALL_STATIC_PAGES, new PageMapper());
        
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class PageMapper implements RowMapper<StaticPage> {

        @Override
        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {

            StaticPage sp = new StaticPage();
            sp.setStaticPageId(rs.getInt("STATIC_PAGE_ID"));
            sp.setTitle(rs.getString("TITLE"));
            sp.setContent(rs.getString("CONTENT"));

            return sp;

        }

    }

}
