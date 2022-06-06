package com.vanhieu.dto;

public class ContactDto {

    private String name;
    private String email;
    private String message;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
