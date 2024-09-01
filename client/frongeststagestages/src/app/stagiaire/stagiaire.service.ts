import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stagiaire } from './stagiaire.model';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  

  private apiUrl='http://localhost:8081/api/Stagiaire';

  constructor(private http: HttpClient) { }

  getAllStagiaires(): Observable<Stagiaire[]>{
    return this.http.get<Stagiaire[]>(this.apiUrl);
  }

  getStagiaireById(id: number): Observable<Stagiaire> {
    return this.http.get<Stagiaire>(`${this.apiUrl}/${id}`);
  }

  createStagiaire(stagiaire: Stagiaire): Observable<Stagiaire> {
    return this.http.post<Stagiaire>(this.apiUrl, stagiaire);
  }

  deleteStagiaire(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
