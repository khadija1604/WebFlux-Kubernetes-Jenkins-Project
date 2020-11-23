package com.flux.mongokub.jenkins.khadija.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="flower")
public class Flower {
	 @Id  
	 private String id;
     private String name;
     private String type;
     private String famille;
     
 	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
	}
	public Flower(String name, String type, String famille) {
		super();
		this.name = name;
		this.type = type;
		this.famille = famille;
	}

     
}
