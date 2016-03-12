/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nob.bg.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author jorismelchior
 */
public class BikeRideTest {

    public BikeRideTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setId method, of class BikeRide.
     */
    @Test
    public void setId() {
        System.out.println("setId");
        Long id = 10L;
        BikeRide instance = new BikeRide();
        instance.setId(id);
        assertEquals(id, instance.getId());        
    }

    /**
     * Test of setDate method, of class BikeRide.
     */
    @Test
    public void setDate() {
        System.out.println("setDate");
        Date date = new Date();
        BikeRide instance = new BikeRide();
        instance.setDate(date);
        assertEquals(date, instance.getDate());
    }

    /**
     * Test of setStartLocation method, of class BikeRide.
     */
    @Test
    public void setStartLocation() {
        System.out.println("setStartLocation");
        String startLocation = "Rouge Hills Drive";
        BikeRide instance = new BikeRide();
        instance.setStartLocation(startLocation);
        assertEquals(startLocation, instance.getStartLocation());
    }

    /**
     * Test of setFinishLocation method, of class BikeRide.
     */
    @Test
    public void setFinishLocation() {
        System.out.println("setFinishLocation");
        String finishLocation = "483 Bay Street";
        BikeRide instance = new BikeRide();
        instance.setFinishLocation(finishLocation);
        assertEquals(finishLocation, instance.getFinishLocation());
    }

    /**
     * Test of setDistanceKm method, of class BikeRide.
     */
    @Test
    public void setDistanceKm() {
        System.out.println("setDistanceKm");
        Float distanceKm = 30.0F;
        BikeRide instance = new BikeRide();
        instance.setDistanceKm(distanceKm);
        assertEquals(distanceKm, instance.getDistanceKm());
    }

    /**
     * Test of setRideTimeSeconds method, of class BikeRide.
     */
    @Test
    public void setRideTimeSeconds() {
        System.out.println("setRideTimeSeconds");
        Integer rideTimeSeconds = 3600;
        BikeRide instance = new BikeRide();
        instance.setRideTimeSeconds(rideTimeSeconds);
        assertEquals(rideTimeSeconds, instance.getRideTimeSeconds());
    }

    /**
     * Test of setAverageHr method, of class BikeRide.
     */
    @Test
    public void setAverageHr() {
        System.out.println("setAverageHr");
        Integer averageHr = 134;
        BikeRide instance = new BikeRide();
        instance.setAverageHr(averageHr);
        assertEquals(averageHr, instance.getAverageHr());
    }

    /**
     * Test of setMaximumHr method, of class BikeRide.
     */
    @Test
    public void setMaximumHr() {
        System.out.println("setMaximumHr");
        Integer maximumHr = 165;
        BikeRide instance = new BikeRide();
        instance.setMaximumHr(maximumHr);
        assertEquals(maximumHr, instance.getMaximumHr());
    }

    /**
     * Test of setCaloriesBurnt method, of class BikeRide.
     */
    @Test
    public void setCaloriesBurnt() {
        System.out.println("setCaloriesBurnt");
        Integer caloriesBurnt = 1200;
        BikeRide instance = new BikeRide();
        instance.setCaloriesBurnt(caloriesBurnt);
        assertEquals(caloriesBurnt, instance.getCaloriesBurnt());
    }

    /**
     * Test of setJournal method, of class BikeRide.
     */
    @Test
    public void setJournal() {
        System.out.println("setJournal");
        String journal = "Once upon a time ...";
        BikeRide instance = new BikeRide();
        instance.setJournal(journal);
        assertEquals(journal, instance.getJournal());
    }

    /**
     * Test of toString method, of class BikeRide.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BikeRide instance = new BikeRide();
        instance.setId(10012l);
        instance.setDate(new Date(0));
        instance.setDistanceKm(100f);
        instance.setRideTimeSeconds(12000);
        String expResult = "10012; Wed Dec 31 19:00:00 EST 1969; 100.0; 12000";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBikeRider method, of class BikeRide.
     */
    @Test
    public void setBikeRider() {
        System.out.println("setBikeRider");
        BikeRider bikeRider = new BikeRider();
        BikeRide instance = new BikeRide();
        instance.setBikeRider(bikeRider);
        assertEquals(bikeRider, instance.getBikeRider());
    }

    /**
     * Test of getAverageSpeed method, of class BikeRide.
     */
    @Test
    public void getAverageSpeed() {
        System.out.println("getAverageSpeed");
        BikeRide instance = new BikeRide();
        instance.setRideTimeSeconds(3600); // one hour
        instance.setDistanceKm(30.0F); // 30 km
        BigDecimal expResult = new BigDecimal("30.0");
        MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(instance.getAverageSpeed()).round(mc);
        assertEquals(expResult, result);
    }

    /**
     * Test of setBikeRideType method, of class BikeRide.
     */
    @Test
    public void setBikeRideType() {
        System.out.println("setBikeRideType");
        BikeRideType bikeRideType = new BikeRideType();
        BikeRide instance = new BikeRide();
        instance.setBikeRideType(bikeRideType);
        assertEquals(bikeRideType, instance.getBikeRideType());
    }

    /**
     * Test of setBike method, of class BikeRide.
     */
    @Test
    public void setBike() {
        System.out.println("setBike");
        Bike bike = new Bike();
        BikeRide instance = new BikeRide();
        instance.setBike(bike);
        assertEquals(bike, instance.getBike());
    }

    /**
     * Test of setRideTime method, of class BikeRide.
     */
    @Test
    public void setRideTime() {
        System.out.println("setRideTime");
        RideTime rideTime = new RideTime(0, 60, 3600);
        BikeRide instance = new BikeRide();
        Integer expectedSeconds = 7200;
        instance.setRideTime(rideTime);
        assertEquals(rideTime, instance.getRideTime());
        assertEquals(expectedSeconds, instance.getRideTimeSeconds());
        String expectedString = "02:00:00";
        assertEquals(expectedString, instance.getRideTime().toString());
    }

}