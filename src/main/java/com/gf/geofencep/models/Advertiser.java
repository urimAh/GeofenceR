package com.gf.geofencep.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@Entity
@Table(name = "advertiser")
public class Advertiser {
        @Id
        @GeneratedValue
        private long id;
        @Column(name="geofence_id")
        private int geofenceId;
        private String advertiser;
        @NotNull()
        @Digits(integer=3, fraction=7)
        @Min(-180)
        @Max(180)
        private double longitude;
        @NotNull()
        @Digits(integer=2, fraction=7)
        @Min(-90)
        @Max(90)
        private double latitude;
        private String shopUrl;
        private Double awayFromGeoCenter;
        private int urlCode;//default 0

        public int getUrlCode() {
                return urlCode;
        }
        public int getGeofenceId() {
                return geofenceId;
        }

        public void setGeofenceId(int geofenceId) {
                this.geofenceId = geofenceId;
        }

        public void setUrlCode(int urlCode) {
                this.urlCode = urlCode;
        }

        public Double getAwayFromGeoCenter() {
                return awayFromGeoCenter;
        }

        public void setAwayFromGeoCenter(Double awayFromGeoCenter) {
                this.awayFromGeoCenter = awayFromGeoCenter;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getAdvertiser() {
                return advertiser;
        }

        public void setAdvertiser(String advertiser) {
                this.advertiser = advertiser;
        }

        public double getLongitude() {
                return longitude;
        }

        public void setLongitude(double longitude) {
                this.longitude = longitude;
        }

        public double getLatitude() {
                return latitude;
        }

        public void setLatitude(double latitude) {
                this.latitude = latitude;
        }

        public String getShopUrl() {
                return shopUrl;
        }

        public void setShopUrl(String shopUrl) {
                this.shopUrl = shopUrl;
        }
}
