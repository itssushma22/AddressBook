package com.restapi.addressbook.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ComponentScan
public class AppConfig  {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		
		PropertySourcesPlaceholderConfigurer  pconfig = new PropertySourcesPlaceholderConfigurer();
		pconfig.setIgnoreUnresolvablePlaceholders(true);
		return pconfig;
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
