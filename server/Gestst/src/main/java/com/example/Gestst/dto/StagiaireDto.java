package com.example.Gestst.dto;

import com.example.Gestst.model.Encadreur;
import com.example.Gestst.model.Stagiaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StagiaireDto {
	private Long id;
	
	private Long niveauEtude;
	private String email;
	private String specialite;
	private String nomUniversite;
	private String nom;
	private String prenom;
	private String dateDebut;
	private String dateFin;
	private Long encadreurId;
	
	
	public StagiaireDto convertToDto(Stagiaire stagiaire) {
        StagiaireDto dto = new StagiaireDto();
        dto.setId(stagiaire.getId());
        dto.setNom(stagiaire.getNom());
        dto.setPrenom(stagiaire.getPrenom());
        dto.setEmail(stagiaire.getEmail());
        dto.setNomUniversite(stagiaire.getNomUniversite());
        dto.setSpecialite(stagiaire.getSpecialite());
        if (stagiaire.getEncadreur() != null) {
            dto.setEncadreurId(stagiaire.getEncadreur().getId());
        } else {
            dto.setEncadreurId(null); // Or handle this case appropriately
        }
        dto.setDateDebut(stagiaire.getDateDebut());
        dto.setDateFin(stagiaire.getDateFin());
        return dto;
    }

    public Stagiaire convertToEntity(StagiaireDto dto, Encadreur encadreur) {
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(dto.getId());
        stagiaire.setNom(dto.getNom());
        stagiaire.setPrenom(dto.getPrenom());
        stagiaire.setEmail(dto.getEmail());
        stagiaire.setNomUniversite(dto.getNomUniversite());
        stagiaire.setSpecialite(dto.getSpecialite());
        stagiaire.setEncadreur(encadreur);
        stagiaire.setDateDebut(dto.getDateDebut());
        stagiaire.setDateFin(dto.getDateFin());
        return stagiaire;
    }
}
