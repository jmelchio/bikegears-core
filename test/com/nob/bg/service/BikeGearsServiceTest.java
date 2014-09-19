package com.nob.bg.service;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nob.bg.model.Bike;
import com.nob.bg.model.BikeRide;
import com.nob.bg.model.BikeRideType;
import com.nob.bg.model.BikeRider;
import com.nob.bg.model.BikeType;
import com.nob.bg.model.Person;
import com.nob.bg.model.dto.LoginDTO;
import com.nob.bg.model.reports.DistToDate;
import com.nob.bg.model.reports.MonthlyStats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring/hibernate_bgbusconfig.xml" })
public class BikeGearsServiceTest {
    public static String NOT_YET = "No testcase ready yet";

    @Autowired
    private BikeGearsService service;

    public BikeGearsServiceTest() {
    }

    @Test
    public void testLogin() {
        BikeRider rider = new BikeRider();
        rider.setUserName("testLogin");
        rider.setPassword("supersecret");
        service.createBikeRider(rider);
        LoginDTO login = new LoginDTO();
        login.setUserName("testLogin");
        login.setPassword("supersecret");
        BikeRider loggedIn = service.login(login);
        assertNotNull(loggedIn);
        assertEquals(rider.getUserName(), loggedIn.getUserName());
        assertEquals(rider.getPassword(), loggedIn.getPassword());
        service.deleteBikeRider(rider);
    }
    
    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.createBike(Bike)'
     */
    @Test
    public void shouldCreateBike() {
        Long removeId = null;
        Bike bike = new Bike();
        bike.setBrand("Cervelo");
        bike.setModel("P3");
        bike.setColor("Black/Red");
        bike.setDescription("Some flashy bike for time trials");
        bike.setYear(2005);
        bike.setBikeType(null);
        bike.setBikeRider(null);
        service.createBike(bike);
        Collection<Bike> bikes = service.getBikes();
        for (Bike tBike : bikes) {
            if (tBike.getBrand().equals("Cervelo")
                    && bike.getModel().equals("P3")) {
                removeId = new Long(tBike.getId());
            }
        }
        assertNotNull("Inserted bike not found back", removeId);
        bike.setId(removeId);
        System.out.println("inserted: " + bike);
        service.deleteBike(bike);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.changeBike(Bike)'
     */
    @Test
    public void testChangeBike() {
        Long removeId = null;
        Bike bike = new Bike();
        bike.setBrand("Cervelo");
        bike.setModel("P3");
        bike.setColor("Black/Red");
        bike.setDescription("Some flashy bike for time trials");
        bike.setYear(2005);
        bike.setBikeType(null);
        bike.setBikeRider(null);
        service.createBike(bike);
        Collection<Bike> bikes = service.getBikes();
        for (Bike tBike : bikes) {
            if (tBike.getBrand().equals("Cervelo")
                    && bike.getModel().equals("P3")) {
                removeId = new Long(tBike.getId());
            }
        }
        assertNotNull("Inserted bike not found back", removeId);
        bike.setId(removeId);
        bike.setModel("Soloist");
        service.changeBike(bike);
        Bike updatedBike = service.getBikeById(removeId);
        assertEquals("Not the expected model", updatedBike.getModel(),
                "Soloist");
        System.out.println("changed bike model to Soloist: " + updatedBike);

        service.deleteBike(bike);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getBikeById(int)'
     */
    @Test
    public void testGetBikeById() {
        Bike aBike = service.getBikeById(1L);
        assertNotNull("No bike returned", aBike);
        assertTrue("Not the right bike", aBike.getId() == 1);
        System.out.println("got bike by id: " + aBike);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.deleteBike(Bike)'
     */
    @Test
    public void testDeleteBike() {
        Long removeId = null;
        Bike bike = new Bike();
        bike.setBrand("Cervelo");
        bike.setModel("P3");
        bike.setColor("Black/Red");
        bike.setDescription("Some flashy bike for time trials");
        bike.setYear(2005);
        bike.setBikeType(null);
        bike.setBikeRider(null);
        service.createBike(bike);
        Collection<Bike> bikes = service.getBikes();
        // get the last bike ...
        for (Bike cBike : bikes) {
            removeId = cBike.getId();
        }
        service.deleteBikebyId(removeId);
        try {
            assertNull("Bike was not deleted", service.getBikeById(removeId));
        } catch (EmptyResultDataAccessException daEx) {
            assertNotNull("Expected exception not thrown", daEx);
        }
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getBikes()'
     */
    @Test
    public void testGetBikes() {
        Collection<Bike> bikes = service.getBikes();

        assertTrue("List is null", bikes != null);
        assertTrue("List is empty", bikes.size() > 0);
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.getBikesForRider(BikeRider)'
     */
    @Test
    public void testGetBikesForRider() {
        BikeRider bikeRider = service.getBikeRiderById(22L);
        assertNotNull("No rider returned", bikeRider);
        Collection<Bike> bikes = service.getBikesForRider(bikeRider);
        assertNotNull("No bikes returned", bikes);
        assertTrue("Bike list empty", bikes.size() > 0);
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.createBikeRide(BikeRide)'
     */
    @Test
    public void testCreateBikeRide() {
        BikeRide ride = new BikeRide();
        ride.setBikeRider(null);
        ride.setBike(null);
        ride.setBikeRideType(null);
        ride.setAverageHr(130);
        ride.setCaloriesBurnt(1500);
        ride.setDate(new Date());
        ride.setDistanceKm(60.0f);
        ride.setFinishLocation("TestLocation");
        ride.setJournal("testCreateBikeRide");
        ride.setMaximumHr(155);
        ride.setRideTimeSeconds(7200);
        ride.setStartLocation("TestLocation");
        service.createBikeRide(ride);
        Collection<BikeRide> rides = service.getBikeRides(5);
        assertNotNull("No rides returned", rides);
        assertTrue("Ride list empty", rides.size() > 0);
        Long rideId = null;
        for (BikeRide ridee : rides) {
            if (ridee.getJournal().equals("testCreateBikeRide")) {
                rideId = ridee.getId();
            }
        }
        assertNotNull("Ride not created", rideId);
        service.deleteBikeRideById(rideId);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.changeBikeRide(BikeRide)'
     */
    @Test
    public void testChangeBikeRide() {
        BikeRide ride = new BikeRide();
        ride.setBikeRider(null);
        ride.setBike(null);
        ride.setBikeRideType(null);
        ride.setAverageHr(130);
        ride.setCaloriesBurnt(1500);
        ride.setDate(new Date());
        ride.setDistanceKm(60.0f);
        ride.setFinishLocation("TestLocation");
        ride.setJournal("testChangeBikeRide");
        ride.setMaximumHr(155);
        ride.setRideTimeSeconds(7200);
        ride.setStartLocation("TestLocation");
        service.createBikeRide(ride);
        Collection<BikeRide> rides = service.getBikeRides(100);
        assertNotNull("No rides returned", rides);
        assertTrue("Ride list empty", rides.size() > 0);
        Long rideId = null;
        for (BikeRide ridee : rides) {
            if (ridee.getJournal().equals("testChangeBikeRide")) {
                rideId = ridee.getId();
            }
        }
        assertNotNull("Ride not created", rideId);
        ride = service.getBikeRideById(rideId);
        ride.setFinishLocation("changedFinishLocation");
        service.changeBikeRide(ride);
        ride = service.getBikeRideById(rideId);
        assertEquals("Not the expected field value", "changedFinishLocation",
                ride.getFinishLocation());
        service.deleteBikeRideById(rideId);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.getBikeRideById(int)'
     */
    @Test
    public void testGetBikeRideById() {
        BikeRide ride = new BikeRide();
        ride.setBikeRider(null);
        ride.setBike(null);
        ride.setBikeRideType(null);
        ride.setAverageHr(130);
        ride.setCaloriesBurnt(1500);
        ride.setDate(new Date());
        ride.setDistanceKm(60.0f);
        ride.setFinishLocation("TestLocation");
        ride.setJournal("testGetBikeRideById");
        ride.setMaximumHr(155);
        ride.setRideTimeSeconds(7200);
        ride.setStartLocation("TestLocation");
        service.createBikeRide(ride);
        Collection<BikeRide> rides = service.getBikeRides(5);
        assertNotNull("No rides returned", rides);
        assertTrue("Ride list empty", rides.size() > 0);
        Long rideId = null;
        for (BikeRide ridee : rides) {
            if (ridee.getJournal().equals("testGetBikeRideById")) {
                rideId = ridee.getId();
            }
        }
        assertNotNull("Ride not created", rideId);
        BikeRide idRide = null;
        try {
            idRide = service.getBikeRideById(rideId);
        } catch (EmptyResultDataAccessException erEx) {
            fail("Expected row not returned");
        }
        assertTrue("Incorrect ride returned", rideId.longValue() == idRide
                .getId().longValue());
        service.deleteBikeRideById(rideId);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.deleteBikeRide(BikeRide)'
     */
    @Test
    public void testDeleteBikeRide() {
        BikeRide ride = new BikeRide();
        ride.setBikeRider(null);
        ride.setBike(null);
        ride.setBikeRideType(null);
        ride.setAverageHr(130);
        ride.setCaloriesBurnt(1500);
        ride.setDate(new Date());
        ride.setDistanceKm(60.0f);
        ride.setFinishLocation("TestLocation");
        ride.setJournal("testDeleteBikeRide");
        ride.setMaximumHr(155);
        ride.setRideTimeSeconds(7200);
        ride.setStartLocation("TestLocation");
        service.createBikeRide(ride);

        Collection<BikeRide> bikeRides = service.getBikeRides(100);
        Long rideId = null;
        for (BikeRide ridee : bikeRides) {
            if (ridee.getJournal().equals("testDeleteBikeRide")) {
                rideId = ridee.getId();
            }
        }
        assertNotNull("No Rides returned", bikeRides);
        assertNotNull("Created ride not found", rideId);
        service.deleteBikeRideById(rideId);
        BikeRide noRide = null;
        try {
            noRide = service.getBikeRideById(rideId);
        } catch (EmptyResultDataAccessException edEx) {
            // the dreaded empty catch block
        }
        assertNull("BikeRide not deleted", noRide);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getBikeRides()'
     */
    @Test
    public void testGetBikeRides() {
        BikeRide ride = new BikeRide();
        ride.setBikeRider(null);
        ride.setBike(null);
        ride.setBikeRideType(null);
        ride.setAverageHr(130);
        ride.setCaloriesBurnt(1500);
        ride.setDate(new Date());
        ride.setDistanceKm(60.0f);
        ride.setFinishLocation("TestLocation");
        ride.setJournal("testGetBikeRides");
        ride.setMaximumHr(155);
        ride.setRideTimeSeconds(7200);
        ride.setStartLocation("TestLocation");
        service.createBikeRide(ride);

        Collection<BikeRide> bikeRides = service.getBikeRides(100);
        Long rideId = null;
        for (BikeRide ridee : bikeRides) {
            if (ridee.getJournal().equals("testGetBikeRides")) {
                rideId = ridee.getId();
            }
        }
        assertTrue("List is null", bikeRides != null);
        assertTrue("List is empty", bikeRides.size() > 0);
        for (BikeRide aRide : bikeRides) {
            System.out.println(aRide);
        }
        service.deleteBikeRideById(rideId);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.getBikeRidesForRider(BikeRider)'
     */
    @Test
    public void testGetBikeRidesForRider() {
        Person person = new Person();
        person.setId(0l);
        BikeRider rider = new BikeRider();
        rider.setUserName("ForRider");
        rider.setPassword("password");
        rider.setSince(new Date());
        rider.setPerson(person);
        service.createBikeRider(rider);
        Collection<BikeRider> riders = service.getBikeRiders();
        for (BikeRider rrider : riders) {
            if (rrider.getUserName() != null
                    && rrider.getUserName().equals("ForRider")) {
                rider = rrider;
                break;
            }
        }
        BikeRide ride = new BikeRide();
        ride.setBikeRider(rider);
        ride.setBike(null);
        ride.setBikeRideType(null);
        ride.setAverageHr(130);
        ride.setCaloriesBurnt(1500);
        ride.setDate(new Date());
        ride.setDistanceKm(60.0f);
        ride.setFinishLocation("TestLocation");
        ride.setJournal("testGetBikeRidesForRider");
        ride.setMaximumHr(155);
        ride.setRideTimeSeconds(7200);
        ride.setStartLocation("TestLocation");
        service.createBikeRide(ride);
        ride = null;

        Collection<BikeRide> rides = service.getBikeRidesForRider(rider, 10);
        assertTrue("No rides returned for rider", rides != null
                && rides.size() > 0);
        for (BikeRide rride : rides) {
            System.out.println(rride);
            if (rride.getJournal().equals("testGetBikeRidesForRider")) {
                ride = rride;
            }
        }
        assertTrue("Inserted ride not found", ride != null);
        service.deleteBikeRide(ride);
        service.deleteBikeRider(rider);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.createBikeRideType(BikeRideType)'
     */
    @Test
    public void testCreateBikeRideType() {
        BikeRideType bikeRideType = new BikeRideType();
        bikeRideType.setName("BikeRideType");
        service.createBikeRideType(bikeRideType);
        Collection<BikeRideType> rideTypes = service.getBikeRideTypes();
        BikeRideType returnedRideType = null;
        for (BikeRideType aRideType : rideTypes) {
            if (aRideType.getName().equals("BikeRideType")) {
                returnedRideType = aRideType;
                break;
            }
        }
        assertNotNull(returnedRideType);
        service.deleteBikeRideType(returnedRideType);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.changeBikeRideType(BikeRideType)'
     */
    @Test
    public void testChangeBikeRideType() {
        BikeRideType bikeRideType = new BikeRideType();
        bikeRideType.setName("ChangeRideType");
        service.createBikeRideType(bikeRideType);
        Collection<BikeRideType> rideTypes = service.getBikeRideTypes();
        BikeRideType returnedRideType = null;
        for (BikeRideType aRideType : rideTypes) {
            if (aRideType.getName().equals("ChangeRideType")) {
                returnedRideType = aRideType;
                break;
            }
        }
        Long rideTypeId = returnedRideType.getId();
        returnedRideType.setName("OtherRideType");
        service.changeBikeRideType(returnedRideType);
        BikeRideType changedType = service.getBikeRideTypeById(rideTypeId);
        assertEquals("OtherRideType", changedType.getName());
        service.deleteBikeRideType(changedType);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.getBikeRideTypeById(int)'
     */
    @Test
    public void testGetBikeRideTypeById() {
        BikeRideType bikeRideType = new BikeRideType();
        bikeRideType.setName("getByIDTest");
        service.createBikeRideType(bikeRideType);
        Collection<BikeRideType> brTypes = service.getBikeRideTypes();
        Long id = null;
        for (BikeRideType rideType : brTypes) {
            if (rideType.getName().equals("getByIDTest")) {
                id = rideType.getId();
                break;
            }
        }
        BikeRideType gbidType = service.getBikeRideTypeById(id);
        assertNotNull(gbidType);
        assertEquals("getByIDTest", gbidType.getName());
        service.deleteBikeRideTypeById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.deleteBikeRideType(BikeRideType)'
     */
    @Test
    public void testDeleteBikeRideType() {
        BikeRideType rideType = new BikeRideType();
        String typeName = "deleteTest";
        rideType.setName(typeName);
        String description = "testDeleteDescription";
        rideType.setDescription(description );
        service.createBikeRideType(rideType);
        Collection<BikeRideType> rideTypes = service.getBikeRideTypes();
        Long id = null;
        for(BikeRideType rideTypeInstance: rideTypes) {
            if(rideTypeInstance.getName().equals(typeName)) {
                id = rideTypeInstance.getId();
            }
        }
        assertNotNull(id);
        service.deleteBikeRideTypeById(id);
        BikeRideType gone = service.getBikeRideTypeById(id);
        assertNull(gone);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getBikeRideTypes()'
     */
    @Test
    public void testGetBikeRideTypes() {
        Collection<BikeRideType> bikeRideTypes = service.getBikeRideTypes();

        assertTrue("List is null", bikeRideTypes != null);
        assertTrue("List is empty", bikeRideTypes.size() > 0);
        for (BikeRideType bikeRideType : bikeRideTypes) {
            System.out.println(bikeRideType);
        }
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.createBikeRider(BikeRider)'
     */
    public void testCreateBikeRider() {
        BikeRider rider = new BikeRider();
        String userName = "createTest";
        rider.setUserName(userName);
        String password = "createTestPassword";
        rider.setPassword(password);
        service.createBikeRider(rider);
        Collection<BikeRider> riders = service.getBikeRiders();
        Long id = null;
        for(BikeRider riderGet: riders) {
            if(rider.getUserName().equals(userName)) {
                id = riderGet.getId();
            }
        }
        assertNotNull(id);
        service.deleteBikeRiderById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.changeBikeRider(BikeRider)'
     */
    @Test
    public void testChangeBikeRider() {
        BikeRider rider = new BikeRider();
        String userName = "changeTest";
        rider.setUserName(userName);
        String password = "changeTestPassword";
        rider.setPassword(password);
        service.createBikeRider(rider);
        Collection<BikeRider> riders = service.getBikeRiders();
        BikeRider beforeChange = null;
        for(BikeRider riderGet: riders) {
            if(rider.getUserName().equals(userName)) {
                beforeChange = riderGet;
            }
        }
        assertNotNull(beforeChange);
        String newusername = "newusername";
        beforeChange.setUserName(newusername);
        Long id = beforeChange.getId();
        service.changeBikeRider(beforeChange);
        BikeRider afterChange = service.getBikeRiderById(id);
        assertNotNull(afterChange);
        assertNotSame(afterChange.getUserName(), userName);
        assertEquals(afterChange.getUserName(), newusername);
        service.deleteBikeRiderById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.getBikeRiderById(int)'
     */
    @Test
    public void testGetBikeRiderById() {
        BikeRider rider = new BikeRider();
        String userName = "getByIdTest";
        rider.setUserName(userName);
        String password = "getByIdTestPassword";
        rider.setPassword(password);
        service.createBikeRider(rider);
        Collection<BikeRider> riders = service.getBikeRiders();
        Long id = null;
        for(BikeRider riderGet: riders) {
            if(rider.getUserName().equals(userName)) {
                id = riderGet.getId();
            }
        }
        assertNotNull(id);
        BikeRider byID = service.getBikeRiderById(id);
        assertNotNull(byID);
        service.deleteBikeRiderById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.deleteBikeRider(BikeRider)'
     */
    @Test
    public void testDeleteBikeRider() {
        BikeRider rider = new BikeRider();
        String userName = "deleteTest";
        rider.setUserName(userName);
        String password = "deleteTestPassword";
        rider.setPassword(password);
        service.createBikeRider(rider);
        Collection<BikeRider> riders = service.getBikeRiders();
        Long id = null;
        for(BikeRider riderGet: riders) {
            if(rider.getUserName().equals(userName)) {
                id = riderGet.getId();
            }
        }
        assertNotNull(id);
        service.deleteBikeRiderById(id);
        BikeRider gone = service.getBikeRiderById(id);
        assertNull(gone);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getBikeRiders()'
     */
    @Test
    public void testGetBikeRiders() {
        Collection<BikeRider> bikeRiders = service.getBikeRiders();

        assertTrue("List is null", bikeRiders != null);
        assertTrue("List is empty", bikeRiders.size() > 0);
        for (BikeRider rider : bikeRiders) {
            System.out.println(rider);
        }
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.createBikeType(BikeType)'
     */
    @Test
    public void testCreateBikeType() {
        BikeType bikeType = new BikeType();
        String name = "createTest";
        bikeType.setName(name);
        service.createBikeType(bikeType);
        Collection<BikeType> types = service.getBikeTypes();
        Long id = null;
        for(BikeType fetchType: types) {
            if(fetchType.getName().equals(name)) {
                id = fetchType.getId();
            }
        }
        assertNotNull(id);
        service.deleteBikeTypeById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.changeBikeType(BikeType)'
     */
    @Test
    public void testChangeBikeType() {
        BikeType bikeType = new BikeType();
        String name = "changeTest";
        bikeType.setName(name);
        service.createBikeType(bikeType);
        Collection<BikeType> types = service.getBikeTypes();
        Long id = null;
        for(BikeType fetchType: types) {
            if(fetchType.getName().equals(name)) {
                id = fetchType.getId();
            }
        }
        assertNotNull(id);
        BikeType beforeChange = service.getBikeTypeById(id);
        assertNotNull(beforeChange);
        assertEquals(name, beforeChange.getName());
        String newname = "newname";
        beforeChange.setName(newname);
        service.changeBikeType(beforeChange);
        BikeType afterChange = service.getBikeTypeById(id);
        assertNotNull(afterChange);
        assertEquals(newname, afterChange.getName());
        assertNotSame(name, afterChange.getName());
        service.deleteBikeTypeById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.getBikeTypeById(int)'
     */
    @Test
    public void testGetBikeTypeById() {
        BikeType bikeType = new BikeType();
        String name = "getByIDTest";
        bikeType.setName(name);
        service.createBikeType(bikeType);
        Collection<BikeType> types = service.getBikeTypes();
        Long id = null;
        for(BikeType fetchType: types) {
            if(fetchType.getName().equals(name)) {
                id = fetchType.getId();
            }
        }
        assertNotNull(id);
        BikeType byId = service.getBikeTypeById(id);
        assertNotNull(byId);
        assertEquals(name, byId.getName());
        service.deleteBikeTypeById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.deleteBikeType(BikeType)'
     */
    @Test
    public void testDeleteBikeType() {
        BikeType bikeType = new BikeType();
        String name = "deleteTest";
        bikeType.setName(name);
        service.createBikeType(bikeType);
        Collection<BikeType> types = service.getBikeTypes();
        Long id = null;
        for(BikeType fetchType: types) {
            if(fetchType.getName().equals(name)) {
                id = fetchType.getId();
            }
        }
        assertNotNull(id);
        BikeType byId = service.getBikeTypeById(id);
        assertNotNull(byId);
        assertEquals(name, byId.getName());
        service.deleteBikeType(byId);
        BikeType gone = service.getBikeTypeById(id);
        assertNull(gone);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getBikeTypes()'
     */
    @Test
    public void testGetBikeTypes() {
        Collection<BikeType> bikeTypes = service.getBikeTypes();

        assertTrue("List is null", bikeTypes != null);
        assertTrue("List is empty", bikeTypes.size() > 0);
        for (BikeType bikeType : bikeTypes) {
            System.out.println(bikeType);
        }
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.createPerson(Person)'
     */
    @Test
    public void testCreatePerson() {
        Person person = new Person();
        String firstName = "createName";
        person.setFirstName(firstName);
        String lastName = "createLastName";
        person.setLastName(lastName);
        service.createPerson(person);
        Collection<Person> people = service.getPeople();
        Long id = null;
        for(Person fetchPerson: people) {
            if(fetchPerson.getFirstName().equals(firstName)) {
                id = fetchPerson.getId();
            }
        }
        assertNotNull(id);
        service.deletePersonById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.changePerson(Person)'
     */
    @Test
    public void testChangePerson() {
        Person person = new Person();
        String firstName = "changeName";
        person.setFirstName(firstName);
        String lastName = "changeLastName";
        person.setLastName(lastName);
        service.createPerson(person);
        Collection<Person> people = service.getPeople();
        Long id = null;
        for(Person fetchPerson: people) {
            if(fetchPerson.getFirstName().equals(firstName)) {
                id = fetchPerson.getId();
            }
        }
        assertNotNull(id);
        Person beforeChange = service.getPersonById(id);
        assertNotNull(beforeChange);
        assertEquals(firstName, beforeChange.getFirstName());
        String newname = "newfirstname";
        beforeChange.setFirstName(newname);
        service.changePerson(beforeChange);
        Person afterChange = service.getPersonById(id);
        assertNotNull(afterChange);
        assertEquals(newname, afterChange.getFirstName());
        service.deletePersonById(id);;
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getPersonById(int)'
     */
    @Test
    public void testGetPersonById() {
        Person person = new Person();
        String firstName = "byIdName";
        person.setFirstName(firstName);
        String lastName = "byIdLastName";
        person.setLastName(lastName);
        service.createPerson(person);
        Collection<Person> people = service.getPeople();
        Long id = null;
        for(Person fetchPerson: people) {
            if(fetchPerson.getFirstName().equals(firstName)) {
                id = fetchPerson.getId();
            }
        }
        assertNotNull(id);
        Person fetchPerson = service.getPersonById(id);
        assertNotNull(fetchPerson);
        assertEquals(firstName, fetchPerson.getFirstName());
        service.deletePersonById(id);
    }

    /**
     * Test method for
     * 'com.nob.bg.service.BikeGearsService.deletePerson(Person)'
     */
    @Test
    public void testDeletePerson() {
        Person person = new Person();
        String firstName = "deleteName";
        person.setFirstName(firstName);
        String lastName = "deleteLastName";
        person.setLastName(lastName);
        service.createPerson(person);
        Collection<Person> people = service.getPeople();
        Long id = null;
        for(Person fetchPerson: people) {
            if(fetchPerson.getFirstName().equals(firstName)) {
                id = fetchPerson.getId();
            }
        }
        assertNotNull(id);
        Person fetchPerson = service.getPersonById(id);
        assertNotNull(fetchPerson);
        assertEquals(firstName, fetchPerson.getFirstName());
        service.deletePerson(fetchPerson);
        Person gone = service.getPersonById(id);
        assertNull(gone);
    }

    /**
     * Test method for 'com.nob.bg.service.BikeGearsService.getPeople()'
     */
    @Test
    public void testGetPeople() {
        Collection<Person> people = service.getPeople();

        assertTrue("List is null", people != null);
        assertTrue("List is empty", people.size() > 0);
        for (Person person : people) {
            System.out.println(person);
        }
    }

    @Test
    public void testGetPersonForBikeRider() {
        BikeRider rider = new BikeRider();
        rider.setUserName("testForPerson");
        rider.setSince(new Date());
    }

    @Test
    public void testGetDistToDateForBikeRider() {
        Collection<DistToDate> stats = service.getDistToDateForPersonById(21L);
        assertTrue("List is null", stats != null);
        assertTrue("List is empty", stats.size() > 0);

        for (DistToDate distToDate : stats) {
            System.out.println(distToDate);
        }
    }

    @Test
    public void testGetMonthlyStatsForBikeRider() {
        Collection<MonthlyStats> stats = service
                .getMonthlyStatsForPersonById(21L);
        assertTrue("List is null", stats != null);
        assertTrue("List is empty", stats.size() > 0);

        for (MonthlyStats monthlyStats : stats) {
            System.out.println(monthlyStats);
        }
    }

    @Test
    public void testGetMonthComparisonForBikeRider() {
        BikeRider rider = new BikeRider();
        String userName = "monthcompare";
        rider.setUserName(userName);
        service.createBikeRider(rider);
        BikeRide ride = new BikeRide();
        ride.setBikeRider(rider);
        ride.setDate(new Date());
        ride.setDistanceKm(10.5f);
        ride.setRideTimeSeconds(1200);
        String journal = "monthcompare ride";
        ride.setJournal(journal);
        service.createBikeRide(ride);
        
        Collection<MonthlyStats> stats = service
                .getMonthComparisonForPersonById(rider.getId());
        assertTrue("List is null", stats != null);
        assertTrue("List is empty", stats.size() > 0);
        service.deleteBikeRide(ride);
        service.deleteBikeRider(rider);

        for (MonthlyStats monthlyStats : stats) {
            System.out.println(monthlyStats);
        }
    }
}
