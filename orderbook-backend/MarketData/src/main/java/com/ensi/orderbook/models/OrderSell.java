package com.ensi.orderbook.models;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity

@Setter
@Getter
@Table(name = "order_sell")
@NoArgsConstructor
public class OrderSell {

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