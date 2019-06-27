package com.harrywork.hotelhub.controller;

import com.google.common.collect.Maps;
import com.harrywork.hotelhub.dto.BaseResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

/**
 * @author Harry
 * @date 19-6-27
 * Time: 16:25
 * Desc: HotelControllerTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSearch() {
        String url = "/hotel/search?checkin={checkin}&checkout={checkout}&city={city}&price={price}";

        //condition 1
        Map param = Maps.newHashMap();
        param.put("checkin", "2019-06-27");
        param.put("checkout", "2019-06-28");

        param.put("city", "shanghai");
        param.put("price", 100);
        BaseResponseDTO baseResponseDTO1 = restTemplate.getForObject(url,BaseResponseDTO.class,param);
        assertTrue(2000 == baseResponseDTO1.getCode(),"");

        //condition 2
        Map param2 = Maps.newHashMap();
        param2.put("checkin", "2019-06-27");
        param2.put("checkout", "2019-06-28");

        param2.put("city", "shanghai");
        param2.put("price", 200);
        BaseResponseDTO baseResponseDTO2 = restTemplate.getForObject(url,BaseResponseDTO.class,param2);
        assertTrue(2000 == baseResponseDTO2.getCode(),"");

        //condition 3
        Map param3 = Maps.newHashMap();
        param3.put("checkin", "2019-06-27");
        param3.put("checkout", "2019-06-28");

        param3.put("city", "");
        param3.put("price", 100);

        BaseResponseDTO baseResponseDTO3 = restTemplate.getForObject(url,BaseResponseDTO.class,param3);
        assertTrue(2000 == baseResponseDTO3.getCode(),"");

        //condition 4
        Map param4 = Maps.newHashMap();
        param4.put("checkin", "2019-06-27");
        param4.put("checkout", "2019-06-28");

        param4.put("city", "shanghai");
        param4.put("price", "");

        BaseResponseDTO baseResponseDTO4 = restTemplate.getForObject(url,BaseResponseDTO.class,param4);
        assertTrue(2000 == baseResponseDTO4.getCode(),"");

        //condition 5
        Map param5 = Maps.newHashMap();
        param5.put("checkin", "2019-06-27");
        param5.put("checkout", "2019-0628");

        param5.put("city", "shanghai");
        param5.put("price", 100);

        BaseResponseDTO baseResponseDTO5 = restTemplate.getForObject(url,BaseResponseDTO.class,param5);
        assertTrue(4000 == baseResponseDTO5.getCode(),"");

        //condition 6
        // ...
    }
}
