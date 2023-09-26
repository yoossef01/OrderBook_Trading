package com.ensi.orderbook.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
@Entity
@Setter
@Getter
@Table(name = "order_buy")
@NoArgsConstructor

public class OrderBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    private int quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "trader_id")
    private Trader trader;
    @ManyToOne
    private Stock stock;
    @ManyToOne
    private OrderBook orderBook;  // Ajout de l'attribut orderBook


    @Enumerated(EnumType.STRING)
    @ColumnDefault("'OUVERT'")
    private OrderStatus status;

    public enum OrderType{
        ACHAT,VENTE
    }
    public enum OrderStatus {
        OUVERT,REMPLI,ANNULE
    }
}
