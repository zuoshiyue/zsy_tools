package com.jx3.api_sdk.repository.jx3box;

import com.jx3.api_sdk.BaseTester;
import com.jx3.api_sdk.emun.HorseTypeEnum;
import com.jx3.api_sdk.util.JsonUtil;
import com.jx3.api_sdk.vo.HorseInfo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

class HorseRepositoryTest extends BaseTester {

    @Resource
    private HorseRepository horseRepository;
    @Test
    void queryHorse() {
        HorseInfo horseInfo = horseRepository.queryHorse(1, 50, "幽月轮", HorseTypeEnum.UNIVERSAL.getType(), "");
        System.out.println(JsonUtil.toJson(horseInfo));
    }
}