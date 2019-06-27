package com.harrywork.hotelhub.domain;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 15:23
 * Desc: UserType
 */
public enum UserType {
    CUSTOMER("customer"),
    OWNER("owner");

    private String type;

    private UserType(String type){
        this.type = type;
    }
}
