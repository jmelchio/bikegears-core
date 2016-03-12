/*
 * BikeTypeRowMapper.java
 *
 * Created on August 26, 2006, 5:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import com.nob.bg.model.BikeType;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jorismelchior
 */
public class BikeTypeRowMapper implements RowMapper {
    
    /** Creates a new instance of BikeTypeRowMapper */
    public BikeTypeRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        BikeType bType = new BikeType();
        bType.setId(rs.getLong("id"));
        bType.setName(rs.getString("name"));
        bType.setDescription(rs.getString("description"));
        
        return bType;
    }
    
}
