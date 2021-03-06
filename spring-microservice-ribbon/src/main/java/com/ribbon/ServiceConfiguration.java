package com.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class ServiceConfiguration {

	@Autowired
	IClientConfig ribbonClient;
	
	@Autowired
	public IPing ping(IClientConfig config) {
		return new PingUrl();
	}
	
	@Bean
	public IRule rule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}
	
}
