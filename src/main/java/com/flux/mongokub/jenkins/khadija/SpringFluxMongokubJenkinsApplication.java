package com.flux.mongokub.jenkins.khadija;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.flux.mongokub.jenkins.khadija.entities.Flower;
import com.flux.mongokub.jenkins.khadija.repositories.FlowerRepository;


import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringFluxMongokubJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFluxMongokubJenkinsApplication.class, args);
	}
    
	
	@Bean
	ApplicationRunner init(FlowerRepository FlowerRepo) {
		   Object[][] data = {
		            {"jasmin", "parfumée","Akaya"},
		            {"Manolia", "parfuméé",  "Sauvage"},
		            {"Tulip", "parfumée",  "Tulipa"}
		        };
		   return args ->{
			   FlowerRepo.deleteAll().thenMany(Flux.just(data).map(array->{
				 return new Flower((String)  array[0], (String)  array[1], (String)  array[2]);
			   }).flatMap(FlowerRepo::save)).thenMany(FlowerRepo.findAll())
               .subscribe(flower -> System.out.println("saving " + flower.toString()));
		   };
	}
}
