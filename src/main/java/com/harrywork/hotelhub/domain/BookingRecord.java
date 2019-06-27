package com.harrywork.hotelhub.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 15:16
 * Desc: BookingRecord
 */
@Entity
@Data
public class BookingRecord extends BaseModel {

    private Long userId;
    private Long hotelId;
    private String checkin;
    private String checkout;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    private String comment;

}
