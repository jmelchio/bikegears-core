/*
 * MonthlyStatsRowMapper.java
 *
 * Created on November 18, 2006, 4:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nob.bg.model.reports.MonthlyStats;

/**
 *
 * @author jorismelchior
 */
public class MonthlyStatsRowMapper implements RowMapper {
    
    /** Creates a new instance of MonthlyStatsRowMapper */
    public MonthlyStatsRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MonthlyStats mStats = new MonthlyStats();
        mStats.setAvgDistance(rs.getFloat("Avg Dist"));
        mStats.setDistance(rs.getFloat("Distance"));
        mStats.setMaxDistance(rs.getFloat("Max Dist"));
        mStats.setMonth(rs.getString("Month"));
        mStats.setNumRides(rs.getInt("Rides"));
        mStats.setYear(rs.getInt("Year"));
        return mStats;
    }
    
}
