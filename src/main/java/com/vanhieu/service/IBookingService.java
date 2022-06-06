package com.vanhieu.service;

import com.vanhieu.dto.BookingDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookingService {

    int count();
    int countCheckin();
    int countCheckout();
    int countComplete();
    BookingDto save(BookingDto bookingDto);
    BookingDto update(BookingDto billDto);
    void delete(Long[] ids);
    List<BookingDto> findAll(Pageable pageable);
    List<BookingDto> findByRoomId(Long roomId);
    List<BookingDto> findByCustomerId(Long customerId);
    List<BookingDto> findAllComplete(Pageable pageable);
    List<BookingDto> findAllCheckin(Pageable pageable);
    List<BookingDto> findAllCheckout(Pageable pageable);
    BookingDto getOne(Long id);
    void checkIn(Long id);
    void checkOut(Long id);
}
