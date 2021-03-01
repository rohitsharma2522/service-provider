package com.nagarro.serviceProvider.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.serviceProvider.entities.ServiceProviderEntity;
import com.nagarro.serviceProvider.services.ServiceProvider;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping(value = "/serviceprovider")
public class ServiceProviderController {
	@Autowired
	private EurekaClient eurekaClient;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;
	
	ServiceProvider serviceProvider;
	
	@GetMapping(value = "/getallserviceprovider")
	public List<ServiceProviderEntity> getAllServices() {
		return serviceProvider.getAllServiceProvider();
	}
	
}
