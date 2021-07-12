package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ClientOrder order;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private int countProduct;

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }
}
