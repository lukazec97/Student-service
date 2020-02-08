import { TestBed } from '@angular/core/testing';

import { ObavestenjaService } from './obavestenja.service';

describe('ObavestenjaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ObavestenjaService = TestBed.get(ObavestenjaService);
    expect(service).toBeTruthy();
  });
});
