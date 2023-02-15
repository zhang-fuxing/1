package com.zfx.util.encrypt;

import java.util.Base64;

/**
 * @author zhangfx
 * @date 2023/2/14
 */
public class Main {
	public static void main(String[] args) throws Exception {
//		System.out.println(Base64.encode("kingshine"));
//		System.out.println(Base64.decodeStr("a2luZ3NoaW5l"));
		
		String encode = Base64.getEncoder().encodeToString("ksspasswjs".getBytes());
		System.out.println(encode);
		byte[] decode = Base64.getDecoder().decode(encode);
		System.out.println(new String(decode));
	}
}
