import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatriculasFechasComponent } from './matriculas-fechas.component';

describe('MatriculasFechasComponent', () => {
  let component: MatriculasFechasComponent;
  let fixture: ComponentFixture<MatriculasFechasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatriculasFechasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatriculasFechasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
