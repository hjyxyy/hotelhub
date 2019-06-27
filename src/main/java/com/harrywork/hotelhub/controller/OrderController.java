package com.harrywork.hotelhub.controller;

import com.harrywork.hotelhub.dto.BaseResponseDTO;
import com.harrywork.hotelhub.service.HotelService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 14:57
 * Desc: OrderController
 */
@RestController
@RequestMapping(value = "order")
@Api(tags = "Order Operation")
@Slf4j
public class OrderController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("list/all")
    public BaseResponseDTO list(@RequestParam(value = "userId") Long userId) {

        try {
            return BaseResponseDTO.OK(hotelService.queryBookings(userId));
        } catch (Exception e) {
            log.error("", e);
            return BaseResponseDTO.FAILED;
        }
    }

    @PutMapping("{bookingId}/cancel")
    public BaseResponseDTO cancel(@PathVariable Long bookingId){
        hotelService.cancel(bookingId);
        return BaseResponseDTO.OK;
    }
}
