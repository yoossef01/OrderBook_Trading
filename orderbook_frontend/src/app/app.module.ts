import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { StockComponent } from './components/stock/stock.component';
import { OrderBookComponent } from './components/order-book/order-book.component';

@NgModule({
  declarations: [
    AppComponent,
    StockComponent,
    OrderBookComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule, 
    FormsModule, BrowserModule,
    
    BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
