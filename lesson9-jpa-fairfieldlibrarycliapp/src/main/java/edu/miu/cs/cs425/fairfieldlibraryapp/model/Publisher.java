package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    private String name;
    private String contactPhoneNumber;

    public Publisher(Integer publisherId, String name, String contactPhoneNumber) {
        this.publisherId = publisherId;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public Publisher(String name, String contactPhoneNumber) {
        this(null, name, contactPhoneNumber);
    }

    public Publisher() {
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                '}';
    }
}
