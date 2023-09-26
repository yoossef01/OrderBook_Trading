import { TestBed } from '@angular/core/testing';

import { OrderBuyService } from './order-buy.service';

describe('OrderBuyService', () => {
  let service: OrderBuyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderBuyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
