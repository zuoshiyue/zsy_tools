package com.jx3.api_sdk.repository.jx3box;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jx3.api_sdk.util.HttpClientUtil;
import com.jx3.api_sdk.util.JsonUtil;
import com.jx3.api_sdk.vo.HorseInfo;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Repository
public class HorseRepository {


    /**
     * 获取马场相关信息
     * @param pageIndex 页码
     * @param pageSize 每页条数
     * @param server 服务器名称
     * @return 马场数据列表
     */
    public HorseInfo queryHorse(Integer pageIndex, Integer pageSize, String server, String type, String subtype) {
        if (Objects.isNull(pageIndex) || pageIndex <= 0) {
            pageIndex = 1;
        }
        if (Objects.isNull(pageSize) || pageSize <= 0) {
            pageSize = 50;
        }
        String url = "https://next2.jx3box.com/api/game/reporter/horse";
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        params.put("pageIndex", String.valueOf(pageIndex));
        params.put("pageSize", String.valueOf(pageSize));
        params.put("server", server);
        params.put("type", type);
        params.put("subtype", subtype);
        String result = HttpClientUtil.get(url, params, headers, false);
        if (StringUtils.isBlank(result)) {
            log.error("马场数据返回为空");
        }
        JSONObject responseJson = JSON.parseObject(result);
        int code = responseJson.getIntValue("code");
        String data = responseJson.getString("data");
        if (code != 0) {
            log.warn("马场数据返回 响应异常, request:{}, response:{}", params, result);
            return null;
        }

        return JsonUtil.of(data, HorseInfo.class);
    }
}
