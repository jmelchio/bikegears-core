/*
 * BikeGearsServiceImpl.java
 *
 * Created on July 31, 2006, 10:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.service;

import java.util.Collection;

import com.nob.bg.dao.BikeGearsDAO;
import com.nob.bg.dao.BikeGearsReportDAO;
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
public class BikeGearsServiceImpl implements BikeGearsService {
    private BikeGearsDAO bgDAO;
    private BikeGearsReportDAO bgReportDAO;
    
    /** Creates a new instance of BikeGearsServiceImpl */
    public BikeGearsServiceImpl() {
    }

    public BikeRider login(LoginDTO login) {
        return bgDAO.login(login);
    }
    
    public void setBgDAO(BikeGearsDAO bgDao) {
        this.bgDAO = bgDao;
    }

    public void createBike(Bike bike) {
        bgDAO.createBike(bike);
    }

    public void changeBike(Bike bike) {
        bgDAO.changeBike(bike);
    }

    public Bike getBikeById(Long id) {
        return bgDAO.getBikeById(id);
    }

    public void deleteBike(Bike bike) {
        bgDAO.deleteBike(bike);
    }

    public Collection<Bike> getBikes() {
        return bgDAO.getBikes();
    }

    public Collection<Bike> getBikesForRider(BikeRider rider) {
        return bgDAO.getBikesForRider(rider);
    }

    public void createBikeRide(BikeRide ride) {
        bgDAO.createBikeRide(ride);
    }

    public void changeBikeRide(BikeRide ride) {
        bgDAO.changeBikeRide(ride);
    }

    public BikeRide getBikeRideById(Long id) {
        return bgDAO.getBikeRideById(id);
    }

    public void deleteBikeRide(BikeRide ride) {
        bgDAO.deleteBikeRide(ride);
    }

    public Collection<BikeRide> getBikeRides(Integer rowLimit) {
        return bgDAO.getBikeRides(rowLimit);
    }

    public Collection<BikeRide> getBikeRidesForRider(BikeRider rider, Integer rowLimit) {
        return bgDAO.getBikeRidesForRider(rider, rowLimit);
    }

    public void createBikeRideType(BikeRideType rideType) {
        bgDAO.createBikeRideType(rideType);
    }

    public void changeBikeRideType(BikeRideType rideType) {
        bgDAO.changeBikeRideType(rideType);
    }

    public BikeRideType getBikeRideTypeById(Long id) {
        return bgDAO.getBikeRideTypeById(id);
    }

    public void deleteBikeRideType(BikeRideType rideType) {
        bgDAO.deleteBikeRideType(rideType);
    }

    public Collection<BikeRideType> getBikeRideTypes() {
        return bgDAO.getBikeRideTypes();
    }

    public void createBikeRider(BikeRider rider) {
        bgDAO.createBikeRider(rider);
    }

    public void changeBikeRider(BikeRider rider) {
        bgDAO.changeBikeRider(rider);
    }

    public BikeRider getBikeRiderById(Long id) {
        return bgDAO.getBikeRiderById(id);
    }

    public void deleteBikeRider(BikeRider rider) {
        bgDAO.deleteBikeRider(rider);
    }

    public Collection<BikeRider> getBikeRiders() {
        return bgDAO.getBikeRiders();
    }

    public void createBikeType(BikeType bikeType) {
        bgDAO.createBikeType(bikeType);
    }

    public void changeBikeType(BikeType bikeType) {
        bgDAO.changeBikeType(bikeType);
    }

    public BikeType getBikeTypeById(Long id) {
        return bgDAO.getBikeTypeById(id);
    }

    public void deleteBikeType(BikeType bikeType) {
        bgDAO.deleteBikeType(bikeType);
    }

    public Collection<BikeType> getBikeTypes() {
        return bgDAO.getBikeTypes();
    }

    public void createPerson(Person person) {
        bgDAO.createPerson(person);
    }

    public void changePerson(Person person) {
        bgDAO.changePerson(person);
    }

    public Person getPersonById(Long id) {
        return bgDAO.getPersonById(id);
    }

    public void deletePerson(Person person) {
        bgDAO.deletePerson(person);
    }

    public Collection<Person> getPeople() {
        return bgDAO.getPeople();
    }

    public Collection<Bike> getBikesForRiderById(Long bikeRiderId) {
        return bgDAO.getBikesForRiderById(bikeRiderId);
    }

    public Collection<BikeRide> getBikeRidesForRiderById(Long bikeRiderId, Integer rowLimit) {
        return bgDAO.getBikeRidesForRiderById(bikeRiderId, rowLimit);
    }

    public void deleteBikebyId(Long id) {
        bgDAO.deleteBikeById(id);
    }

    public void deleteBikeRideById(Long id) {
        bgDAO.deleteBikeRideById(id);
    }

    public void deleteBikeRideTypeById(Long id) {
        bgDAO.deleteBikeRideTypeById(id);
    }

    public void deleteBikeRiderById(Long id) {
        bgDAO.deleteBikeRiderById(id);
    }

    public void deleteBikeTypeById(Long id) {
        bgDAO.deleteBikeTypeById(id);
    }

    public void deletePersonById(Long id) {
        bgDAO.deletePersonById(id);
    }

    public Collection<DistToDate> getDistToDateForBikeRider(BikeRider bikeRider) {
        return bgReportDAO.getDistToDateForBikeRider(bikeRider);
    }

    public Collection<MonthlyStats> getMonthlyStatsForBikeRider(BikeRider bikeRider) {
        return bgReportDAO.getMonthlyStatsForBikeRider(bikeRider);
    }

    public Collection<MonthlyStats> getMonthComparisonForBikeRider(BikeRider bikeRider) {
        return bgReportDAO.getMonthComparisonForBikeRider(bikeRider);
    }

    public Collection<DistToDate> getDistToDateForPersonById(Long id) {
        return bgReportDAO.getDistToDateForBikeRiderById(id);
    }

    public Collection<MonthlyStats> getMonthlyStatsForPersonById(Long id) {
        return bgReportDAO.getMonthlyStatsForBikeRiderById(id);
    }

    public Collection<MonthlyStats> getMonthComparisonForPersonById(Long id) {
        return bgReportDAO.getMonthComparisonForBikeRiderById(id);
    }

    public Bike getBikeForRide(BikeRide ride) {
        return bgDAO.getBikeForRide(ride);
    }

    public BikeRideType getBikeRideTypeForRide(BikeRide ride) {
        return bgDAO.getBikeRideTypeForRide(ride);
    }

    public BikeType getBikeTypeForBike(Bike bike) {
        return bgDAO.getBikeTypeForBike(bike);
    }

    public Person getPersonForBikeRider(BikeRider rider) {
        return bgDAO.getPersonForBikeRider(rider);
    }

    public BikeRider getBikeRiderForBikeRide(BikeRide ride) {
        return bgDAO.getBikeRiderForBikeRide(ride);
    }

    /**
     * @param bgReportDAO the bgReportDAO to set
     */
    public void setBgReportDAO(BikeGearsReportDAO bgReportDAO) {
        this.bgReportDAO = bgReportDAO;
    }
}
/* That's All Folks */