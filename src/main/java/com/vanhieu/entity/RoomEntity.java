package com.vanhieu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "RoomEntity")
@Table(name = "room")
public class RoomEntity extends BaseEntity{

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryOfRoom;

    @OneToMany(mappedBy = "bookingRoom")
    private List<BookingEntity> booking = new ArrayList<>();

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CategoryEntity getCategoryOfRoom() {
        return categoryOfRoom;
    }

    public void setCategoryOfRoom(CategoryEntity categoryOfRoom) {
        this.categoryOfRoom = categoryOfRoom;
    }
}
