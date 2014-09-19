/*
 * MonthlyStats.java
 *
 * Created on November 17, 2006, 10:42 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.model.reports;

/**
 *
 * @author jorismelchior
 */
public class DistToDate {
    private int year;
    private Float distToDate;
    private Float avgDistance;
    private Float maxDistance;
    private int numOfRides;
    private int dayOfYear;
    
    /** Creates a new instance of MonthlyStats */
    public DistToDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Float getDistToDate() {
        return distToDate;
    }

    public void setDistToDate(Float distToDate) {
        this.distToDate = distToDate;
    }

    public Float getAvgDistance() {
        return avgDistance;
    }

    public void setAvgDistance(Float avgDistance) {
        this.avgDistance = avgDistance;
    }

    public Float getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Float maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getNumOfRides() {
        return numOfRides;
    }

    public void setNumOfRides(int numOfRides) {
        this.numOfRides = numOfRides;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }
    
    @Override
    public String toString() {
        return "[DistToDate] " 
                + "year: " +  this.year
                + " dist to date: " + this.distToDate
                + " avg dist: " + this.avgDistance
                + " max dist: " + this.maxDistance
                + " # rides: " + this.numOfRides
                + " DOY: " + this.dayOfYear;
    }
}
/* That's All Folks !! */