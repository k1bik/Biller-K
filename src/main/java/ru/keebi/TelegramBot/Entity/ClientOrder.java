package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
public class ClientOrder {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Client client;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false, precision=15, scale=2)
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
