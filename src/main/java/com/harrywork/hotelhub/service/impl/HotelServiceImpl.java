package com.harrywork.hotelhub.service.impl;

import com.harrywork.hotelhub.domain.BookingRecord;
import com.harrywork.hotelhub.domain.BookingStatus;
import com.harrywork.hotelhub.dto.booking.BookingReqDTO;
import com.harrywork.hotelhub.dto.hotel.QueryHotelResParam;
import com.harrywork.hotelhub.repositories.BookingRecordDao;
import com.harrywork.hotelhub.repositories.HotelInfoDao;
import com.harrywork.hotelhub.service.HotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.harrywork.hotelhub.util.DateUtil.getLenthOfStay;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 17:11
 * Desc: HotelServiceImpl
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelInfoDao hotelInfoDao;
    @Autowired
    private BookingRecordDao bookingRecordDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @param checkin
     * @param checkout
     * @param city
     * @param price
     * @return
     * @throws ParseException checkin or checkout date format error
     */
    @Override
    public List<QueryHotelResParam> queryHotels(String checkin, String checkout, String city, String price) throws ParseException {

        int los = getLenthOfStay(checkin, checkout);

        String sql = buildSql(city, price, los);
//        List<HotelInfo> hotelList = jdbcTemplate.queryForList(sql, HotelInfo.class);

        List<QueryHotelResParam> hotelList = jdbcTemplate.query(sql, (rs, i) -> {
            BigDecimal price1 = rs.getBigDecimal("price");
            int multiplier = rs.getInt("multiplier");
            QueryHotelResParam param = QueryHotelResParam.builder()
                    .hotelId(rs.getLong("id"))
                    .hotelName(rs.getString("name"))
                    .logourl(rs.getString("logourl"))
                    .linkurl(rs.getString("linkurl"))
                    .price(price1.multiply(new BigDecimal(multiplier)))
                    .build();
            return param;
        });
        return hotelList;
    }

    @Override
    public void booking(BookingReqDTO dto) {
        // checking logic ...

        // simple check

        List<BookingRecord> records = bookingRecordDao.findByUserIdAndHotelId(dto.getUserId(), dto.getHotelId());
        List<BookingRecord> bookings = records.stream().filter(booking -> booking.getStatus().equals(BookingStatus.NewOrder)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(bookings)) {
            // already booking the same
            throw new IllegalArgumentException("the room already booking");
        }
        BookingRecord bookingRecord = new BookingRecord();
        bookingRecord.setUserId(dto.getUserId());
        bookingRecord.setHotelId(dto.getHotelId());
        bookingRecord.setCheckin(dto.getCheckin());
        bookingRecord.setCheckout(dto.getCheckout());
        bookingRecord.setPrice(dto.getPrice());
        bookingRecord.setStatus(BookingStatus.NewOrder);
        bookingRecordDao.save(bookingRecord);
    }

    @Override
    public List<BookingRecord> queryBookings(Long userId) {
        return bookingRecordDao.findByUserId(userId);
    }

    /**
     * there need cancel protocol
     *
     * @param bookingId
     */
    @Transactional
    @Override
    public void cancel(Long bookingId) {
        Optional<BookingRecord> record = bookingRecordDao.findById(bookingId);
        BookingRecord bookingRecord = record.get();
        if (bookingRecord != null) {
            // cancel protocol
            // ...
            bookingRecord.setStatus(BookingStatus.Cancelled);
            // bookingRecordDao.save(bookingRecord);
        } else {
            //...
        }
    }

    public String buildSql(String city, String price, int los) {
        StringBuilder stringBuilder = new StringBuilder("select hi.id,hi.name,hi.logourl,hi.linkurl,hi.price,bm.multiplier from hotel_info hi" +
                " left join bidding_multiplier bm on hi.id = bm.hotel_id where hi.available = 1");
        // add conditions
        stringBuilder.append(" and bm.los = ");
        stringBuilder.append(los);
        if (StringUtils.isNotBlank(city)) {
            stringBuilder.append(" and hi.city = '");
            stringBuilder.append(city);
            stringBuilder.append("'");
        }
        if (StringUtils.isNotBlank(price)) {
            stringBuilder.append(" and hi.price = ");
            stringBuilder.append(price);
        }
        return stringBuilder.toString();
    }
}
