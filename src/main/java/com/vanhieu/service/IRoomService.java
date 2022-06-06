package com.vanhieu.service;

import com.vanhieu.dto.RoomDto;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IRoomService {

    int count();
    RoomDto save(RoomDto roomDto);
    RoomDto update(RoomDto roomDto);
    void delete(Long[] ids);
    RoomDto findByRoomNumber(String roomNumber);
    List<RoomDto> findByCategoryCode(String categoryCode, Pageable pageable);
    List<RoomDto> findAll(Pageable pageable);
    List<RoomDto> findByStatus(Integer status, Pageable pageable);
    void roomCheckOut (Long id);
    void roomCheckIn (Long id);
    RoomDto getOne(Long id);
    List<RoomDto> getRoomAvailable(Long categoryId, Date startDay, Date lastDay);
    List<RoomDto> findByCategoryId(Long categoryId);
}
