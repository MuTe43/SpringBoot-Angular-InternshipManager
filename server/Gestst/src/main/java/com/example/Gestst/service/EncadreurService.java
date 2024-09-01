package com.example.Gestst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Gestst.Repository.EncadreurRepository;
import com.example.Gestst.Repository.StagiaireRepository;
import com.example.Gestst.model.Encadreur;
import com.example.Gestst.model.Stagiaire;
import com.example.Gestst.Repository.StagiaireRepository;
import com.example.Gestst.model.Stagiaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EncadreurService {

	
	@Autowired
	private EncadreurRepository encadreurRepo;
	
	public List<Encadreur> getAllEncadreurs(){
		return encadreurRepo.findAll();
		}
	
	public Encadreur getEncadreurById(Long id) {
		return encadreurRepo.findById(id).orElse(null);
	}
	
	public Encadreur saveEncadreur(Encadreur encadreur) {
		return encadreurRepo.save(encadreur);
	}
	
	public void deleteEncadreur(Long id) {
		encadreurRepo.deleteById(id);
	}
}
