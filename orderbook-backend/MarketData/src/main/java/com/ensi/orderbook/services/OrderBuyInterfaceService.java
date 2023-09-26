package com.ensi.orderbook.services;

import com.ensi.orderbook.models.OrderBuy;

public interface OrderBuyInterfaceService {

    OrderBuy createOrderBuy(OrderBuy orderBuy);
    OrderBuy getOrderBuyById(Long orderBuyId);
    OrderBuy updateOrderBuy(OrderBuy orderBuy);
    void deleteOrderBuy(Long orderBuyId);
}
