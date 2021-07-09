package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Category category;

    @Column
    private String name;

    @Column
    private String description;

    @Column
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
