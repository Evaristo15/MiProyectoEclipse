package com.example.demo.repository;

import com.example.demo.controller.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Pokemon")
public class PokemonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name="secondType")
	@Enumerated(EnumType.STRING)
	private Type secondType;
	
	@Column(name="level")
	private int level;
	
	@Column(name="health")
	private int health;
	
	@Column(name="healthMax")
	private int healthMax;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="coach", nullable = true)
	private CoachEntity coach;
	
}
