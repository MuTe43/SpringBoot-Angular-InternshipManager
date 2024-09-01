package com.example.Gestst.dto;

import com.example.Gestst.model.Encadreur;
import com.example.Gestst.model.Stagiaire;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class EncadreurDto {

	
	private Long id;
	
	private String email;
	private String Department;
	private String nom;
	private String prenom;
	private List<Long> stagiaireId;
	
	public EncadreurDto convertToDto(Encadreur encadreur) {
        EncadreurDto dto = new EncadreurDto();
        dto.setId(encadreur.getId());
        dto.setEmail(encadreur.getEmail());
        dto.setDepartment(encadreur.getDepartment());
        dto.setNom(encadreur.getNom());
        dto.setPrenom(encadreur.getPrenom());
        dto.setStagiaireId(encadreur.getStagiaire() != null ? encadreur.getStagiaire().stream()
                .map(Stagiaire::getId)
                .collect(Collectors.toList()) : null);
        return dto;
    }

    public Encadreur convertToEntity(EncadreurDto dto) {
        Encadreur encadreur = new Encadreur();
        encadreur.setId(dto.getId());
        encadreur.setEmail(dto.getEmail());
        encadreur.setDepartment(dto.getDepartment());
        encadreur.setNom(dto.getNom());
        encadreur.setPrenom(dto.getPrenom());
        return encadreur;
    }
}
