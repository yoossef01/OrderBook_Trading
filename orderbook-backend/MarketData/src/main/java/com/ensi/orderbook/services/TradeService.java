package com.ensi.orderbook.services;

import com.ensi.orderbook.dao.TradeRepo;
import com.ensi.orderbook.models.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
@Service
public class TradeService implements TradeInterfaceService {

    private final TradeRepo Repo;

    @Autowired
    public TradeService(TradeRepo tradeRepository) {
        this.Repo = tradeRepository;
    }
@Override
    // Méthode pour créer une nouvelle transaction
    public Trade createTrade(Trade trade) {
        return Repo.save( trade );
    }
    @Override
    // Méthode pour lire une transaction par son ID
    public Trade getTradeById(Long tradeId) {
        return Repo.findById( tradeId )
                .orElseThrow( () -> new EntityNotFoundException( "Trade not found with ID: " + tradeId ) );
    }
    @Override
    // Méthode pour mettre à jour une transaction
    public Trade updateTrade(Trade trade) {
        return Repo.save( trade );
    }
    @Override
    // Méthode pour supprimer une transaction par son ID
    public void deleteTrade(Long tradeId) {
        Repo.deleteById(tradeId);
    }
}