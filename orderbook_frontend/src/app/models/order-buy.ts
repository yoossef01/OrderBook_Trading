export class OrderBuy {
    id: number;
    orderType: OrderType;
    quantity: number;
    price: number;
    //trader: Trader;
    stock: {id:number};
    orderBook: {id:number};
    status: OrderStatus;
  
    constructor(
      id: number,
      orderType: OrderType,
      quantity: number,
      price: number,
      //trader: Trader,
      stock: {id:number},
      orderBook: {id:number},
      status: OrderStatus
    ) {
      this.id = id;
      this.orderType = orderType;
      this.quantity = quantity;
      this.price = price;
      //this.trader = trader;
      this.stock = stock;
      this.orderBook = orderBook;
      this.status = status;
    }
  }
  
  export enum OrderType {
    ACHAT = 'ACHAT',
    VENTE = 'VENTE',
  }
  
  export enum OrderStatus {
    OUVERT = 'OUVERT',
    REMPLI = 'REMPLI',
    ANNULE = 'ANNULE',
  }
  