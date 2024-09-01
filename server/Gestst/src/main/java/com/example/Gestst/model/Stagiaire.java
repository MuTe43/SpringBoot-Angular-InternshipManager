package com.example.Gestst.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class Stagiaire implements Serializable {
	

	@Id
	@GeneratedValue
	private Long id;
	
	private Long niveauEtude;
	private String email;
	private String specialite;
	private String nomUniversite;
	private String nom;
	private String prenom;
	private String dateDebut;
	private String dateFin;
	
	@ManyToOne
	@JoinColumn(name = "encadreurId")
    private Encadreur encadreur;
}
