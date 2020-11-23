package com.flux.mongokub.jenkins.khadija.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flux.mongokub.jenkins.khadija.entities.Flower;
import com.flux.mongokub.jenkins.khadija.repositories.FlowerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

	@Autowired
	private FlowerRepository frepo;
	
	@GetMapping
	public Flux<Flower> getFlowers() {
		return frepo.findAll();
		
	}
	
	@PostMapping
	public Mono<Flower>  save(@RequestBody Flower flower) {
		return frepo.save(flower);
	}
	
	@GetMapping("/{id}")
	public Mono<Flower>  getFlower(@PathVariable String id) {
		return frepo.findById(id);
	}
}
