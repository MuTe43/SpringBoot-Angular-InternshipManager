import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Encadreur } from './encadreur.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EncadreurService {

  
  private apiUrl = 'http://localhost:8081/api/Encadreur';

  constructor(private http: HttpClient) { }

  getAllEncadreurs(): Observable<Encadreur[]> {
    return this.http.get<Encadreur[]>(this.apiUrl);
  }

  getEncadreurById(id: number): Observable<Encadreur> {
    return this.http.get<Encadreur>(`${this.apiUrl}/${id}`);
  }

  createEncadreur(encadreur: Encadreur): Observable<Encadreur> {
    return this.http.post<Encadreur>(this.apiUrl, encadreur);
  }

  deleteEncadreur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
