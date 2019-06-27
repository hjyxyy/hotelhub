package com.harrywork.hotelhub.dto.user;

import lombok.Data;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 15:14
 * Desc:
 */
@Data
public class UserBaseParam {

    private String account;

    /**
     * encryption ?
     */
    private String password;
}
