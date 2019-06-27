package com.harrywork.hotelhub.dto.hotel;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 18:45
 * Desc: QueryHotelResParam
 */
@Data
@Builder
public class QueryHotelResParam {
    private Long hotelId;
    private String hotelName;
    private BigDecimal price;
    private String logourl;
    private String linkurl;
}
