/*
 * MonthlyStatsRowMapper.java
 *
 * Created on November 17, 2006, 10:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nob.bg.model.reports.DistToDate;

/**
 *
 * @author jorismelchior
 */
public class DistToDateRowMapper implements RowMapper{
    
    /** Creates a new instance of MonthlyStatsRowMapper */
    public DistToDateRowMapper() {
    }

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        DistToDate mStats = new DistToDate();
        mStats.setAvgDistance(rs.getFloat("Avg Dist"));
        mStats.setDayOfYear(rs.getInt("DOY"));
        mStats.setDistToDate(rs.getFloat("Dist to date"));
        mStats.setMaxDistance(rs.getFloat("Max Dist"));
        mStats.setNumOfRides(rs.getInt("# Rides"));
        mStats.setYear(rs.getInt("Year"));
        return mStats;
    }
    
}
