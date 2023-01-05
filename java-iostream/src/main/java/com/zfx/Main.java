package com.zfx;

import com.zfx.config.MyAnno;

import java.lang.annotation.Annotation;
@MyAnno
public class Main {
    

    public static void main(String[] args) {
        Package pkg = Main.class.getPackage();
        System.out.println(pkg.getName());
        Annotation[] annotations = pkg.getAnnotations();
        System.out.println(annotations.length);
    }
    
    
}
