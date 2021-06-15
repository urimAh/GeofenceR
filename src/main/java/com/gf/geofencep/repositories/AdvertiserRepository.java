package com.gf.geofencep.repositories;
import com.gf.geofencep.models.Advertiser;
import com.gf.geofencep.models.GeoCoordinates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertiserRepository extends CrudRepository<Advertiser, Long> {
    //make points dynamic ?
    @Query(value = "SELECT *, point(19.4414, 41.3231) <@>  (point(longitude, latitude)::point) as distance FROM geofence g where distance<20 ORDER BY distance;", nativeQuery = true)
    List<Advertiser> findAdvertiserLists(Double lat, Double longitude);

}
