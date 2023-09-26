package com.ensi.orderbook.services;

import com.ensi.orderbook.dao.OrderBookRepo;
import com.ensi.orderbook.models.OrderBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class OrderBookService implements OrderbookInterfaceService {


    private final OrderBookRepo Repo;

    @Autowired
    public OrderBookService(OrderBookRepo orderBookRepository) {
        this.Repo = orderBookRepository;
    }

    // Méthode pour créer un nouvel OrderBook
    @Override
    public OrderBook createOrderBook(OrderBook orderBook) {
        return Repo.save(orderBook);
    }

    // Méthode pour lire un OrderBook par son ID
    @Override
    public OrderBook getOrderBookById(Long orderBookId) {
        return Repo.findById(orderBookId)
                .orElseThrow(() -> new EntityNotFoundException("OrderBook not found with ID: " + orderBookId));
    }

    // Méthode pour mettre à jour un OrderBook
    @Override
    public OrderBook updateOrderBook(OrderBook orderBook) {
        return Repo.save(orderBook);
    }

    // Méthode pour supprimer un OrderBook par son ID
    @Override
    public void deleteOrderBook(Long orderBookId) {
        Repo.deleteById(orderBookId);
    }
}


