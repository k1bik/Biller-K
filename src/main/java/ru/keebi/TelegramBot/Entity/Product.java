package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category category;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(nullable = false, precision=15, scale=2)
    private double price;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
