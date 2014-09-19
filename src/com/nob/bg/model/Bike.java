/*
 * Bike.java
 *
 * Created on July 23, 2006, 11:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.model;

import java.io.Serializable;

/**
 * Describes a bike object
 * @author jorismelchior
 */
public class Bike implements Serializable {
    private static final long serialVersionUID = 7644655397450253623L;
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private String description;
    private BikeType bikeType;
    private BikeRider bikeRider;
    
    /** Creates a new instance of Bike */
    public Bike() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public String getFullModel() {
        StringBuffer fullModelBuf = new StringBuffer("");
        if(this.brand != null) {
            fullModelBuf.append(brand).append(" ");
        }
        if(this.model != null) {
            fullModelBuf.append(model);
        }
        if(this.year != null) {
            fullModelBuf.append("(").append(year).append(")");
        }
        return fullModelBuf.toString();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return this.brand + " " + this.model;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    /**
     * @return the bikeRider
     */
    public BikeRider getBikeRider() {
        return bikeRider;
    }

    /**
     * @param bikeRider the bikeRider to set
     */
    public void setBikeRider(BikeRider bikeRider) {
        this.bikeRider = bikeRider;
    }
}
/* That's All Folks!! */