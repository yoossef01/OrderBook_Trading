package com.ensi.orderbook.dao;

import com.ensi.orderbook.models.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepo extends JpaRepository<OrderBook,Long> {
}
