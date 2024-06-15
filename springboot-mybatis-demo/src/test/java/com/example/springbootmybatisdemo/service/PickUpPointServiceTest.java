package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.dto.Response;
import com.example.springbootmybatisdemo.exception.InvalidPhoneNumberException;
import com.example.springbootmybatisdemo.exception.InvalidCityException;
import com.example.springbootmybatisdemo.mapper.PickUpPointMapper;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointInfoParam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PickUpPointServiceTest {

    @Autowired
    private PickUpPointService pickUpPointService;

    @MockBean
    private PickUpPointMapper pickUpPointMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePickUpPoint() {
        PickUpPointParam param = new PickUpPointParam();
        PickUpPointInfoParam infoParam = new PickUpPointInfoParam();
        infoParam.setCity("Guangzhou");
        infoParam.setPhoneNumber("12345678901");
        param.setPickUpPointInfoParam(infoParam);

        when(pickUpPointMapper.createPickUpPoint(any(PickUpPointParam.class))).thenReturn(true);
        Response<Boolean> response = pickUpPointService.createPickUpPoint(param);
        assertEquals(200, response.getCode());
        assertEquals("Success", response.getMsg());
        assertEquals(true, response.getData());
    }
    @Test
    void testCreatePickUpPointWithInvalidPhoneNumber() {
        PickUpPointParam param = new PickUpPointParam();
        PickUpPointInfoParam infoParam = new PickUpPointInfoParam();
        infoParam.setCity("Guangzhou");
        infoParam.setPhoneNumber("110"); // 错误的电话号码
        param.setPickUpPointInfoParam(infoParam);


        assertThrows(InvalidPhoneNumberException.class, () -> {
            pickUpPointService.createPickUpPoint(param);
        });
    }

    @Test
    void testCreatePickUpPointWithInvalidCity() {
        PickUpPointParam param = new PickUpPointParam();
        PickUpPointInfoParam infoParam = new PickUpPointInfoParam();
        infoParam.setCity(""); // 错误的城市名称
        infoParam.setPhoneNumber("12345678901");
        param.setPickUpPointInfoParam(infoParam);

        assertThrows(InvalidCityException.class, () -> {
            pickUpPointService.createPickUpPoint(param);
        });
    }
}

