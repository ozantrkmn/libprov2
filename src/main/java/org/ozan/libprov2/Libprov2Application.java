package org.ozan.libprov2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ozan.libprov2.Controllers.PublisherController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class Libprov2Application {

	public static void main(String[] args) {
	    
		
		SpringApplication.run(Libprov2Application.class, args);

	}

}
