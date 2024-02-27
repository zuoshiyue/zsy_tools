package com.jx3.api_sdk.service;

import com.jx3.api_sdk.BaseTester;
import com.jx3.api_sdk.util.JsonUtil;
import com.jx3.api_sdk.vo.HorseDTO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HorseServiceTest extends BaseTester {

    @Resource
    private HorseService horseService;
    @Test
    void queryHorseInfo() {
        List<HorseDTO> list = horseService.queryHorseInfo("梦江南");
        System.out.println(JsonUtil.toJson(list));
    }
}