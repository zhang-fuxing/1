package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RefreshScope
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class S2Application {
	public static void main(String[] args) {
		SpringApplication.run(S2Application.class,args);
	}
	@Resource
	RestTemplate template;
	@Value("${config.info}")
	private String info;
	
	@GetMapping("/get")
	public String get() {
		String s = template.getForObject("http://service1/info", String.class);
		return "service1-data=" + s + " | service2-data=" + info;
	}
}
