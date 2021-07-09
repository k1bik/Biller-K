package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
@Table
public class OrderProduct {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private ClientOrder order;

    @ManyToOne
    private Product product;
}
