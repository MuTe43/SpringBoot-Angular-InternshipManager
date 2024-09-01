import { Component, OnInit } from '@angular/core';
import { Encadreur } from './encadreur.model';
import { EncadreurService } from './encadreur.service';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-encadreur',
  standalone: true,
  imports: [FormsModule,
    RouterModule,
    CommonModule,],
  templateUrl: './encadreur.component.html',
  styleUrl: './encadreur.component.css'
})
export class EncadreurComponent implements OnInit{
  encadreurs: Encadreur[] = [];
  newEncadreur: Encadreur = {
    email: '',
    department: '',
    nom: '',
    prenom: ''
  };

  constructor(private encadreurService: EncadreurService, private router: Router) { }

  ngOnInit(): void {
    this.loadEncadreurs();
  }

  loadEncadreurs(): void {
    this.encadreurService.getAllEncadreurs().subscribe({
      next: (data: Encadreur[]) => this.encadreurs = data,
      error: (error) => console.error('Failed to load encadreurs', error)
  });
  }

  createEncadreur(): void {
    this.encadreurService.createEncadreur(this.newEncadreur).subscribe({
      next: (data: Encadreur) => {
        this.encadreurs.push(data);
        this.newEncadreur = {
          email: '',
          department: '',
          nom: '',
          prenom: ''
        };
      },
      error: (error) => console.error('Failed to create encadreur', error)
  });
  }

  deleteEncadreur(id: number): void {
    this.encadreurService.deleteEncadreur(id).subscribe({
      next: () => this.encadreurs = this.encadreurs.filter(encadreur => encadreur.id !== id),
      error: (error) => console.error('Failed to delete encadreur', error)
  });
  }
}
