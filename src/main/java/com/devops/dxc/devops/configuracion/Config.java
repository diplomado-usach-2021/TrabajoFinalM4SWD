package com.devops.dxc.devops.configuracion;



import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Config {
  
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {	
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(new FormHttpMessageConverter());        
		messageConverters.add(new StringHttpMessageConverter());   
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		messageConverters.add(new ByteArrayHttpMessageConverter());	
		List<ClientHttpRequestInterceptor> listClientRequestInterceptor = new ArrayList<ClientHttpRequestInterceptor>();
		return builder.messageConverters(messageConverters).interceptors(listClientRequestInterceptor).build();
	}
   
}