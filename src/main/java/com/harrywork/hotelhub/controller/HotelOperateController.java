package com.harrywork.hotelhub.controller;

import com.harrywork.hotelhub.dto.BaseResponseDTO;
import com.harrywork.hotelhub.dto.booking.BookingReqDTO;
import com.harrywork.hotelhub.service.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 16:39
 * Desc: HotelOperateController
 */
@RestController
@RequestMapping(value = "hotel")
@Api(tags = "Hotel Operation")
@Slf4j
public class HotelOperateController {

    @Autowired
    private HotelService hotelService;

    @GetMapping(value = "test")
    public BaseResponseDTO test() {
        return BaseResponseDTO.OK;
    }

    @GetMapping(value = "search")
    @ApiOperation(value = "", notes = "checkin and checkout must format 'YYYY-MM-DD'")
    public BaseResponseDTO hotelList(@RequestParam(value = "checkin") String checkin,
                                     @RequestParam(value = "checkout") String checkout,
                                     @RequestParam(value = "city", required = false) String city,
                                     @RequestParam(value = "price", required = false) String price) {
//        List<QueryHotelResParam> hotels = hotelService.query(checkin,checkout,city,price);
        try {
            return BaseResponseDTO.OK(hotelService.queryHotels(checkin, checkout, city, price));
        } catch (ParseException e) {
            return BaseResponseDTO.CLIENT_ERROR("checkin or checkout data format error");
        } catch (Exception e) {
            log.error("", e);
            return BaseResponseDTO.FAILED;
        }
    }

    @PostMapping(value = "booking")
    public BaseResponseDTO booking(@RequestBody @ApiParam(value = "bookingdto", required = true) BookingReqDTO dto) {
        try {
            hotelService.booking(dto);
        } catch (IllegalArgumentException e) {
            log.warn("", e);
            return BaseResponseDTO.FAILED(e.getMessage());
        } catch (Exception e) {
            log.error("", e);
            return BaseResponseDTO.FAILED;
        }
        return BaseResponseDTO.OK;
    }
}
