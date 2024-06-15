package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.dto.Response;
import com.example.springbootmybatisdemo.exception.InvalidCityException;
import com.example.springbootmybatisdemo.exception.InvalidPhoneNumberException;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointInfoParam;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
import com.example.springbootmybatisdemo.service.PickUpPointService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PickUpPointController.class)
public class PickUpPointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PickUpPointService pickUpPointService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePickUpPoint() throws Exception {
        // 准备测试参数
        PickUpPointParam param = new PickUpPointParam();
        PickUpPointInfoParam infoParam = new PickUpPointInfoParam();
        infoParam.setCity("Guangzhou");
        infoParam.setPhoneNumber("12345678901");
        param.setPickUpPointInfoParam(infoParam);

        // 模拟service行为
        when(pickUpPointService.createPickUpPoint(any(PickUpPointParam.class))).thenReturn(new Response<>(200, "Success", "some-trace-id", true));

        // 执行HTTP请求并验证结果
        mockMvc.perform(post("/api/pickUpPoints/createPickUpPoint")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new Response<>(200, "Success", "some-trace-id", true))));
    }
}
