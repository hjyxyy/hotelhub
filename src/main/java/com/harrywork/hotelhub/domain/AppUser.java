package com.harrywork.hotelhub.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Harry
 * @date 19-6-26
 * Time: 15:22
 * Desc: AppUser
 */
@Entity
@Data
public class AppUser extends BaseModel {
    private String account;
    private String password;
    private String profile;
    @Enumerated(EnumType.ORDINAL)
    private UserType type;
    @Column(columnDefinition = "int not null comment '0 normal 1 pause 2 deleted'")
    private Integer status;
}
