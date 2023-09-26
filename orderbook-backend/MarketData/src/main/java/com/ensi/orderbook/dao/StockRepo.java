package com.ensi.orderbook.dao;

import com.ensi.orderbook.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock,Long> {

}