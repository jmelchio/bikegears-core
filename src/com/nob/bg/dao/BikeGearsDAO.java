/*
 * BikeGearsDAO.java
 *
 * Created on July 31, 2006, 9:15 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.dao;

import java.util.Collection;

import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeRide;
import com.nob.bg.model.BikeRideType;
import com.nob.bg.model.BikeRider;
import com.nob.bg.model.BikeType;
import com.nob.bg.model.Person;
import com.nob.bg.model.dto.LoginDTO;

/**
 *
 * @author jorismelchior
 */
public interface BikeGearsDAO {
    BikeRider login(LoginDTO login);
    
    Bike createBike(Bike bike);
    void changeBike(Bike bike);
    Bike getBikeById(Long id);
    void deleteBike(Bike bike);
    void deleteBikeById(Long id);
    Collection<Bike> getBikes();
    Collection<Bike> getBikesForRider(BikeRider rider);
    Collection<Bike> getBikesForRiderById(Long bikeRiderId);
    Bike getBikeForRide(BikeRide ride);
    
    BikeRide createBikeRide(BikeRide ride);
    void changeBikeRide(BikeRide ride);
    BikeRide getBikeRideById(Long id);
    void deleteBikeRide(BikeRide ride);
    void deleteBikeRideById(Long id);
    Collection<BikeRide> getBikeRides(Integer rowLimit);
    Collection<BikeRide> getBikeRidesForRider(BikeRider rider, Integer rowLimit);
    Collection<BikeRide> getBikeRidesForRiderById(Long bikeRiderId, Integer rowLimit);

    BikeRideType createBikeRideType(BikeRideType rideType);
    void changeBikeRideType(BikeRideType rideType);
    BikeRideType getBikeRideTypeById(Long id);
    void deleteBikeRideType(BikeRideType rideType);
    void deleteBikeRideTypeById(Long id);
    Collection<BikeRideType> getBikeRideTypes();
    BikeRideType getBikeRideTypeForRide(BikeRide ride);

    BikeRider createBikeRider(BikeRider rider);
    void changeBikeRider(BikeRider rider);
    BikeRider getBikeRiderById(Long id);
    void deleteBikeRider(BikeRider rider);
    void deleteBikeRiderById(Long id);
    Collection<BikeRider> getBikeRiders();
    BikeRider getBikeRiderForBikeRide(BikeRide ride);

    BikeType createBikeType(BikeType bikeType);
    void changeBikeType(BikeType bikeType);
    BikeType getBikeTypeById(Long id);
    void deleteBikeType(BikeType bikeType);
    void deleteBikeTypeById(Long id);
    Collection<BikeType> getBikeTypes();
    BikeType getBikeTypeForBike(Bike bike);

    Person createPerson(Person person);
    Person getPersonById(Long id);
    void changePerson(Person person);
    Collection<Person> getPeople();
    void deletePerson(Person person);
    void deletePersonById(Long id);
    Person getPersonForBikeRider(BikeRider rider);

}
/* That's All Folks !! */