package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private long externalId;

    @Column(nullable = false, length = 255)
    private String fullName;

    @Column(nullable = false, length = 15)
    private int phoneNumber;

    @Column(nullable = false, length = 400)
    private String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }
}
