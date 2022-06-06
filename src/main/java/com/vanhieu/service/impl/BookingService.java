package com.vanhieu.service.impl;

import com.vanhieu.converter.BookingConverter;
import com.vanhieu.dto.BookingDto;
import com.vanhieu.dto.CustomerDto;
import com.vanhieu.entity.BookingEntity;
import com.vanhieu.entity.CustomerEntity;
import com.vanhieu.repository.BookingRepository;
import com.vanhieu.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingConverter bookingConverter;

    @Override
    public int count() {
        return (int) bookingRepository.count();
    }

    @Override
    public int countCheckin() {
        return bookingRepository.countByStatus(2);
    }

    @Override
    public int countCheckout() {
        return bookingRepository.countByStatus(3);
    }

    @Override
    public int countComplete() {
        return bookingRepository.countByStatus(1);
    }


    @Override
    @Transactional
    public BookingDto save(BookingDto bookingDto) {
        BookingEntity entity = bookingConverter.toEntity(bookingDto);
        entity.setStatus(2);
        entity = bookingRepository.save(entity);
        return bookingConverter.toDto(entity);
    }

    @Override
    @Transactional
    public BookingDto update(BookingDto bookingDto) {
        BookingEntity entity = bookingRepository.getOne(bookingDto.getId());
        entity = bookingConverter.toEntity(entity, bookingDto);
        return bookingConverter.toDto(bookingRepository.save(entity));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            bookingRepository.deleteById(id);
        }
    }

    @Override
    public List<BookingDto> findAll(Pageable pageable) {
        List<BookingEntity> entities = bookingRepository.findAll(pageable).getContent();
        return castToList(entities);
    }

    @Override
    public List<BookingDto> findByRoomId(Long roomId) {
        List<BookingEntity> entities = bookingRepository.findByRoomId(roomId);
        return castToList(entities);
    }

    @Override
    public List<BookingDto> findByCustomerId(Long customerId) {
        List<BookingEntity> entities = bookingRepository.findByCustomerBooking(customerId);
        return castToList(entities);
    }

    @Override
    public List<BookingDto> findAllComplete(Pageable pageable) {
        List<BookingEntity> entities = bookingRepository.findByStatus(1, pageable);
        return castToList(entities);
    }

    @Override
    public List<BookingDto> findAllCheckin(Pageable pageable) {
        List<BookingEntity> entities = bookingRepository.findByStatus(2, pageable);
        return castToList(entities);
    }

    @Override
    public List<BookingDto> findAllCheckout(Pageable pageable) {
        List<BookingEntity> entities = bookingRepository.findByStatus(3, pageable);
        return castToList(entities);
    }

    @Override
    public BookingDto getOne(Long id) {
        return bookingConverter.toDto(bookingRepository.getOne(id));
    }

    @Override
    @Transactional
    public void checkIn(Long id) {
        BookingEntity entity = bookingRepository.getOne(id);
        if(entity.getStatus() == 2) {
            entity.setStatus(3);
            bookingRepository.save(entity);
        }
    }

    @Override
    @Transactional
    public void checkOut(Long id) {
        BookingEntity entity = bookingRepository.getOne(id);
        if(entity.getStatus() == 3) {
            entity.setStatus(1);
        }
        bookingRepository.save(entity);
    }

    public List<BookingDto> castToList(List<BookingEntity> entities) {
        List<BookingDto> results = new ArrayList<>();
        for (BookingEntity entity : entities) {
            BookingDto dto = bookingConverter.toDto(entity);
            results.add(dto);
        }
        return results;
    }
}
