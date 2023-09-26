import { Component, OnInit } from '@angular/core';
import { OrderBuy } from 'src/app/models/order-buy';
import { OrderSell } from 'src/app/models/order-sell';
import { Stock } from 'src/app/models/stock';
import { OrderBuyService } from 'src/app/order-buy.service';
import { OrderSellService } from 'src/app/order-sell.service';
import { StockService } from 'src/app/stock.service';
import * as Highcharts from 'highcharts';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
chart:any;
  stocks!:Stock[];
stocks_2!:Stock[];
itemsPerPage = 15; // Nombre d'éléments par page
currentPage = 1; 
OrderBuys!:OrderBuy[];
OrderSells!:OrderSell[];
OrderSellBook!:OrderSell[];
OrderBuyBook!:OrderBuy[];
  constructor(private stockService:StockService,private orderBuyService:OrderBuyService,private orderSellService:OrderSellService) { }

  ngOnInit(): void {
    this.stockService.getAllStocks().subscribe(data=>{this.stocks=data;this.stocks_2=this.stocks;
      this.getCurrentPageStocks();
      
    console.log(this.getCurrentPageStocks())})
    this.orderBuyService.getOrderBuysByOrderBook(1).subscribe(data=>{this.OrderBuys=data;  
      this.OrderBuys.sort((a, b) => b.price - a.price);
      this.OrderBuyBook = this.OrderBuys.slice(0, 6); 
;    });
    this.orderSellService.getOrderSellsByOrderBook(1).subscribe(data=>{this.OrderSells=data; 
      this.OrderSells.sort((a, b) => a.price - b.price);  
      this.OrderSellBook = this.OrderSells.slice(0, 6); 
    });

    this.chart = Highcharts.chart('container', {
      chart: {
        type: 'line',
        height: 325
      },
      title: {
        text: 'Transactions par mois'
      },
      xAxis: {
        categories: [
          'Mon', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
          'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
        ]
      },
      yAxis: {
        title: {
          text: 'Revenue in DT'
        }
      },
      series: [
        {
          name: 'Tunisie',
          type: 'line',
          color: '#044342',
          data: [5, -2, 7, -3, 9]
        }
      ],
      credits: {
        enabled: false
      }
    });
  
  
  
  
  
  
  
  }
  


  changePage(page: number) {
    this.currentPage = page;
  }

  // Fonction pour obtenir la liste des stocks à afficher sur la page actuelle
  getCurrentPageStocks() {
    if (this.stocks) {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      return this.stocks.slice(startIndex, endIndex);
    } else {
      return []; // Ou tout autre gestion de cas où les données ne sont pas encore disponibles
    }
  }
  

  // Fonction pour obtenir le nombre total de pages
  getTotalPages() {
    return Math.ceil(90 / this.itemsPerPage);
  }

  // Fonction pour générer un tableau de pages
  getPagesArray() {
    return new Array(this.getTotalPages()).fill(0).map((_, i) => i + 1);
  }



}
