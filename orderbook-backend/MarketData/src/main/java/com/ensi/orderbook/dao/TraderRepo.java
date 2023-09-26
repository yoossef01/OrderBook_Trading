package com.ensi.orderbook.dao;

import com.ensi.orderbook.models.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepo extends JpaRepository<Trader,Long> {

}
