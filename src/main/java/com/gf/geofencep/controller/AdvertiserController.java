package com.gf.geofencep.controller;
import com.gf.geofencep.models.Advertiser;
import com.gf.geofencep.models.GeoCoordinates;
import com.gf.geofencep.repositories.AdvertiserRepository;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/adv")
public class AdvertiserController {
    @Autowired
    AdvertiserRepository advertiserRepository;
    final UrlValidator crunchifyURLValidator = new UrlValidator();



    @PostMapping("/newAdvertiser")
    private String saveLocation(@RequestBody Advertiser advertiser) throws IOException {
        int code=getUrlResponseCode(advertiser.getShopUrl());
        advertiser.setUrlCode(code);
        advertiserRepository.save(advertiser);
        return "";
    }


    @GetMapping("/advertiserList")
    public List<GeoCoordinates> getAdvertisers(Double lat, Double longitude) {
        //advertiserRepository.findAdvertiserLists(lat, longitude);
        // need to implemet all
        return null;
    }


    private int getUrlResponseCode(String urltest) throws IOException {
        int responseCode = 0;
        if(crunchifyURLValidator.isValid(urltest)) {
            URL url = new URL(urltest);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            responseCode=con.getResponseCode();
        }
        return responseCode;
    }
}