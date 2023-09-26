
    export class Stock {
        id: number;
        symbol: string;
        closePrice: number;
        volume: number;
        openPrice: number;
        highPrice: number;
        lowPrice: number;
        variation: number;
      
        constructor(
          id: number,
          symbol: string,
          closePrice: number,
          volume: number,
          openPrice: number,
          highPrice: number,
          lowPrice: number,
          variation: number
        ) {
          this.id = id;
          this.symbol = symbol;
          this.closePrice = closePrice;
          this.volume = volume;
          this.openPrice = openPrice;
          this.highPrice = highPrice;
          this.lowPrice = lowPrice;
          this.variation = variation;
        }
      }
      

