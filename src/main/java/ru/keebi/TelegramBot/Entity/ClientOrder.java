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
    private Integer status;

    @Column(nullable = false, precision=15, scale=2)
    private Double total;

    public Client getClientId() {
        return client;
    }

    public void setClientId(Client client) {
        this.client = client;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
