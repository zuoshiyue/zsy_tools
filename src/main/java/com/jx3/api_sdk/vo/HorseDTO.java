package com.jx3.api_sdk.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HorseDTO {
    private Integer id;
    private Integer mapId ;
    private Long time;
    private String mapName;
    private String subtype;
    private List<String> content;
    private String startDate;
    private String endDate;

}
