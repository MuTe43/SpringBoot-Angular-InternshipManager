export interface Stagiaire {
    id?: number;
    niveauEtude: string;
    nom: string;
    prenom: string;
    email: string;
    nomUniversite: string;
    specialite: string;
    encadreurId: number;
    dateDebut: string;
    dateFin: string;
  }