package com.gf.geofencep.repositories;
import com.gf.geofencep.models.GeoCoordinates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GeofenceRepository extends CrudRepository<GeoCoordinates, Long> {
}
