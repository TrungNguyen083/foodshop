import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyOrderDetailsComponent } from './my-order-details.component';

describe('MyOrderDetailsComponent', () => {
  let component: MyOrderDetailsComponent;
  let fixture: ComponentFixture<MyOrderDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyOrderDetailsComponent]
    });
    fixture = TestBed.createComponent(MyOrderDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
