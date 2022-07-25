package sn.esmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class PromotionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionserviceApplication.class, args);
	}

}
