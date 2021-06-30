package com.gf.geofencep;

import com.gf.geofencep.controller.AdvertiserController;
import com.gf.geofencep.models.Advertiser;
import com.gf.geofencep.repositories.AdvertiserRepository;
import com.gf.geofencep.repositories.GeofenceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class GeofencepApplicationTests {

	@Test
	void contextLoads() {
	}

		@Mock
		private AdvertiserRepository advertiserRepository;
	    @Mock
		private GeofenceRepository geofenceRepository;
		@InjectMocks
		private AdvertiserController advertiserController;
		@Test
		public void testSaveAdvertiserNoGeofenceFound() throws IOException {
			Advertiser advertiser = new Advertiser();
			advertiser.setLatitude(2.33333);
			advertiser.setLongitude(4.333333);
			advertiser.setShopUrl("https://github.com/urimAh/GeofenceR/tree/master");
			advertiser.setAdvertiser("AdvetiserTest");
			List<Integer> geoId= new ArrayList<>();
			//geoId.set(0,1);
			when(advertiserRepository.save(ArgumentMatchers.any(Advertiser.class))).thenReturn(advertiser);
			when(geofenceRepository.getrespectiveGeofenceForRequiredAdvertiser(ArgumentMatchers.any(Double.class),ArgumentMatchers.any(Double.class))).thenReturn(java.util.Optional.of(geoId));
			Advertiser created = advertiserController.saveAdvertiser(advertiser);
			assertEquals(created.getAdvertiser(),advertiser.getAdvertiser());
			verify(advertiserRepository).save(advertiser);

		}

	@Test
	public void testSaveAdvertiserGeofenceFound() throws IOException {
		Advertiser advertiser = new Advertiser();
		advertiser.setLatitude(2.33333);
		advertiser.setLongitude(4.333333);
		advertiser.setShopUrl("https://github.com/urimAh/GeofenceR/tree/master");
		advertiser.setAdvertiser("AdvetiserTest");
		List<Integer> geoId = new ArrayList<Integer>();
		geoId.add(0, 1);
		when(advertiserRepository.save(ArgumentMatchers.any(Advertiser.class))).thenReturn(advertiser);
		when(geofenceRepository.getDistanceFromCenter(ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Double.class))).thenReturn("2.333");
		when(geofenceRepository.getrespectiveGeofenceForRequiredAdvertiser(ArgumentMatchers.any(Double.class), ArgumentMatchers.any(Double.class))).thenReturn(java.util.Optional.of(geoId));
		Advertiser created = advertiserController.saveAdvertiser(advertiser);
		assertEquals(created.getAdvertiser(), advertiser.getAdvertiser());
		verify(advertiserRepository).save(advertiser);
	}
		@Test
		public void testAllAdvertisers() {
			List<Advertiser> advertisers = new ArrayList();
			advertisers.add(new Advertiser());
			given(advertiserRepository.findAdvertiserLists(ArgumentMatchers.any(String.class))).willReturn(advertisers);
			List<Advertiser> expected = advertiserController.getAdvertisers("2");
			assertEquals(expected, advertisers);
			verify(advertiserRepository).findAdvertiserLists(ArgumentMatchers.any(String.class));
		}



	}


