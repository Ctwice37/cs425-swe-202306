package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;

//    @Column(unique = true)
//    private String publisherNumber;

    @Column(nullable = false)
    @NotNull(message = "Name is required and cannot be null")
    @NotEmpty(message = "Name is required, cannot be null or empty string") // ""
    @NotBlank(message = "Name is required, cannot be null or empty string or blank spaces") // "  "
    private String name;
    private String contactPhoneNumber;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_address_id")
    private Address primaryAddress;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

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

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", address='" + primaryAddress + '\'' +
                '}';
    }
}
