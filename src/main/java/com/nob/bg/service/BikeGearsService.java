/*
 * BikeGearsService.java
 *
 * Created on July 31, 2006, 9:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.service;

import java.util.Collection;

import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeRide;
import com.nob.bg.model.BikeRideType;
import com.nob.bg.model.BikeRider;
import com.nob.bg.model.BikeType;
import com.nob.bg.model.Person;
import com.nob.bg.model.dto.LoginDTO;
import com.nob.bg.model.reports.DistToDate;
import com.nob.bg.model.reports.MonthlyStats;

/**
 * 
 * @author jorismelchior
 */
public interface BikeGearsService {
    BikeRider login(LoginDTO login);
    
    void createBike(Bike bike);
    void changeBike(Bike bike);
    Bike getBikeById(Long id);
    void deleteBike(Bike bike);
    void deleteBikebyId(Long id);
    Collection<Bike> getBikes();
    Collection<Bike> getBikesForRider(BikeRider rider);
    Collection<Bike> getBikesForRiderById(Long bikeRiderId);
    Bike getBikeForRide(BikeRide ride);

    void createBikeRide(BikeRide ride);
    void changeBikeRide(BikeRide ride);
    BikeRide getBikeRideById(Long id);
    void deleteBikeRide(BikeRide ride);
    void deleteBikeRideById(Long id);
    Collection<BikeRide> getBikeRides(Integer rowLimit);
    Collection<BikeRide> getBikeRidesForRider(BikeRider rider, Integer rowLimit);
    Collection<BikeRide> getBikeRidesForRiderById(Long bikeRiderId,
            Integer rowLimit);

    void createBikeRideType(BikeRideType rideType);
    void changeBikeRideType(BikeRideType rideType);
    BikeRideType getBikeRideTypeById(Long id);
    void deleteBikeRideType(BikeRideType rideType);
    void deleteBikeRideTypeById(Long id);
    Collection<BikeRideType> getBikeRideTypes();
    BikeRideType getBikeRideTypeForRide(BikeRide ride);

    void createBikeRider(BikeRider rider);
    void changeBikeRider(BikeRider rider);
    BikeRider getBikeRiderById(Long id);
    void deleteBikeRider(BikeRider rider);
    void deleteBikeRiderById(Long id);
    Collection<BikeRider> getBikeRiders();
    BikeRider getBikeRiderForBikeRide(BikeRide ride);

    void createBikeType(BikeType bikeType);
    void changeBikeType(BikeType bikeType);
    BikeType getBikeTypeById(Long id);
    void deleteBikeType(BikeType bikeType);
    void deleteBikeTypeById(Long id);
    Collection<BikeType> getBikeTypes();
    BikeType getBikeTypeForBike(Bike bike);

    void createPerson(Person person);
    void changePerson(Person person);
    Person getPersonById(Long id);
    void deletePerson(Person person);
    void deletePersonById(Long id);
    Collection<Person> getPeople();
    Person getPersonForBikeRider(BikeRider rider);
    
    Collection<DistToDate> getDistToDateForBikeRider(BikeRider bikeRider);
    Collection<MonthlyStats> getMonthlyStatsForBikeRider(BikeRider bikeRider);
    Collection<MonthlyStats> getMonthComparisonForBikeRider(BikeRider bikeRider);
    Collection<DistToDate> getDistToDateForPersonById(Long id);
    Collection<MonthlyStats> getMonthlyStatsForPersonById(Long id);
    Collection<MonthlyStats> getMonthComparisonForPersonById(Long id);

}

/* That's All Folks !! */
