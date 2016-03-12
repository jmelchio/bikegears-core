/*
 * BikeRideTypeRowMapper.java
 *
 * Created on August 26, 2006, 5:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import com.nob.bg.model.BikeRideType;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jorismelchior
 */
public class BikeRideTypeRowMapper implements RowMapper {
    
    /** Creates a new instance of BikeRideTypeRowMapper */
    public BikeRideTypeRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        BikeRideType brType = new BikeRideType();
        brType.setId(rs.getLong("id"));
        brType.setName(rs.getString("name"));
        brType.setDescription(rs.getString("description"));
        
        return brType;
    }
    
}
