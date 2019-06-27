package com.harrywork.hotelhub.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 15:07
 * Desc: BiddingMultiplier
 */
@Entity
@Data
public class BiddingMultiplier extends BaseModel {

    private Long hotelId;

    /**
     * length of stay
     */
    private Integer los;

    /**
     * final price = price * multiplier
     *
     * @see HotelInfo#price
     */
    private BigDecimal multiplier;

}
