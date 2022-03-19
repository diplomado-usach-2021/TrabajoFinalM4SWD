package com.devops.dxc.devops.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;



public class SingleObjectFactory {
	
	private static RestTemplate restTemplate;	
	private static ObjectMapper mapper = new ObjectMapper();
		
	public static RestTemplate getRestTemplateInstance() {
		
		if (restTemplate == null) {	
		    
			restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory()));			
			
			
		    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	        messageConverters.add(new FormHttpMessageConverter());        
	        messageConverters.add(new StringHttpMessageConverter());   
	        messageConverters.add(new MappingJackson2HttpMessageConverter());
	        messageConverters.add(new ByteArrayHttpMessageConverter());	        
             
	        
		}		
		
		return restTemplate;
		
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}
	
	
   private static  ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(2500000);
        factory.setConnectTimeout(2500000);
        return factory;
    }
	

}
