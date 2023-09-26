package com.ensi.orderbook.services;

import com.ensi.orderbook.models.OrderBook;

import java.util.Optional;

public interface OrderbookInterfaceService {
    OrderBook createOrderBook(OrderBook orderBook);
    OrderBook getOrderBookById(Long orderBookId);
    OrderBook updateOrderBook(OrderBook orderBook);
    public void deleteOrderBook(Long orderBookId);


}

