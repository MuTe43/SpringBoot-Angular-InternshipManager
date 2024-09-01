import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MenuComponent } from "./menu/menu.component";
import { AboutComponent } from './about/about.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { EncadreurComponent } from './encadreur/encadreur.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MenuComponent, AboutComponent, StagiaireComponent, EncadreurComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frongeststagestages';
}
