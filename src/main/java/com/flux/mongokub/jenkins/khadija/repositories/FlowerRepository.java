package com.flux.mongokub.jenkins.khadija.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.flux.mongokub.jenkins.khadija.entities.Flower;

public interface FlowerRepository extends ReactiveMongoRepository<Flower, String>  {

}
