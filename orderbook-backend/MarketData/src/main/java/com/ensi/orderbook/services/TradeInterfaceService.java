package com.ensi.orderbook.services;

import com.ensi.orderbook.models.Trade;

public interface TradeInterfaceService {
    Trade createTrade(Trade trade);
    Trade getTradeById(Long tradeId);
    Trade updateTrade(Trade trade);
    void deleteTrade(Long tradeId);


}
