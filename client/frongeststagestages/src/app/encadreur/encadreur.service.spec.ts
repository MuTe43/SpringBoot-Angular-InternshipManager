import { TestBed } from '@angular/core/testing';

import { EncadreurService } from './encadreur.service';

describe('EncadreurService', () => {
  let service: EncadreurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EncadreurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
