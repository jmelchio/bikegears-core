package com.nob.bg.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Describes a bike ride
 * @author jorismelchior
 */
public class BikeRide implements Serializable {

    private static final long serialVersionUID = 2612179650976911206L;
    private Long id;
    private Date date;
    private String startLocation;
    private String finishLocation;
    private Float distanceKm;
    private Integer rideTimeSeconds;
    private RideTime rideTime;
    private Integer averageHr;
    private Integer maximumHr;
    private Integer caloriesBurnt;
    private String journal;
    private BikeRider bikeRider;
    private BikeRideType bikeRideType;
    private Bike bike;

    /** Creates a new instance of BikeRide */
    public BikeRide() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getFinishLocation() {
        return finishLocation;
    }

    public void setFinishLocation(String finishLocation) {
        this.finishLocation = finishLocation;
    }

    public Float getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Float distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Integer getRideTimeSeconds() {
        return rideTimeSeconds;
    }

    public void setRideTimeSeconds(Integer rideTimeSeconds) {
        if (rideTimeSeconds != null) {
            this.rideTimeSeconds = rideTimeSeconds;
            rideTime = new RideTime();
            rideTime.setRideTimeInSeconds(this.rideTimeSeconds);
        }
    }

    public Integer getAverageHr() {
        return averageHr;
    }

    public void setAverageHr(Integer averageHr) {
        this.averageHr = averageHr;
    }

    public Integer getMaximumHr() {
        return maximumHr;
    }

    public void setMaximumHr(Integer maximumHr) {
        this.maximumHr = maximumHr;
    }

    public Integer getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(Integer caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    @Override
    public String toString() {
        return this.id + "; " + this.date + "; " + this.distanceKm + "; " + this.rideTimeSeconds;
    }

    public BikeRider getBikeRider() {
        return bikeRider;
    }

    public void setBikeRider(BikeRider bikeRider) {
        this.bikeRider = bikeRider;
    }

    public Float getAverageSpeed() {
        return new Float((this.distanceKm.floatValue() / this.rideTimeSeconds.floatValue()) * 3600);
    }

    public BikeRideType getBikeRideType() {
        return bikeRideType;
    }

    public void setBikeRideType(BikeRideType bikeRideType) {
        this.bikeRideType = bikeRideType;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public RideTime getRideTime() {
        if (rideTime == null && rideTimeSeconds != null) {
            rideTime = new RideTime();
            rideTime.setRideTimeInSeconds(rideTimeSeconds);
        }
        return rideTime;
    }

    public void setRideTime(RideTime rideTime) {
        if (rideTime != null) {
            this.rideTime = rideTime;
            this.rideTimeSeconds = this.rideTime.getRideTimeInSeconds();
        }
    }
}
/* That's All Folks!! */
