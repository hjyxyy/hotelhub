package com.harrywork.hotelhub.service.impl;

import com.harrywork.hotelhub.domain.AppUser;
import com.harrywork.hotelhub.domain.UserType;
import com.harrywork.hotelhub.dto.user.LoginResParam;
import com.harrywork.hotelhub.dto.user.UserBaseParam;
import com.harrywork.hotelhub.dto.user.UserRegistReqDTO;
import com.harrywork.hotelhub.repositories.AppUserDao;
import com.harrywork.hotelhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 15:26
 * Desc: UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserDao userDao;

    @Transactional
    @Override
    public void register(UserRegistReqDTO dto) {
        AppUser user = userDao.findByAccount(dto.getAccount());
        if (user != null) {
            throw new IllegalArgumentException("already exist");
        }

        user = new AppUser();
        user.setAccount(dto.getAccount());
        user.setPassword(dto.getPassword());
        user.setType(UserType.CUSTOMER);
        user.setStatus(0);
        userDao.save(user);
    }

    @Override
    public LoginResParam login(UserBaseParam param) {
        return null;
    }
}
