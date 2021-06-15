package com.gf.geofencep.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "advertiser")
public class Advertiser {
        @Id
        @GeneratedValue
        private long id;
        private String advertiser;
        private double longitude;
        private double latitude;
        private String shopUrl;
        private String awayFromGeoCenter;
        private int urlCode;


        public int getUrlCode() {
                return urlCode;
        }

        public void setUrlCode(int urlCode) {
                this.urlCode = urlCode;
        }



        public String getAwayFromGeoCenter() {
                return awayFromGeoCenter;
        }

        public void setAwayFromGeoCenter(String awayFromGeoCenter) {
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
