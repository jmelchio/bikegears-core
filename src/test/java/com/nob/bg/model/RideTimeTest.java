/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nob.bg.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorismelchior
 */
public class RideTimeTest {
    
    public RideTimeTest() {
    }            

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getHours method, of class RideTime.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        RideTime instance = new RideTime(10, 5, 30);
        Integer expResult = 10;
        Integer result = instance.getHours();
        assertTrue(expResult.intValue() == result.intValue());
    }

    /**
     * Test of getMinutes method, of class RideTime.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        RideTime instance = new RideTime(0, 37, 0);
        Integer expResult = 37;
        Integer result = instance.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRideTimeInSeconds method, of class RideTime.
     */
    @Test
    public void testGetRideTimeInSeconds() {
        System.out.println("getRideTimeInSeconds");
        RideTime instance = new RideTime(1, 50, 35);
        Integer expResult = 6635;
        Integer result = instance.getRideTimeInSeconds();
        assertTrue(expResult.intValue() == result.intValue());
    }

    /**
     * Test of getSeconds method, of class RideTime.
     */
    @Test
    public void testGetSeconds() {
        System.out.println("getSeconds");
        RideTime instance = new RideTime(0, 0, 30);
        Integer expResult = 30;
        Integer result = instance.getSeconds();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHours method, of class RideTime.
     */
    @Test
    public void testSetHours() {
        System.out.println("setHours");
        Integer hours = 4;
        RideTime instance = new RideTime(6, 0, 0);
        instance.setHours(hours);
        assertEquals(hours, instance.getHours());
    }

    /**
     * Test of setMinutes method, of class RideTime.
     */
    @Test
    public void testSetMinutes() {
        System.out.println("setMinutes");
        Integer minutes = 10;
        RideTime instance = new RideTime();
        instance.setMinutes(minutes);
        assertEquals(minutes.intValue(), instance.getMinutes().intValue());
    }

    /**
     * Test of setRideTimeInSeconds method, of class RideTime.
     */
    @Test
    public void testSetRideTimeInSeconds() {
        System.out.println("setRideTimeInSeconds");
        Integer seconds = 6630;
        RideTime instance = new RideTime();
        instance.setRideTimeInSeconds(seconds);
        assertTrue(instance.getHours().intValue() == 1 
                && instance.getMinutes().intValue() == 50
                && instance.getSeconds().intValue() == 30);
    }

    /**
     * Test of setSeconds method, of class RideTime.
     */
    @Test
    public void testSetSeconds() {
        System.out.println("setSeconds");
        Integer seconds = 37;
        RideTime instance = new RideTime();
        instance.setSeconds(seconds);
        assertEquals(seconds, instance.getSeconds());
    }

    /**
     * Test of the toString method, of class RideTime
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RideTime instance = new RideTime(5, 35, 43);
        String expected = "05:35:43";
        assertEquals(expected, instance.toString());
    }

}
