import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { EncadreurComponent } from './encadreur/encadreur.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    {
        path :'',
        component: HomeComponent
    },
    {
        path :'home',
        component: HomeComponent
    },
    {
        path :'about',
        component: AboutComponent
    },
    {
        path :'stagiaire',
        component: StagiaireComponent
    },
    {
        path :'encadreur',
        component: EncadreurComponent
    }
];

