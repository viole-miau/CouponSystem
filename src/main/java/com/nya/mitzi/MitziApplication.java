package com.nya.mitzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

import static java.lang.Math.random;

@SpringBootApplication
public class MitziApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MitziApplication.class, args);
	}



}






