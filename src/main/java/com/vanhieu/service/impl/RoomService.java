package com.vanhieu.service.impl;

import com.vanhieu.converter.RoomConverter;
import com.vanhieu.dto.RoomDto;
import com.vanhieu.entity.RoomEntity;
import com.vanhieu.repository.RoomRepository;
import com.vanhieu.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomConverter roomConverter;

    @Override
    public int count() {
        return (int) roomRepository.count();
    }

    @Override
    @Transactional
    public RoomDto save(RoomDto roomDto) {
        RoomEntity entity = roomConverter.toEntity(roomDto);
        entity.setStatus(1);
        return roomConverter.toDto(roomRepository.save(entity));
    }

    @Override
    @Transactional
    public RoomDto update(RoomDto roomDto) {
        RoomEntity entity = roomRepository.getOne(roomDto.getId());
        entity = roomConverter.toEntity(entity, roomDto);
        return roomConverter.toDto(roomRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            roomRepository.deleteById(id);
        }
    }

    @Override
    public RoomDto findByRoomNumber(String roomNumber) {
        return roomConverter.toDto(roomRepository.findByRoomNumber(roomNumber));
    }

    @Override
    public List<RoomDto> findByCategoryCode(String categoryCode, Pageable pageable) {
//        List<RoomEntity> entities = roomRepository.findByCategoryCode(categoryCode, pageable, 1);
//        List<RoomDto> results = new ArrayList<>();
//        for (RoomEntity entity : entities) {
//            RoomDto dto = roomConverter.toDto(entity);
//            results.add(dto);
//        }
//        return results;
        return null;
    }

    @Override
    public List<RoomDto> findAll(Pageable pageable) {
        List<RoomEntity> entities = roomRepository.findAll(pageable).getContent();
        List<RoomDto> results = new ArrayList<>();
        for (RoomEntity entity : entities) {
            RoomDto dto = roomConverter.toDto(entity);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<RoomDto> findByStatus(Integer status, Pageable pageable) {
//        List<RoomEntity> entities = roomRepository.findByStatus(status, pageable);
//        List<RoomDto> results = new ArrayList<>();
//        for (RoomEntity entity : entities) {
//            RoomDto dto = roomConverter.toDto(entity);
//            results.add(dto);
//        }
//        return results;
        return null;
    }

    @Override
    @Transactional
    public void roomCheckOut(Long id) {
        RoomEntity entity = roomRepository.getOne(id);
        if (entity.getStatus() == 0) {
            entity.setStatus(1);
        }
        roomRepository.save(entity);
    }

    @Override
    @Transactional
    public void roomCheckIn(Long id) {
        RoomEntity entity = roomRepository.getOne(id);
        if (entity.getStatus() == 1) {
            entity.setStatus(0);
        }
        roomRepository.save(entity);
    }

    @Override
    public RoomDto getOne(Long id) {
        return roomConverter.toDto(roomRepository.getOne(id));
    }

    @Override
    public List<RoomDto> getRoomAvailable(Long categoryId, Date startDay, Date lastDay) {
        List<RoomEntity> roomEntities = roomRepository.getRoomAvailable(categoryId, (java.sql.Date) startDay, (java.sql.Date) lastDay);
        List<RoomEntity> allRoom = roomRepository.findByCategoryId(categoryId);
        for(RoomEntity room : roomEntities) {
            allRoom.remove(room);
        }

        List<RoomDto> result = new ArrayList<>();
        allRoom.forEach(room -> result.add(roomConverter.toDto(room)));
        return result;
    }

    @Override
    public List<RoomDto> findByCategoryId(Long categoryId) {
        List<RoomEntity> roomEntities = roomRepository.findByCategoryId(categoryId);
        List<RoomDto> result = new ArrayList<>();
        roomEntities.forEach(room -> result.add(roomConverter.toDto(room)));
        return result;
    }
}
