package com.example.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String email;

    public User(String string, String string2, String string3, Location location, String string4) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
