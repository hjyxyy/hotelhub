package com.harrywork.hotelhub.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 10:32
 * Desc: HotelInfo
 */
@Entity
@Data
public class HotelInfo extends BaseModel {

    @Column(nullable = false)
    private String name;
    private String logourl;
    private String linkurl;
    private String city;
    @Column(columnDefinition = "DECIMAL")
    /**
     * price for one night
     */
    private BigDecimal price;
    /**
     * display or not
     */
    private Boolean available;
}
