package com.ensi.orderbook.dao;

import com.ensi.orderbook.models.OrderSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderSellRepo extends JpaRepository<OrderSell,Long> {
    @Query("select os from OrderSell os where os.orderBook.id = :x")
    List<OrderSell> getSellOrdersByOrderBook(@Param("x") Long id);

}
