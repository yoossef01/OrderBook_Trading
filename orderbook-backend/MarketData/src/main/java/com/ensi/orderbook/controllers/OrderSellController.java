package com.ensi.orderbook.controllers;

import com.ensi.orderbook.dao.OrderSellRepo;
import com.ensi.orderbook.models.OrderSell;
import com.ensi.orderbook.services.OrderSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordersell")
public class OrderSellController {

    private final OrderSellService orderSellService;
    private final OrderSellRepo orderSellRepo;
    @Autowired
    public OrderSellController(OrderSellService orderSellService,OrderSellRepo orderSellRepo) {
        this.orderSellService = orderSellService;
        this.orderSellRepo=orderSellRepo;
    }
    @GetMapping("/ordersells/{orderBookId}")
    public List<OrderSell> getSellOrdersByOrderBook(@PathVariable Long orderBookId){
        return this.orderSellRepo.getSellOrdersByOrderBook( orderBookId );
    }
    // Endpoint pour créer un nouvel ordre d'achat
    @PostMapping("/add")
    public OrderSell createOrderSell(@RequestBody OrderSell orderSell) {
        return orderSellService.createOrderSell(orderSell);
    }

    // Endpoint pour lire un ordre d'achat par son ID
    @GetMapping("/{orderSellId}")
    public OrderSell getOrderSell(@PathVariable Long orderSellId) {
        return orderSellService.getOrderSellById(orderSellId);
    }

    // Endpoint pour mettre à jour un ordre d'achat
    @PutMapping("/update/{orderSellId}")
    public OrderSell updateOrderSell(@PathVariable Long orderSellId, @RequestBody OrderSell orderSell) {
        orderSell.setId(orderSellId);
        return orderSellService.updateOrderSell(orderSell);
    }

    // Endpoint pour supprimer un ordre d'achat par son ID
    @DeleteMapping("/delete/{orderSellId}")
    public void deleteOrderSell(@PathVariable Long orderSellId) {
        orderSellService.deleteOrderSell(orderSellId);
    }
}