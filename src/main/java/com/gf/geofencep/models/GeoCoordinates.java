package com.gf.geofencep.models;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "geofence")
public class GeoCoordinates {

    @Id
    @GeneratedValue
    private long id;
    @NotNull()
    @Digits(integer=3, fraction=7)
    @Min(-180)
    @Max(180)
    private Double longitude;
    @NotNull()
    @Digits(integer=2, fraction=7)
    @Min(-90)
    @Max(90)
    private Double latitude;
    @Column(name="timestamp", nullable = false, updatable = false, insertable = false)
    @CreationTimestamp
    private Date date;
    @NotNull
    @Digits(integer=1000, fraction=7)
    private Double radius;
    private String city;
    private String googleAddress;


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public GeoCoordinates() {

    }
    public GeoCoordinates(Double longitude, Double lat, Date date) {
        this.longitude = longitude;
        this.latitude = lat;
        this.date = date;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLat() {
        return latitude;
    }

    public void setLat(Double lat) {
        this.latitude = lat;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGoogleAddress() {
        return googleAddress;
    }

    public void setGoogleAddress(String googleAddress) {
        this.googleAddress = googleAddress;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
