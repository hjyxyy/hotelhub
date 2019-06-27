package com.harrywork.hotelhub.repositories;

import com.harrywork.hotelhub.domain.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 14:51
 * Desc: BookingRecordDao
 */
public interface BookingRecordDao extends JpaRepository<BookingRecord, Long> {
    List<BookingRecord> findByUserId(Long userId);

    List<BookingRecord> findByUserIdAndHotelId(Long userId, Long hotelId);
}
