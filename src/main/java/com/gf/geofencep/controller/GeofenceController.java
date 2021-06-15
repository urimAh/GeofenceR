package com.gf.geofencep.controller;
import com.gf.geofencep.models.GeoCoordinates;
import com.gf.geofencep.repositories.GeofenceRepository;
import com.gf.geofencep.services.GeoFenceServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GeofenceController {
    @Autowired
    private GeofenceRepository geofenceRep;

    @Autowired
    GeoFenceServiceImplementation geoFenceServiceImplementation;

    @GetMapping("/geofences")
    public List<GeoCoordinates> getLocations() {
        return (List<GeoCoordinates>) geofenceRep.findAll();
    }

    @DeleteMapping("/geofences/{id}")
    private void deleteLocation(@PathVariable("id") int id)
    {
        geofenceRep.deleteById((long) id);
    }

    @PostMapping("/newGeofence")
    private String saveLocation(@RequestBody GeoCoordinates geoCoordinates)
    {
        geoFenceServiceImplementation.saveOrUpdate(geoCoordinates);
        return geoCoordinates.getLat().toString().concat(" : "+geoCoordinates.getLongitude());
    }

    @PutMapping("/updateGeofence")
    private GeoCoordinates update(@RequestBody GeoCoordinates geoCoordinates)
    {
        geoFenceServiceImplementation.saveOrUpdate(geoCoordinates);
        return geoCoordinates;
    }
}