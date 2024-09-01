import { Component, OnInit } from '@angular/core';
import { Stagiaire } from './stagiaire.model';
import { StagiaireService } from './stagiaire.service';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Router, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-stagiaire',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    CommonModule,
  ],
  templateUrl: './stagiaire.component.html',
  styleUrl: './stagiaire.component.css'
})
export class StagiaireComponent implements OnInit{

  stagiaires: Stagiaire[] = [];
  newStagiaire: Stagiaire = {
    niveauEtude: '',
    nom: '',
    prenom: '',
    email: '',
    nomUniversite: '',
    specialite: '',
    encadreurId: 0,
    dateDebut: '',
    dateFin: ''
  };

  constructor(private stagiaireService: StagiaireService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadStagiaires();
  }

  loadStagiaires(): void {
    this.stagiaireService.getAllStagiaires().subscribe({
      next: (data: Stagiaire[]) => {this.stagiaires = data},
      error: (error) => console.error('Failed to load stagiaires', error)
    });
  }

  createStagiaire(): void {
    this.stagiaireService.createStagiaire(this.newStagiaire).subscribe({
      next : (data: Stagiaire) => {
        this.stagiaires.push(data);
        this.newStagiaire = {
          niveauEtude: '',
          nom: '',
          prenom: '',
          email: '',
          nomUniversite: '',
          specialite: '',
          encadreurId: 0,
          dateDebut: '',
          dateFin: ''
        };
      },
      error: (error) => console.error('Failed to create stagiaire', error)
  });
  }

  deleteStagiaire(id: number): void {
    this.stagiaireService.deleteStagiaire(id).subscribe({
      next: () => this.stagiaires = this.stagiaires.filter(stagiaire => stagiaire.id !== id),
      error: (error) => console.error('Failed to delete stagiaire', error)
  });
  }

}
