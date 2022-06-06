package com.vanhieu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CustomerEntity")
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "identity", nullable = false)
    private String identity;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "customerBooking")
    private List<BookingEntity> booking = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<BookingEntity> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingEntity> booking) {
        this.booking = booking;
    }
}
