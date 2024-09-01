package com.example.Gestst.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestst.dto.EncadreurDto;
import com.example.Gestst.dto.StagiaireDto;
import com.example.Gestst.model.Encadreur;
import com.example.Gestst.service.EncadreurService;
import com.example.Gestst.service.StagiaireService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/Encadreur")
public class EncadreurController {

	@Autowired
    private StagiaireService stagiaireService;

    @Autowired
    private EncadreurService encadreurService;

    @Autowired
    private StagiaireDto stagiaireDto;
    @Autowired
    private EncadreurDto encadreurDto;
    
    
    @GetMapping
    public List<EncadreurDto> getAllEncadreur(){
    	return encadreurService.getAllEncadreurs().stream()
    			.map(encadreurDto::convertToDto)
    			.collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public EncadreurDto getEncadreurById(@PathVariable Long id) {
        Encadreur encadreur = encadreurService.getEncadreurById(id);
        return encadreurDto.convertToDto(encadreur);
    }

    @PostMapping
    public EncadreurDto createEncadreur(@RequestBody EncadreurDto encadreurDto) {
        Encadreur encadreur = encadreurDto.convertToEntity(encadreurDto);
        Encadreur savedEncadreur = encadreurService.saveEncadreur(encadreur);
        return encadreurDto.convertToDto(savedEncadreur);
    }

    @DeleteMapping("/{id}")
    public void deleteEncadreur(@PathVariable Long id) {
        encadreurService.deleteEncadreur(id);
    }
}
