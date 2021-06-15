package com.gf.geofencep;

import org.apache.commons.validator.UrlValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@SpringBootApplication
public class GeofencepApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GeofencepApplication.class, args);
		System.out.println("HERE");
	}

}
