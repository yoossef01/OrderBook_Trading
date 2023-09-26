package com.ensi.orderbook.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_book")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Stock stock;

    @OneToMany(mappedBy = "orderBook",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderBuy> buyOrders;

    @OneToMany(mappedBy = "orderBook",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderSell> sellOrders;


}