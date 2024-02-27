package com.jx3.api_sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorseInfo {

    private List<ListDTO> list;
    private PageDTO page;

    @NoArgsConstructor
    @Data
    public static class PageDTO {
        private Integer index;
        private Integer pageSize;
        private Integer total;
        private Integer pageTotal;
    }

    @NoArgsConstructor
    @Data
    public static class ListDTO {
        private Integer id;
        private String lang;
        private String edition;
        private String server;
        private String content;
        private Long time;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("report_count")
        private Integer reportCount;
        private Integer status;
        private String type;
        private String subtype;
        @JsonProperty("map_id")
        private Integer mapId;
        @JsonProperty("map_name")
        private String mapName;
    }
}
