package com.ensi.orderbook.services;

import com.ensi.orderbook.dao.OrderBuyRepo;
import com.ensi.orderbook.models.OrderBuy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderBuyService implements OrderBuyInterfaceService {


    private final OrderBuyRepo Repo;

    @Autowired
    public OrderBuyService(OrderBuyRepo orderBuyRepository) {
        this.Repo = orderBuyRepository;
    }

    // Méthode pour créer un nouvel ordre d'achat
    @Override
    public OrderBuy createOrderBuy(OrderBuy orderBuy) {
        return Repo.save(orderBuy);
    }

    // Méthode pour lire un ordre d'achat par son ID
    @Override
    public OrderBuy getOrderBuyById(Long orderBuyId) {
        return Repo.findById(orderBuyId)
                .orElseThrow(() -> new EntityNotFoundException("OrderBuy not found with ID: " + orderBuyId));
    }

    // Méthode pour mettre à jour un ordre d'achat
    @Override
    public OrderBuy updateOrderBuy(OrderBuy orderBuy) {
        return Repo.save(orderBuy);
    }

    // Méthode pour supprimer un ordre d'achat par son ID
    @Override
    public void deleteOrderBuy(Long orderBuyId) {
        Repo.deleteById(orderBuyId);
    }
}
