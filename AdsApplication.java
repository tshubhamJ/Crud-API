package com.auth0.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.auth0.ads")
class AdsApplication
{
	public static void main(String[] args)
	 {
		SpringApplication.run(AdsApplication.class, args);
	 }
}
