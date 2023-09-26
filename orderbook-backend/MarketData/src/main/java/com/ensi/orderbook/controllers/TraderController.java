package com.ensi.orderbook.controllers;

import com.ensi.orderbook.models.Trader;
import com.ensi.orderbook.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/traders")
public class TraderController {

    private final TraderService traderService;

    @Autowired
    public TraderController(TraderService traderService) {
        this.traderService = traderService;
    }

    // Endpoint pour créer un nouveau trader
    @PostMapping("/add")
    public Trader createTrader(@RequestBody Trader trader) {
        return traderService.createTrader(trader);
    }

    // Endpoint pour lire un trader par son ID
    @GetMapping("/{traderId}")
    public Trader getTrader(@PathVariable Long traderId) {
        return traderService.getTraderById(traderId);
    }

    // Endpoint pour mettre à jour un trader
    @PutMapping("/update/{traderId}")
    public Trader updateTrader(@PathVariable Long traderId, @RequestBody Trader trader) {
        trader.setId(traderId);
        return traderService.updateTrader(trader);
    }

    // Endpoint pour supprimer un trader par son ID
    @DeleteMapping("/delete/{traderId}")
    public void deleteTrader(@PathVariable Long traderId) {
        traderService.deleteTrader(traderId);
    }
}