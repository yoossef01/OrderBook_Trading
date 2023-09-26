package com.ensi.orderbook.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "stock")
@NoArgsConstructor
public  class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private double closePrice;
    private long volume;

    private double openPrice;   // Prix d'ouverture
    private double highPrice;   // Prix le plus élevé de la journée
    private double lowPrice;    // Prix le plus bas de la journée
    private long variation;
    @ManyToMany(mappedBy = "portfolio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private List<Trader> traders;
    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private List<Trade> trades;


}
