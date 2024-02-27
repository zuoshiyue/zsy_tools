package com.jx3.api_sdk.repository.jx3box;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jx3.api_sdk.util.DateTimeUtil;
import com.jx3.api_sdk.util.HttpClientUtil;
import com.jx3.api_sdk.util.JsonUtil;
import com.jx3.api_sdk.vo.DailyInfo;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class DailyRepository {


    /**
     * 根据日期获取今日日常活动
     *
     * @param date yyyy-MM-dd 格式日期字符串，为空时默认系统时间
     * @return 今日活动信息
     */
    public List<DailyInfo> queryDailyByDate(String date) {
        if (StringUtils.isBlank(date)) {
            date = DateTimeUtil.format(new Date(), "yyyy-MM-dd");
        }
        String url = "https://cms.jx3box.com/api/cms/game/daily";
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        params.put("date", date);
        String result = HttpClientUtil.get(url, params, headers, false);
        if (StringUtils.isBlank(result)) {
            log.error("日常请求返回数据为空");
        }
        JSONObject responseJson = JSON.parseObject(result);
        int code = responseJson.getIntValue("code");
        String data = responseJson.getString("data");
        if (code != 0) {
            log.warn("根据日期获取今日日常活动 响应异常, date:{}, response:{}", date, result);
            return Collections.emptyList();
        }

        return JsonUtil.ofList(data, DailyInfo.class);
    }
}
