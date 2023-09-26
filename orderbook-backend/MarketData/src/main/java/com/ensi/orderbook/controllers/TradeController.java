package com.ensi.orderbook.controllers;

import com.ensi.orderbook.models.Trade;
import com.ensi.orderbook.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    // Endpoint pour créer une nouvelle transaction
    @PostMapping("/add")
    public Trade createTrade(@RequestBody Trade trade) {
        return tradeService.createTrade(trade);
    }

    // Endpoint pour lire une transaction par son ID
    @GetMapping("/{tradeId}")
    public Trade getTrade(@PathVariable Long tradeId) {
        return tradeService.getTradeById(tradeId);
    }

    // Endpoint pour mettre à jour une transaction
    @PutMapping("/update/{tradeId}")
    public Trade updateTrade(@PathVariable Long tradeId, @RequestBody Trade trade) {
        trade.setId(tradeId);
        return tradeService.updateTrade(trade);
    }

    // Endpoint pour supprimer une transaction par son ID
    @DeleteMapping("/delete/{tradeId}")
    public void deleteTrade(@PathVariable Long tradeId) {
        tradeService.deleteTrade(tradeId);
    }
}
