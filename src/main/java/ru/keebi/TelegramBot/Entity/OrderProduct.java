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
    private Integer countProduct;

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }
}
