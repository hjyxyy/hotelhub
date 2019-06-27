package com.harrywork.hotelhub.dto.booking;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 14:37
 * Desc: BookingReqDTO
 */
@Data
public class BookingReqDTO {
    private Long userId;
    private Long hotelId;
    private String checkin;
    private String checkout;
    // it might query from rds
    private BigDecimal price;
}
