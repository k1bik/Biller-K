package ru.keebi.TelegramBot.Entity;

import javax.persistence.*;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private long externalId;

    @Column
    private String fullName;

    @Column
    private int phoneNumber;

    @Column
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
