package com.vanhieu.repository;

import com.vanhieu.entity.RoomEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("SELECT r FROM RoomEntity r WHERE r.roomNumber = ?1")
    RoomEntity findByRoomNumber(String roomNumber);

    @Query("SELECT r FROM RoomEntity r WHERE r.status = ?1")
    List<RoomEntity> findByStatus(Integer status, Pageable pageable);

    @Query("SELECT r FROM RoomEntity r WHERE r.categoryOfRoom.code = ?1 AND r.status = ?2")
    List<RoomEntity> findByCategoryCode(String categoryCode,Integer status, Pageable pageable);

    @Query("SELECT r FROM RoomEntity r, BookingEntity b WHERE r.categoryOfRoom.id = ?1 AND b.bookingRoom.id = r.id " +
            "AND (( b.startStayDay >= ?2 AND b.startStayDay <= ?3 ) " +
            "OR ( b.lastStayDay >= ?2 AND b.lastStayDay <= ?3 ) ) group by r" )
    List<RoomEntity> getRoomAvailable(Long categoryId, Date startDay, Date lastDay);

    @Query("SELECT r FROM RoomEntity r WHERE r.categoryOfRoom.id = ?1")
    List<RoomEntity> findByCategoryId(Long categoryId);
}
