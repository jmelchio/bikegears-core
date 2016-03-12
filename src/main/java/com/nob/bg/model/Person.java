/*
 * Person.java
 *
 * Created on July 23, 2006, 11:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jorismelchior
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -8482360332537603704L;
    private Long id;
    private String firstName;
    private String lastName;
    private String initials;
    private Date birthdate;
    
    /** Creates a new instance of Person */
    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    @Override
    public String toString() {
        return this.id + "; " + this.firstName + "; " + this.lastName + "; " + this.birthdate;
    }
}
/* That's All Folks!! */