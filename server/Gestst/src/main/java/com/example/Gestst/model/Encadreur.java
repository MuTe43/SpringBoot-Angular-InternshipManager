package com.example.Gestst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Encadreur implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String email;
	private String Department;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy ="encadreur")
	private List<Stagiaire> stagiaire;

}
