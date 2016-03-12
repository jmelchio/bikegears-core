package com.nob.bg.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author jorismelchior
 */
public class BikeRider implements Serializable {

    private static final long serialVersionUID = 2772243630371984613L;
    private Long id;
    private String userName;
    private String password;
    private Date since;
    private Person person;
    private Set<BikeRide> bikeRides = new HashSet<BikeRide>();
    private Set<Bike> bikes = new HashSet<Bike>();

    /** Creates a new instance of BikeRider */
    public BikeRider() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringBuffer("[BikeRider - id:").append(this.id).append(
                " - userName:").append(this.userName).append("]").toString();
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<BikeRide> getBikeRides() {
        return bikeRides;
    }

    public void setBikeRides(Set<BikeRide> bikeRides) {
        this.bikeRides = bikeRides;
    }

    /**
     * @return the bikes
     */
    public Set<Bike> getBikes() {
        return bikes;
    }

    /**
     * @param bikes
     *            the bikes to set
     */
    public void setBikes(Set<Bike> bikes) {
        this.bikes = bikes;
    }
}
/* That's All Folks!! */