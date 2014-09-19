/*
 * BikeRowMapper.java
 *
 * Created on July 31, 2006, 10:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import com.nob.bg.model.Bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jorismelchior
 */
public class BikeRowMapper implements RowMapper {
    
    /** Creates a new instance of BikeRowMapper */
    public BikeRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bike bike = new Bike();
        bike.setId(rs.getLong("id"));
        bike.setBrand(rs.getString("brand"));
        bike.setModel(rs.getString("model"));
        bike.setColor(rs.getString("color"));
        bike.setDescription(rs.getString("description"));
        bike.setYear(rs.getInt("year"));
        
        return bike;
    }
    
}
/* That's All Folks !! */