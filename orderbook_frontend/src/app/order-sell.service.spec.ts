import { TestBed } from '@angular/core/testing';

import { OrderSellService } from './order-sell.service';

describe('OrderSellService', () => {
  let service: OrderSellService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrderSellService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
