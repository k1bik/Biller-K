package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
@Table
public class ClientOrder {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Client client;

    @Column
    private int status;

    @Column
    private double total;

    public Client getClientId() {
        return client;
    }

    public void setClientId(Client client) {
        this.client = client;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}