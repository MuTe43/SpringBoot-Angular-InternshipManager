package com.example.Gestst.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Gestst.dto.EncadreurDto;
import com.example.Gestst.dto.StagiaireDto;
import com.example.Gestst.model.Encadreur;
import com.example.Gestst.model.Stagiaire;
import com.example.Gestst.service.EncadreurService;
import com.example.Gestst.service.StagiaireService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Stagiaire")
public class StagiaireController {
    @Autowired
    private StagiaireService stagiaireService;

    @Autowired
    private EncadreurService encadreurService;

    @Autowired
    private StagiaireDto stagiaireDto;
    @Autowired
    private EncadreurDto encadreurDto;

    @GetMapping
    public List<StagiaireDto> getAllStagiaires() {
        return stagiaireService.getAllStagiaires().stream()
            .map(stagiaireDto::convertToDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StagiaireDto getStagiaireById(@PathVariable Long id) {
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        return stagiaireDto.convertToDto(stagiaire);
    }

    @PostMapping
    public StagiaireDto createStagiaire(@RequestBody StagiaireDto stagiaireDto) {
        Encadreur encadreur = encadreurService.getEncadreurById(stagiaireDto.getEncadreurId());
        Stagiaire stagiaire = stagiaireDto.convertToEntity(stagiaireDto, encadreur);
        Stagiaire savedStagiaire = stagiaireService.saveStagiaire(stagiaire);
        return stagiaireDto.convertToDto(savedStagiaire);
    }

    @DeleteMapping("/{id}")
    public void deleteStagiaire(@PathVariable Long id) {
        stagiaireService.deleteStagiaire(id);
    }
}
