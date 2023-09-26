
    export class OrderBook {
        id: number;
        stock: {id:number};
      
        constructor(id: number, stock: {id:number}) {
          this.id = id;
          this.stock = stock;
        }
      }

