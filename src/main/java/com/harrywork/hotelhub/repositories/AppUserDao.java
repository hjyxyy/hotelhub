package com.harrywork.hotelhub.repositories;

import com.harrywork.hotelhub.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 15:10
 * Desc: AppUserDao
 */
public interface AppUserDao extends JpaRepository<AppUser, Long> {
    AppUser findByAccount(String account);
}
