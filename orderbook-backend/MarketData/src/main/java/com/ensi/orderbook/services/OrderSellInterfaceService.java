package com.ensi.orderbook.services;

import com.ensi.orderbook.models.OrderSell;

public interface OrderSellInterfaceService {
    OrderSell createOrderSell(OrderSell orderSell);
    OrderSell getOrderSellById(Long orderSellId);
    OrderSell updateOrderSell(OrderSell orderSell);
    void deleteOrderSell(Long orderSellId);
}
