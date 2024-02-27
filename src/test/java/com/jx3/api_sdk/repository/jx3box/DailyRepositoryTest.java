package com.jx3.api_sdk.repository.jx3box;

import com.jx3.api_sdk.BaseTester;
import com.jx3.api_sdk.util.JsonUtil;
import com.jx3.api_sdk.vo.DailyInfo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import java.util.List;

class DailyRepositoryTest extends BaseTester {

    @Resource
    private DailyRepository dailyRepository;

    @Test
    void queryDailyByDate1() {
        List<DailyInfo> dailyInfo = dailyRepository.queryDailyByDate(null);
        System.out.println(JsonUtil.toJson(dailyInfo));
    }

    @Test
    void queryDailyByDate2() {
        List<DailyInfo> dailyInfo = dailyRepository.queryDailyByDate("2024-02-27");
        System.out.println(JsonUtil.toJson(dailyInfo));
    }

    @Test
    void queryDailyByDate3() {
        List<DailyInfo> dailyInfo = dailyRepository.queryDailyByDate("2025-02-27");
        System.out.println(JsonUtil.toJson(dailyInfo));
    }

}