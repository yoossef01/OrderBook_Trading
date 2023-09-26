package com.ensi.orderbook.services;

import com.ensi.orderbook.dao.StockRepo;
import com.ensi.orderbook.models.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
@Service
public class StockService implements StockInterfaceService{

    private final StockRepo Repo;

    @Autowired
    public StockService(StockRepo Repo){this.Repo=Repo;}
@Override
public Stock createStock(Stock stock) {
    return Repo.save(stock);
}
    @Override
    // Méthode pour lire un stock par son ID
    public Stock getStockById(Long stockId) {
        return Repo.findById(stockId)
                .orElseThrow(() -> new EntityNotFoundException("Stock not found with ID: " + stockId));
    }
    @Override
    // Méthode pour mettre à jour un stock
    public Stock updateStock(Stock stock) {
        return Repo.save(stock);
    }
    @Override
    // Méthode pour supprimer un stock par son ID
    public void deleteStock(Long stockId) {
        Repo.deleteById(stockId);
    }
}
