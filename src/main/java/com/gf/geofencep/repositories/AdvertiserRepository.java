package com.gf.geofencep.repositories;
import com.gf.geofencep.models.Advertiser;
import com.gf.geofencep.models.GeoCoordinates;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertiserRepository extends CrudRepository<Advertiser, Long> {
    @Query(value = "SELECT id, \"name\", latitude, longitude, url, url_code, advertiser, away_from_geo_center, shop_url, geofence_id " +
            "FROM public.advertiser where geofence_id =:", nativeQuery = true)
    List<Advertiser> findAdvertiserLists(String geofenceId);

}
