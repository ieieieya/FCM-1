package com.example.fcm.service;

import java.util.ArrayList;

import java.util.concurrent.CompletableFuture;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PushChuckJokeService {


	private static final String FIREBASE_SERVER_KEY = "AAAAqyKaFCc:APA91bHoESepjUtG710En-lDCbQ0m6E4oVAa44z9bSOEaBkd-SpOUUzYK0IlEzGG6jwkphUgwx3JYGneUukQoqMY7Q-vsTMsXjX69znIBfJCGZ0b2VCILoFxZMhTNfNCLYmbrbcHgw3m";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	
	@Async
	public CompletableFuture<String> send(HttpEntity<String> entity) {
 
		RestTemplate restTemplate = new RestTemplate();
 
		/**
		https://fcm.googleapis.com/fcm/send
		Content-Type:application/json
		Authorization:key=FIREBASE_SERVER_KEY*/
 
		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);
 
		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
       // System.out.println("firebaseResponse : "+firebaseResponse);
		return CompletableFuture.completedFuture(firebaseResponse);
	}
}
