package com.gf.geofencep.controller;
import com.gf.geofencep.models.Advertiser;
import com.gf.geofencep.repositories.AdvertiserRepository;
import com.gf.geofencep.repositories.GeofenceRepository;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adv")
public class AdvertiserController {
    @Autowired
    AdvertiserRepository advertiserRepository;

    @Autowired
    GeofenceRepository geofenceRepository;
    final UrlValidator urlValidator = new UrlValidator();


    @PostMapping("/newAdvertiser")
    public Advertiser saveAdvertiser(@RequestBody Advertiser advertiser) throws IOException {
        int code=getUrlResponseCode(advertiser.getShopUrl());
        advertiser.setUrlCode(code);
        Optional<List<Integer>> geofenceId=geofenceRepository.getrespectiveGeofenceForRequiredAdvertiser(advertiser.getLatitude(),advertiser.getLongitude());
        if(geofenceId.isPresent()&&geofenceId.get().size()>0){
            advertiser.setGeofenceId(geofenceId.get().get(0));
            String distanceFromCenter=geofenceRepository.getDistanceFromCenter(geofenceId.get().get(0),advertiser.getLatitude(),advertiser.getLongitude());
            if(distanceFromCenter!=null)advertiser.setAwayFromGeoCenter(Double.valueOf(distanceFromCenter));
        }
        advertiserRepository.save(advertiser);
        return advertiser;
    }


    @GetMapping("/advertiserList")
    public List<Advertiser> getAdvertisers(String id) {
        List<Advertiser> advertiserList=advertiserRepository.findAdvertiserLists(id);
        return advertiserList;
    }


    private int getUrlResponseCode(String urltest) throws IOException {
        int responseCode = 0;
        if(urlValidator.isValid(urltest)) {
            URL url = new URL(urltest);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            responseCode=con.getResponseCode();
        }
        return responseCode;
    }
}