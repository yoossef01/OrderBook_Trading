import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from './models/stock';

@Injectable({
  providedIn: 'root'
})
export class StockService {

 
  host="http://localhost:8081/stocks"
  constructor( private client:HttpClient) {}
  public getAllStocks():Observable<Stock []>
  {
    return this.client.get<Stock []>(this.host+"/all")
  }

}