package com.gf.geofencep.repositories;
import com.gf.geofencep.models.GeoCoordinates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface GeofenceRepository extends CrudRepository<GeoCoordinates, Long> {

    //geography (st_point (-77.18000, 39.01900)), 100) incomming geofence
    @Query(value = "SELECT ST_Intersects( ST_Buffer (geography (st_point (:latitude,:longitude)), :radius), g.geometry)  FROM geofence g", nativeQuery = true)
    int isGeofenceAvailable(Double latitude, Double longitude, double radius);


    @Query(value = "SELECT id FROM geofence g where  " +
            "(st_contains(geometry(g.geometry),(SELECT ST_SetSRID( ST_Point( :latitude,:longitude), 4326)\\:\\:geometry)))=true ", nativeQuery = true)
    Optional<List<Integer>> getrespectiveGeofenceForRequiredAdvertiser(Double latitude, Double longitude);


    @Query(value = "SELECT ST_Distance((select geometry from geofence where id=:id),(SELECT ST_SetSRID( ST_Point( :latitude,:longitude), 4326)\\:\\:geometry))", nativeQuery = true)
    String getDistanceFromCenter(int id,Double latitude, Double longitude);
}
