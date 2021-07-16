package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long externalId;

    @Column(nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false, length = 15)
    private Integer phoneNumber;

    @Column(nullable = false, length = 400)
    private String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
