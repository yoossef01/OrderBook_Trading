package com.ensi.orderbook.controllers;

import com.ensi.orderbook.dao.OrderBuyRepo;
import com.ensi.orderbook.models.OrderBuy;
import com.ensi.orderbook.services.OrderBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderbuy")
public class OrderBuyController {
    private final OrderBuyRepo orderBuyRepo;
    private final OrderBuyService orderBuyService;

    @Autowired
    public OrderBuyController(OrderBuyService orderBuyService,OrderBuyRepo orderBuyRepo) {
        this.orderBuyService = orderBuyService;this.orderBuyRepo=orderBuyRepo;
    }
     @GetMapping("/orderbuys/{orderBookId}")
     public List<OrderBuy> getBuyOrdersByOrderBook(@PathVariable Long orderBookId){
         return this.orderBuyRepo.getBuyOrdersByOrderBook( orderBookId );
     }
    // Endpoint pour créer un nouvel ordre d'achat
    @PostMapping("/add")
    public OrderBuy createOrderBuy(@RequestBody OrderBuy orderBuy) {
        return orderBuyService.createOrderBuy(orderBuy);
    }

    // Endpoint pour lire un ordre d'achat par son ID
    @GetMapping("/{orderBuyId}")
    public OrderBuy getOrderBuy(@PathVariable Long orderBuyId) {
        return orderBuyService.getOrderBuyById(orderBuyId);
    }

    // Endpoint pour mettre à jour un ordre d'achat
    @PutMapping("/update/{orderBuyId}")
    public OrderBuy updateOrderBuy(@PathVariable Long orderBuyId, @RequestBody OrderBuy orderBuy) {
        orderBuy.setId(orderBuyId);
        return orderBuyService.updateOrderBuy(orderBuy);
    }

    // Endpoint pour supprimer un ordre d'achat par son ID
    @DeleteMapping("/delete/{orderBuyId}")
    public void deleteOrderBuy(@PathVariable Long orderBuyId) {
        orderBuyService.deleteOrderBuy(orderBuyId);
    }
}
