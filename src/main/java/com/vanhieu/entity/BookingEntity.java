package com.vanhieu.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "BookingEntity")
@Table(name = "booking")
public class BookingEntity extends BaseEntity{

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "last_stay_day", nullable = true)
    private Date lastStayDay;

    @Column(name = "start_stay_day", nullable = true)
    private Date startStayDay;

    @Column(name = "num_of_stay", nullable = true)
    private Integer numOfStay;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity bookingRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerBooking;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RoomEntity getBookingRoom() {
        return bookingRoom;
    }

    public void setBookingRoom(RoomEntity bookingRoom) {
        this.bookingRoom = bookingRoom;
    }

    public CustomerEntity getCustomerBooking() {
        return customerBooking;
    }

    public void setCustomerBooking(CustomerEntity customerBooking) {
        this.customerBooking = customerBooking;
    }
}
