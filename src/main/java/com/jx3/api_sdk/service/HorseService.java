package com.jx3.api_sdk.service;

import com.jx3.api_sdk.emun.HorseSubTypeEnum;
import com.jx3.api_sdk.emun.HorseTypeEnum;
import com.jx3.api_sdk.exception.StatusCodeException;
import com.jx3.api_sdk.repository.jx3box.HorseRepository;
import com.jx3.api_sdk.util.Safes;
import com.jx3.api_sdk.vo.HorseDTO;
import com.jx3.api_sdk.vo.HorseInfo;
import com.jx3.api_sdk.vo.Status;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class HorseService {
    @Resource
    private HorseRepository horseRepository;

    public List<HorseDTO> queryHorseInfo(String server) {
        if (StringUtils.isBlank(server)) {
            throw new StatusCodeException(Status.error("获取马场信息，服务器不能为空"));
        }
        //todo 服务器名称判断

        HorseInfo horseInfo = horseRepository.queryHorse(1, 50, server, HorseTypeEnum.UNIVERSAL.getType(), "");
        if (Objects.isNull(horseInfo)) {
            return Collections.emptyList();
        }
        return Safes.of(horseInfo.getList()).stream()
                .filter(Objects::nonNull)
                .map(v -> {
                    Long time = v.getTime();
                    String content = v.getContent();
                    String subtype = v.getSubtype();
                    List<String> contentList =  this.formatContent(subtype, content);

                    return HorseDTO.builder()
                            .id(v.getId())
                            .mapId(v.getMapId())
                            .mapName(v.getMapName())
                            .time(time)
                            .subtype(subtype)
                            .content(contentList)
//                            .startDate()
//                            .endDate()
                            .build();
                }).collect(Collectors.toList());
    }

    /**
     * 文案解析方法
     * @param subtype 当前喊话类型
     * @param content 当前喊话内容
     * @return 解析后内容
     */
    private List<String> formatContent(String subtype, String content) {
        if (HorseSubTypeEnum.FORESHOW.getType().equalsIgnoreCase(subtype)){
            //江湖快马飞报！段氏马场发布最新《九州寻驹图》消息：约五到十分钟后，将有宝马良驹在巴陵县出没！各位侠士可以前往捕捉！切莫错过！
            return Collections.singletonList(content);
        } else if (HorseSubTypeEnum.NPC_CHAT.getType().equalsIgnoreCase(subtype)){
            //当前马场内没有龙子/麟驹的马驹。\n下一匹龙子/麟驹即将出世！\n\n当前马场内没有绝尘/闪电/赤蛇的马驹。\n距离下一匹绝尘/闪电/赤蛇出世时间尚久，无法预知。\n\n当前马场内没有里飞沙的马驹。\n距离下一匹里飞沙出世时间尚久，无法预知。\n\n当前马场内没有赤兔的马驹。\n距离下一匹赤兔出世时间尚久，无法预知。\n\n
            List<String> contentList = Arrays.stream(content.split("\\r?\\n"))
                    .filter(StringUtils::isNotBlank)
                    .filter(v -> v.startsWith("距离"))
                    .collect(Collectors.toList());
            return contentList;
        } else if (HorseSubTypeEnum.SHARE_MSG.getType().equalsIgnoreCase(subtype)){
            //地图][杨新]大声喊：赤兔马已到达半月湖附近，有志于征服赤兔的侠士可速速赶去！
            return Collections.singletonList(content);
        }
        throw new StatusCodeException(Status.error("获取马场信息，未匹配到有效的喊话解析方法"));
    }
}
