package com.harrywork.hotelhub.service;

import com.harrywork.hotelhub.HotelhubApplication;
import com.harrywork.hotelhub.dto.user.UserRegistReqDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.Random;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 16:54
 * Desc: UserServiceTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HotelhubApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    @Transactional
    public void testRegister() {
        UserRegistReqDTO dto = new UserRegistReqDTO();
        dto.setAccount(UUID.randomUUID().toString());
        dto.setPassword(UUID.randomUUID().toString());
        userService.register(dto);
        assertTrue(true, "");
    }
}
