import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MorefuncsComponent } from './morefuncs.component';

describe('MorefuncsComponent', () => {
  let component: MorefuncsComponent;
  let fixture: ComponentFixture<MorefuncsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MorefuncsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MorefuncsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
