package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.demo.netflix.NetflixController;

@Configuration
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
		register(NetflixController.class);
	}
}
