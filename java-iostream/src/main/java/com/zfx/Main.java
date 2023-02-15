package com.zfx;

import java.io.IOException;


public class Main {
    

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:9000/app/";
        url = url.substring(0, url.length()-1);
        System.out.println(url);
    }
    
    
}
