package com.harrywork.hotelhub.controller;

import com.harrywork.hotelhub.dto.BaseResponseDTO;
import com.harrywork.hotelhub.dto.user.LoginResParam;
import com.harrywork.hotelhub.dto.user.UserBaseParam;
import com.harrywork.hotelhub.dto.user.UserRegistReqDTO;
import com.harrywork.hotelhub.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 15:10
 * Desc: UserController
 */
@RestController
@RequestMapping(value = "user")
@Api(tags = "User Operation")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public BaseResponseDTO register(@RequestBody @ApiParam(value = "regist") UserRegistReqDTO dto) {
        try {
            userService.register(dto);
        } catch (Exception e) {
            log.error("", e);
            return BaseResponseDTO.FAILED;
        }
        return BaseResponseDTO.OK;
    }


    @PostMapping(value = "login")
    public BaseResponseDTO login(@RequestBody @ApiParam(value = "login") UserBaseParam dto) {
        try {
            return BaseResponseDTO.OK(userService.login(dto));
        } catch (Exception e) {
            log.error("", e);
            return BaseResponseDTO.FAILED;
        }
    }
}
