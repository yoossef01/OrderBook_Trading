package com.ensi.orderbook.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "trader")
@NoArgsConstructor
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double accountBalance;

    @OneToMany(mappedBy = "trader")
    private List<OrderSell> sellOrders;
    @OneToMany(mappedBy = "trader")
    private List<OrderBuy> buyOrders;


    @ManyToMany
    @JoinTable(name = "trader_portfolio",
            joinColumns = @JoinColumn(name = "trader_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    private List<Stock> portfolio;



}
