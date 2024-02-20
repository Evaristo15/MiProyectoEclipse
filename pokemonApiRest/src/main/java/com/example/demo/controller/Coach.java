package com.example.demo.controller;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coach {

	private long id;
	private String name;
	private String town;
	private boolean cap;
	
}