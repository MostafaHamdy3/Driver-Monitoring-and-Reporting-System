import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'

import { UserLoginService } from './user-login.service';

describe('UserLoginService', () => {
  let service: UserLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(UserLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
