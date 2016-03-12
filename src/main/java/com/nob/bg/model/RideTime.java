/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nob.bg.model;

import java.io.Serializable;

/**
 *
 * @author jorismelchior
 */
public class RideTime implements Serializable {
   
    private static final long serialVersionUID = 804561472415847310L;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    public RideTime() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    
    public RideTime(int hours, int minutes, int seconds) {
        this.setRideTimeInSeconds(seconds);
        
        if(minutes >= 60) {
            int extraHours = minutes / 60;
            int remainingMinutes = minutes % 60;
            this.hours = this.hours + extraHours;
            this.minutes = this.minutes + remainingMinutes;
        } else {
            this.minutes = this.minutes + minutes;
        }
        
        this.hours = this.hours + hours;
    }
    
    public RideTime(Integer hours, Integer minutes, Integer seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
    
    public Integer getRideTimeInSeconds() {
        int tempHours = hours != null && hours.intValue() > 0 ? hours.intValue() : 0;
        int tempMinutes = minutes != null && minutes.intValue() > 0 ? minutes.intValue() : 0;
        int tempSeconds = seconds != null && seconds.intValue() > 0 ? seconds.intValue() : 0;
        
        return (tempHours * 3600) + (tempMinutes * 60) + tempSeconds;
    }
    
    public void setRideTimeInSeconds(Integer seconds) {
        if(seconds.intValue() >= 3600) {
            this.hours = seconds.intValue() / 3600;
            int remainder = seconds.intValue() % 3600;
            if(remainder == 0) {
                this.minutes = 0;
                this.seconds = 0;
            } else {
                this.minutes = remainder / 60;
                this.seconds = remainder % 60;
            }
        } else {
            this.hours = 0;
            this.minutes = seconds.intValue() / 60;
            this.seconds = seconds.intValue() % 60;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
