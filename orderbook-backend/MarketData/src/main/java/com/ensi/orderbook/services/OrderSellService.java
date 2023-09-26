package com.ensi.orderbook.services;

import com.ensi.orderbook.dao.OrderSellRepo;
import com.ensi.orderbook.models.OrderSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
@Service
public class OrderSellService implements OrderSellInterfaceService{

    private final OrderSellRepo Repo;

    @Autowired
    public OrderSellService(OrderSellRepo Repo){
        this.Repo=Repo;
    }
    @Override
    public OrderSell createOrderSell(OrderSell orderSell) {
        return Repo.save(orderSell);
    }

    // Méthode pour lire un ordre de vente par son ID
    @Override
    public OrderSell getOrderSellById(Long orderSellId) {
        return Repo.findById(orderSellId)
                .orElseThrow(() -> new EntityNotFoundException("OrderSell not found with ID: " + orderSellId));
    }
    @Override
    // Méthode pour mettre à jour un ordre de vente
    public OrderSell updateOrderSell(OrderSell orderSell) {
        return Repo.save(orderSell);
    }
    @Override
    // Méthode pour supprimer un ordre de vente par son ID
    public void deleteOrderSell(Long orderSellId) {
        Repo.deleteById(orderSellId);
    }
}
