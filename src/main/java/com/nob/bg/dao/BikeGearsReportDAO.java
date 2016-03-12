/**
 * 
 */
package com.nob.bg.dao;

import java.util.Collection;

import com.nob.bg.model.BikeRider;
import com.nob.bg.model.reports.DistToDate;
import com.nob.bg.model.reports.MonthlyStats;

/**
 * @author jorismelchior
 *
 */
public interface BikeGearsReportDAO {
    Collection<DistToDate> getDistToDateForBikeRider(BikeRider bikeRider);
    Collection<MonthlyStats> getMonthlyStatsForBikeRider(BikeRider bikeRider);
    Collection<MonthlyStats> getMonthComparisonForBikeRider(BikeRider bikeRider);
    Collection<DistToDate> getDistToDateForBikeRiderById(Long id);
    Collection<MonthlyStats> getMonthlyStatsForBikeRiderById(Long id);
    Collection<MonthlyStats> getMonthComparisonForBikeRiderById(Long id);
}
/* That's All Folks !! */