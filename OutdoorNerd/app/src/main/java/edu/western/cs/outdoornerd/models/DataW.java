package edu.western.cs.outdoornerd.models;

import java.io.Serializable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DataW extends RealmObject implements Serializable {




    @PrimaryKey
    private int id;

    private String stationName;
    private String triplet;
    private String dateTime;
    private String temp;
    private String windA;
    private String snowD;
    private String waterEq;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getTriplet() {
        return triplet;
    }

    public void setTriplet(String triplet) {
        this.triplet = triplet;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindA() {
        return windA;
    }

    public void setWindA(String windA) {
        this.windA = windA;
    }

    public String getSnowD() {
        return snowD;
    }

    public void setSnowD(String snowD) {
        this.snowD = snowD;
    }

    public String getWaterEq() {
        return waterEq;
    }

    public void setWaterEq(String waterEq) {
        this.waterEq = waterEq;
    }



}
