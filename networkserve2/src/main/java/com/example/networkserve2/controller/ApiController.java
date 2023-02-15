package com.example.networkserve2.controller;

import com.example.networkserve2.Params;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangfx
 * @date 2023/2/13
 */
@RestController
public class ApiController {
	
	@PostMapping("/oauth/token")
	public String getToken(@RequestBody Params params, HttpServletRequest request, HttpServletResponse response) {
		String code = params.getCode();
		String appCode = params.getAppCode();
		String secret = params.getSecret();
		return null;
	}
	
	@PostMapping("/oauth/userinfo")
	public String userInfo(@RequestBody Params params,HttpServletRequest request, HttpServletResponse response) {
		String code = params.getCode();
		String appCode = params.getAppCode();
		String secret = params.getSecret();
		return null;
	}
	
	@PostMapping("/user/getUserByCode")
	public String getUser(@RequestBody Params params,HttpServletRequest request, HttpServletResponse response) {
		String code = params.getCode();
		String appCode = params.getAppCode();
		String secret = params.getSecret();
		return null;
	}
	
	@GetMapping("/file")
	public String test12(@RequestParam(value = "file", required = false) String file) {
		return file;
	}
}
