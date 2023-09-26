package com.ensi.orderbook.services;

import com.ensi.orderbook.models.Stock;

public interface StockInterfaceService {
    Stock createStock(Stock stock);
    Stock getStockById(Long stockId);
    Stock updateStock(Stock stock);
    void deleteStock(Long stockId);

}
