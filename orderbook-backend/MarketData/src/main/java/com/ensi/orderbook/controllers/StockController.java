package com.ensi.orderbook.controllers;
import com.ensi.orderbook.dao.StockRepo;
import com.ensi.orderbook.models.Stock;
import com.ensi.orderbook.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;
    private final StockRepo stockRepo;

    @Autowired
    public StockController(StockService stockService,StockRepo sr) {
        this.stockService = stockService;
        this.stockRepo=sr;
    }
    @GetMapping("/all")
    public List<Stock> getAllMarket(){
        return this.stockRepo.findAll();
    }
    // Endpoint pour créer un nouveau stock
    @PostMapping("/add")
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    // Endpoint pour lire un stock par son ID
    @GetMapping("/{stockId}")
    public Stock getStock(@PathVariable Long stockId) {
        return stockService.getStockById(stockId);
    }

    // Endpoint pour mettre à jour un stock
    @PutMapping("/update/{stockId}")
    public Stock updateStock(@PathVariable Long stockId, @RequestBody Stock stock) {
        stock.setId(stockId);
        return stockService.updateStock(stock);
    }

    // Endpoint pour supprimer un stock par son ID
    @DeleteMapping("/delete/{stockId}")
    public void deleteStock(@PathVariable Long stockId) {
        stockService.deleteStock(stockId);
    }
}