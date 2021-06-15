package com.gf.geofencep.services;
import com.gf.geofencep.models.GeoCoordinates;
import com.gf.geofencep.repositories.GeofenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeoFenceServiceImplementation  {
    @Autowired
    GeofenceRepository geofenceRepository;
    public void saveOrUpdate(GeoCoordinates geoCoordinates)
    {
        geofenceRepository.save(geoCoordinates);
    }
}
