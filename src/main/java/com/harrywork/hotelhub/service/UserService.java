package com.harrywork.hotelhub.service;

import com.harrywork.hotelhub.dto.user.LoginResParam;
import com.harrywork.hotelhub.dto.user.UserBaseParam;
import com.harrywork.hotelhub.dto.user.UserRegistReqDTO;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 15:11
 * Desc: UserService
 */
public interface UserService {
    void register(UserRegistReqDTO dto);

    LoginResParam login(UserBaseParam param);
}
