package com.harrywork.hotelhub.service;

import com.harrywork.hotelhub.domain.BookingRecord;
import com.harrywork.hotelhub.dto.booking.BookingReqDTO;
import com.harrywork.hotelhub.dto.hotel.QueryHotelResParam;

import java.text.ParseException;
import java.util.List;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 17:10
 * Desc: HotelService
 */
public interface HotelService {
    List<QueryHotelResParam> queryHotels(String checkin, String checkout, String city, String price) throws ParseException;

    void booking(BookingReqDTO dto);

    List<BookingRecord>  queryBookings(Long userId);

    void cancel(Long bookingId);
}
