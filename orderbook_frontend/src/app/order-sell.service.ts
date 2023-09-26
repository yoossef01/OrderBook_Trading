import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderSell } from './models/order-sell';

@Injectable({
  providedIn: 'root'
})
export class OrderSellService {

  host="http://localhost:8081/ordersell"
  constructor( private client:HttpClient) {}
  
  
  public getOrderSellsByOrderBook(id:number):Observable<OrderSell []>
  {
    return this.client.get<OrderSell []>(this.host+"/ordersells/"+id);
  }
}
