package com.ensi.orderbook.controllers;

import com.ensi.orderbook.dao.OrderBookRepo;
import com.ensi.orderbook.models.OrderBook;
import com.ensi.orderbook.models.Stock;
import com.ensi.orderbook.services.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin({"*"})
@RestController
    @RequestMapping("/orderbook")
    public class OrderBookController {
        private final OrderBookRepo orderBookRepo;
        private final OrderBookService orderBookService;

        @Autowired
        public OrderBookController(OrderBookService orderBookService ,OrderBookRepo orderBookRepo) {
            this.orderBookService = orderBookService;
            this.orderBookRepo=orderBookRepo;
        }

        @PostMapping("/add")
        public OrderBook createOrderBook(@RequestBody OrderBook orderBook) {
            return orderBookService.createOrderBook(orderBook);
        }

        @GetMapping("/{orderBookId}")
        public OrderBook getOrderBook(@PathVariable Long orderBookId) {
            return orderBookService.getOrderBookById(orderBookId);
        }

        @PutMapping("/update/{orderBookId}")
        public OrderBook updateOrderBook(@PathVariable Long orderBookId, @RequestBody OrderBook orderBook) {
            orderBook.setId(orderBookId);
            return orderBookService.updateOrderBook(orderBook);
        }

        @DeleteMapping("/delete/{orderBookId}")
        public void deleteOrderBook(@PathVariable Long orderBookId) {
            orderBookService.deleteOrderBook(orderBookId);
        }
    }
