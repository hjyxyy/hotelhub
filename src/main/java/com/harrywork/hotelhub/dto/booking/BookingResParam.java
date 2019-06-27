package com.harrywork.hotelhub.dto.booking;

import com.harrywork.hotelhub.domain.BookingStatus;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 15:04
 * Desc: BookingResParam
 */
@Data
public class BookingResParam {
    private Long bookingId;
    private Long userId;
    private Long hotelId;
    private String checkin;
    private String checkout;
    private BigDecimal price;
    private BookingStatus status;
    private String comment;
}
