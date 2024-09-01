package com.example.Gestst.service;

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
public class StagiaireService {
	
	@Autowired
	private StagiaireRepository stagiaireRepo;
	
	public List<Stagiaire> getAllStagiaires(){
		return stagiaireRepo.findAll();
		}
	
	public Stagiaire getStagiaireById(Long id) {
		return stagiaireRepo.findById(id).orElse(null);
	}
	
	public Stagiaire saveStagiaire(Stagiaire stagiaire) {
		return stagiaireRepo.save(stagiaire);
	}
	
	public void deleteStagiaire(Long id) {
		stagiaireRepo.deleteById(id);
	}
}
