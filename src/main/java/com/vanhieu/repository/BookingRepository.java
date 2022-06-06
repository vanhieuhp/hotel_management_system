package com.vanhieu.repository;

import com.vanhieu.entity.BookingEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query("SELECT b FROM BookingEntity b WHERE b.customerBooking.id = ?1")
    List<BookingEntity> findByCustomerBooking(Long customerId);

    @Query("SELECT b FROM BookingEntity b WHERE b.status = ?1")
    List<BookingEntity> findByStatus(Integer status, Pageable pageable);

    @Query("SELECT b FROM BookingEntity b WHERE b.bookingRoom.id = ?1")
    List<BookingEntity> findByRoomId(Long roomId);

    @Query("SELECT count(b) FROM BookingEntity b WHERE b.status = ?1")
    int countByStatus(Integer status);

}
