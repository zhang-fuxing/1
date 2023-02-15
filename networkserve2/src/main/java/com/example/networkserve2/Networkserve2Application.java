package com.example.networkserve2;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class Networkserve2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Networkserve2Application.class, args);
	}

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/net2")
	public Object get1() {
		Map<String,String> headers = new LinkedHashMap<>(1);
		headers.put("Content-Type","application/json");
		var getToken = HttpRequest.post("http://localhost:2331/net1/p")
				.addHeaders(headers)
				.body(JSONUtil.createObj()
						.set("appCode", "sys_100231")
						.set("secret", "sys_zfx")
						.set("code", "Dmm1IlLpuNv145AGBi")
						.toString(), "application/json")
				.execute();
		
		return null;
	}
	
	@GetMapping("/111")
	public List<Integer> get111() {
		List<Integer> list = List.of(111, 222, 333, 444, 555, 666);
		return list;
	}
}
