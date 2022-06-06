package com.vanhieu.dto;

import java.sql.Date;

public class BookingDto extends AbstractDto<BookingDto>{

    private Integer total;
    private Date lastStayDay;
    private Date startStayDay;
    private Integer numOfStay;
    private String status;
    private Long roomId;
    private Long categoryId;
    private Long customerId;
    private CustomerDto customerBooking;
    private RoomDto bookingRoom;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getLastStayDay() {
        return lastStayDay;
    }

    public void setLastStayDay(Date lastStayDay) {
        this.lastStayDay = lastStayDay;
    }

    public Date getStartStayDay() {
        return startStayDay;
    }

    public void setStartStayDay(Date startStayDay) {
        this.startStayDay = startStayDay;
    }

    public Integer getNumOfStay() {
        return numOfStay;
    }

    public void setNumOfStay(Integer numOfStay) {
        this.numOfStay = numOfStay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoomDto getBookingRoom() {
        return bookingRoom;
    }

    public void setBookingRoom(RoomDto bookingRoom) {
        this.bookingRoom = bookingRoom;
    }

    public CustomerDto getCustomerBooking() {
        return customerBooking;
    }

    public void setCustomerBooking(CustomerDto customerBooking) {
        this.customerBooking = customerBooking;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
