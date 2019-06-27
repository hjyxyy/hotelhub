package com.harrywork.hotelhub.repositories;

import com.harrywork.hotelhub.domain.HotelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 16:00
 * Desc: HotelInfoDao
 */
public interface HotelInfoDao extends JpaRepository<HotelInfo, Long> {
}
