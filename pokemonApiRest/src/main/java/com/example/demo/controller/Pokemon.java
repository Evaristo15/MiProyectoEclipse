package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

	private long id;
	private String name;
	private Type type;
	private Type secondType;
	private int level;
	private int health;
	private int healthMax;
	private Coach coach;
	
}
