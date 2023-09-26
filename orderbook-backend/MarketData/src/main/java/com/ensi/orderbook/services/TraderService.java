package com.ensi.orderbook.services;

import com.ensi.orderbook.dao.TraderRepo;
import com.ensi.orderbook.models.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
@Service
public class TraderService implements TraderInterfaceService {

    private final TraderRepo Repo;

    @Autowired
    public TraderService(TraderRepo traderRepository) {
        this.Repo = traderRepository;
    }

    // Méthode pour créer un nouveau trader
    public Trader createTrader(Trader trader) {
        return Repo.save(trader);
    }

    // Méthode pour lire un trader par son ID
    public Trader getTraderById(Long traderId) {
        return Repo.findById(traderId)
                .orElseThrow(() -> new EntityNotFoundException("Trader not found with ID: " + traderId));
    }

    // Méthode pour mettre à jour un trader
    public Trader updateTrader(Trader trader) {
        return Repo.save(trader);
    }

    // Méthode pour supprimer un trader par son ID
    public void deleteTrader(Long traderId) {
        Repo.deleteById(traderId);
    }
}
