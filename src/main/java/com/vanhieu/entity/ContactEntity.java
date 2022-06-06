package com.vanhieu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class ContactEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "status")
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
