package com.vanhieu.api.web;

import com.vanhieu.dto.BookingDto;
import com.vanhieu.dto.RoomDto;
import com.vanhieu.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomApiOfWebpage {

    @Autowired
    private IRoomService roomService;

    @PostMapping("/api/webpage/room")
    public List<RoomDto> getRoom(@RequestBody BookingDto bookingDto) {
        List<RoomDto> rooms = roomService.getRoomAvailable(bookingDto.getCategoryId(), bookingDto.getStartStayDay(), bookingDto.getLastStayDay());
        return rooms;
    }
}
