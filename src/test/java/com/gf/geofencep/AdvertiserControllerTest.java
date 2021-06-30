package com.gf.geofencep;

import com.gf.geofencep.controller.GeofenceController;
import com.gf.geofencep.models.Advertiser;
import com.gf.geofencep.repositories.AdvertiserRepository;
import com.gf.geofencep.repositories.GeofenceRepository;
import com.gf.geofencep.services.GeoFenceServiceImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GeofenceController.class)
@AutoConfigureMockMvc
public class AdvertiserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeoFenceServiceImplementation service;

    @Mock
    private  GeoFenceServiceImplementation mockService;

    @MockBean
    GeofenceRepository geofenceRepository;

    @MockBean
    AdvertiserRepository advertiserRepository;

    @Test
    public void listAdvertisersTest()
            throws Exception {

        List<Advertiser> advertisers = new ArrayList();
        Advertiser advertiser = new Advertiser();
        advertiser.setLatitude(2.33333);
        advertiser.setLongitude(4.333333);
        advertiser.setShopUrl("https://github.com/urimAh/GeofenceR/tree/master");
        advertiser.setAdvertiser("AdvetiserTest");
        advertisers.add(advertiser);
        Mockito.when(advertiserRepository.findAdvertiserLists(ArgumentMatchers.any(String.class))).thenReturn(advertisers);
        mockMvc.perform(get("http://localhost:8080/adv/advertiserList")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].advertiser", is(advertiser.getAdvertiser())));
    }
}
