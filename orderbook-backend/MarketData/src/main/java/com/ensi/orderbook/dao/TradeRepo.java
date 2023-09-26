package com.ensi.orderbook.dao;

import com.ensi.orderbook.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepo extends JpaRepository<Trade,Long> {

}
