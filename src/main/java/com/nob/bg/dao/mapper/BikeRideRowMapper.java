/*
 * BikeRideRowMapper.java
 *
 * Created on August 1, 2006, 11:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import com.nob.bg.model.BikeRide;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jorismelchior
 */
public class BikeRideRowMapper implements RowMapper {
    
    /** Creates a new instance of BikeRideRowMapper */
    public BikeRideRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        BikeRide ride = new BikeRide();
        ride.setAverageHr(rs.getInt("average_hr"));
        ride.setCaloriesBurnt(rs.getInt("calories_burnt"));
        ride.setDate(rs.getDate("date"));
        ride.setDistanceKm(new Float(rs.getFloat("distance_km")));
        ride.setFinishLocation(rs.getString("finish_location"));
        ride.setId(rs.getLong("id"));
        ride.setJournal(rs.getString("journal"));
        ride.setMaximumHr(rs.getInt("maximum_hr"));
        ride.setRideTimeSeconds(rs.getInt("ride_time_seconds"));
        ride.setStartLocation(rs.getString("start_location"));
        
        return ride;
    }
    
}
