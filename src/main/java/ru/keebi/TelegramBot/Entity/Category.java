package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private int parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }


}
