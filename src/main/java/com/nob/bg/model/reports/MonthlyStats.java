/*
 * MonthlyStats.java
 *
 * Created on November 18, 2006, 4:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.model.reports;

/**
 *
 * @author jorismelchior
 */
public class MonthlyStats {
    private int year;
    private String month;
    private Float distance;
    private Float avgDistance;
    private Float maxDistance;
    private int numRides;
    
    /** Creates a new instance of MonthlyStats */
    public MonthlyStats() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
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

    public int getNumRides() {
        return numRides;
    }

    public void setNumRides(int numRides) {
        this.numRides = numRides;
    }
    
    @Override
    public String toString() {
        return "[MonthlyStats] " 
                + "month: " + this.month
                + " year: " + this.year
                + " distance: " + this.distance
                + " avg distance: " + this.avgDistance
                + " max distance: " + this.maxDistance
                + " # rides: " + this.numRides;
    }
}
/* That's All Folks */