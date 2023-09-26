import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrderBuy } from './models/order-buy';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderBuyService {

  host="http://localhost:8081/orderbuy"
  constructor( private client:HttpClient) {}
  
  
  public getOrderBuysByOrderBook(id:number):Observable<OrderBuy []>
  {
    return this.client.get<OrderBuy []>(this.host+"/orderbuys/"+id);
  }
}
