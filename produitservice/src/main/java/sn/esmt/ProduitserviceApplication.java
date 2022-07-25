package sn.esmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // à ajouter dans tout microservice
public class ProduitserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitserviceApplication.class, args);
	}

}
