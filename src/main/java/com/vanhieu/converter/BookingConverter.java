package com.vanhieu.converter;

import com.vanhieu.dto.BookingDto;
import com.vanhieu.dto.CustomerDto;
import com.vanhieu.dto.RoomDto;
import com.vanhieu.entity.BookingEntity;
import com.vanhieu.entity.CustomerEntity;
import com.vanhieu.entity.RoomEntity;
import com.vanhieu.repository.RoomRepository;
import com.vanhieu.service.impl.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingConverter {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private RoomConverter roomConverter;

    @Autowired
    private RoomRepository roomRepository;

    public BookingDto toDto(BookingEntity entity) {
        BookingDto bookingDto = mapper.map(entity, BookingDto.class);
        CustomerDto customer = customerConverter.toDto(entity.getCustomerBooking());
        RoomDto room = roomConverter.toDto(entity.getBookingRoom());
        bookingDto.setCustomerBooking(customer);
        bookingDto.setBookingRoom(room);
        return bookingDto;
    }

    public BookingEntity toEntity(BookingDto bookingDto) {
        BookingEntity bookingEntity = mapper.map(bookingDto, BookingEntity.class);
        CustomerEntity customer = customerConverter.toEntity(bookingDto.getCustomerBooking());
        bookingEntity.setCustomerBooking(customer);
        bookingEntity.setBookingRoom(roomRepository.getOne(bookingDto.getRoomId()));
        return bookingEntity;
    }

    public BookingEntity toEntity(BookingEntity bookingEntity, BookingDto bookingDto) {
        CustomerEntity customer = bookingEntity.getCustomerBooking();
        RoomEntity room = bookingEntity.getBookingRoom();
        bookingEntity = mapper.map(bookingDto, BookingEntity.class);
        bookingEntity.setCustomerBooking(customer);
        bookingEntity.setBookingRoom(room);
        return bookingEntity;
    }
}
