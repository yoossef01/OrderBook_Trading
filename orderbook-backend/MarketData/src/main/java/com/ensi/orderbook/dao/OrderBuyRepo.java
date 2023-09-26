package com.ensi.orderbook.dao;

import com.ensi.orderbook.models.OrderBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBuyRepo extends JpaRepository<OrderBuy,Long> {
    @Query("select o from OrderBuy o where o.orderBook.id = :x")
    List<OrderBuy> getBuyOrdersByOrderBook(@Param("x") Long id);

}
