package com.ohdoking.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.ohdoking.api.gateway.filter.AddResponseHeaderFilter;
import com.ohdoking.api.gateway.filter.RoutingFilter;
import com.ohdoking.api.gateway.filter.SimpleFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }
  
  @Bean
  public SimpleFilter simpleFilter() {
    return new SimpleFilter();
  }
  
  @Bean
  public RoutingFilter routingFilter() {
	  return new RoutingFilter();
  }
  
  @Bean
  public AddResponseHeaderFilter addResponseHeaderFilter() {
	  return new AddResponseHeaderFilter();
  }
}
