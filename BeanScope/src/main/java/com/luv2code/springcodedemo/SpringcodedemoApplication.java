package com.luv2code.springcodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*The component scans automatically in springcodedemo package.If there is any package out of this,
then we have to explicitily mention it like below.
@SpringBootApplication(ScanBasePackages={"com.luv2code.springcodedemo","com.luv2code.utils"})
*/
@SpringBootApplication
/*
 * @SpringBootApplication annotation enables autoconfiguration,scanning and other
 * configurations.
 * Its Combined of @EnableAutoConfiguration,@ComponentScan,@Configuration Annotations.
 * @EnableAutoConfiguration - Enables Spring Boot auto-configuration Support
 * @ComponentScan - Enables Scanning of components in the current package and in sub-packages
 * @Configuration - Able to register extra beans with @Bean or import other configuration classes
 */

public class SpringcodedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcodedemoApplication.class, args);
	}

}
