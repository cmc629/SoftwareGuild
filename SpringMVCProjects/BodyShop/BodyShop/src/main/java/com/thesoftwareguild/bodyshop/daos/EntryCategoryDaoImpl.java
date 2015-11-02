package com.thesoftwareguild.bodyshop.daos;

import com.thesoftwareguild.bodyshop.dtos.EntryCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aaron Alahverde
 */
public class EntryCategoryDaoImpl implements EntryCategoryDao {

    String SQL_INSERT_CATEGORY = "INSERT INTO entry_category (ENTRY_CATEGORY_NAME) VALUES (?)";
    String SQL_GET_LAST_ID = "SELECT LAST_INSERT_ID()";
    String SQL_UPDATE_CATEGORY = "UPDATE entry_category SET ENTRY_CATEGORY_NAME = ? WHERE ENTRY_CATEGORY_ID = ?";
    String SQL_SELECT_CATEGORY = "SELECT * FROM entry_category WHERE ENTRY_CATEGORY_ID = ?";
    String SQL_DELETE_CATEGORY = "DELETE FROM entry_category WHERE ENTRY_CATEGORY_ID = ?";
    String SQL_GET_ALL_CATEGORIES = "SELECT * FROM entry_category";
    
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public EntryCategory addEntryCategory(EntryCategory entryCategory) {
        
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                entryCategory.getEntryCategoryName());
        
        entryCategory.setEntryCategoryId(jdbcTemplate.queryForObject(SQL_GET_LAST_ID, Integer.class));
        
        return entryCategory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<EntryCategory> list() {
        
        return jdbcTemplate.query(SQL_GET_ALL_CATEGORIES, new EntryCategoryMapper());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateEntryCategory(EntryCategory entryCategory) {
       
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                entryCategory.getEntryCategoryName(),
                entryCategory.getEntryCategoryId());    
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteEntryCategory(Integer entryCategoryId) {
        
        jdbcTemplate.update(SQL_DELETE_CATEGORY, entryCategoryId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public EntryCategory getEntryCategory(Integer entryCategoryId) {
        
        return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new EntryCategoryMapper(), entryCategoryId);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    

    private static final class EntryCategoryMapper implements RowMapper<EntryCategory> {

        @Override
        public EntryCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
            
            EntryCategory ec = new EntryCategory();
            ec.setEntryCategoryId(rs.getInt("ENTRY_CATEGORY_ID"));
            ec.setEntryCategoryName(rs.getString("ENTRY_CATEGORY_NAME"));
            
            return ec;
        }

    }

}
