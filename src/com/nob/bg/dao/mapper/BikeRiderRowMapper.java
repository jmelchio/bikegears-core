/*
 * BikeRiderRowMapper.java
 *
 * Created on August 26, 2006, 5:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import com.nob.bg.model.BikeRider;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jorismelchior
 */
public class BikeRiderRowMapper implements RowMapper {
    
    /** Creates a new instance of BikeRiderRowMapper */
    public BikeRiderRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        BikeRider rider = new BikeRider();
        rider.setId(rs.getLong("id"));
        rider.setPassword(rs.getString("password"));
        rider.setUserName(rs.getString("user_name"));
        
        return rider;
    }
}
