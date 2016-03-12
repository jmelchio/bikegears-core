/*
 * BikeType.java
 *
 * Created on July 23, 2006, 11:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.model;

import java.io.Serializable;

/**
 *
 * @author jorismelchior
 */
public class BikeType implements Serializable {
    private static final long serialVersionUID = -6664436589775254232L;
    private Long id;
    private String name;
    private String description;
    
    /** Creates a new instance of BikeType */
    public BikeType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
/* That's All Folks!! */