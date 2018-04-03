package edu.western.cs.outdoornerd.models;

import com.google.android.gms.maps.model.LatLng;

import java.net.URI;

/**
 * Created by Benjamin on 4/2/2018.
 */

public class placeInfo {

    private String name;
    private String address;
    private String phoneNumber;
    private String id;
    private URI websitesUri;
    private LatLng latlng;
    private float rating;
    private String attributions;

    public placeInfo(String name, String address, String phoneNumber, String id, URI websitesUri,
                     LatLng latlng, float rating, String attributions) {

        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.websitesUri = websitesUri;
        this.latlng = latlng;
        this.rating = rating;
        this.attributions = attributions;
    }

    public placeInfo() {

    }
        public void setName (String name){
            this.name = name;
        }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URI getWebsitesUri() {
        return websitesUri;
    }

    public void setWebsitesUri(URI websitesUri) {
        this.websitesUri = websitesUri;
    }

    public LatLng getLatlng() {
        return latlng;
    }

    public void setLatlng(LatLng latlng) {
        this.latlng = latlng;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getAttributions() {
        return attributions;
    }

    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }

    @Override
    public String toString() {
        return "placeInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id='" + id + '\'' +
                ", websitesUri=" + websitesUri +
                ", latlng=" + latlng +
                ", rating=" + rating +
                ", attributions='" + attributions + '\'' +
                '}';
    }
}

