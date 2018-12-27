package com.example.fcm.service;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FcmClientService {

//	public FcmClientService() {
//		
//		   try {
//			   
//			FileInputStream serviceAccount = new FileInputStream("/Users/sunilv/Downloads/fcm/src/main/resources/firebase.json");
//			FirebaseOptions options = new FirebaseOptions.Builder()
//					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//					.setDatabaseUrl("https://test-fcm-1d6f4.firebaseio.com").build();
//
//				FirebaseApp.initializeApp(options);
//	
//	    }catch(IOException e){
//		e.printStackTrace();
//	    }
//	}

}
