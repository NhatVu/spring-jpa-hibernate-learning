package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.example.Constants;

import java.math.BigDecimal;

@Entity
public class Bid {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    public Long getId() { // Optional but useful
        return id;
    }

    public Bid() {
    }

    @NotNull
    protected BigDecimal amount;

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

//    @ManyToOne(optional = false, fetch = FetchType.LAZY) // NOT NULL
//    @JoinColumn(name = "ITEM_ID") // Actually the default name
    protected Item item;

    public Bid(Item item) {
        this.item = item;
        item.getBids().add(this); // Bidirectional
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
