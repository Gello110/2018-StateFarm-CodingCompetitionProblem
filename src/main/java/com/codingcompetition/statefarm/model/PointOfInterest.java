package com.codingcompetition.statefarm.model;

import java.util.HashMap;
import java.util.Map;

public class PointOfInterest {
    private String latitude, longitude;
    private Map<Object, String> descriptors;

    public Map<Object,String> getDescriptors() {
     return descriptors;
    } //getDescriptors

    public void setDescriptors(HashMap<Object, String> descriptors) {
        this.descriptors = descriptors;
    } //setDescriptors

    public String getLatitude() {
        return latitude;
    } //getLatitude

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    } //setLat

    public String getLongitude() {
        return longitude;
    } //getLongitude

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    } //setLon
} //PointOfInterest
