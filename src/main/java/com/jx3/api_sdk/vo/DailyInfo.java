package com.jx3.api_sdk.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyInfo {

    private Integer id;
    @JsonProperty("task_type")
    private String taskType;
    @JsonProperty("activity_name")
    private String activityName;
    @JsonProperty("created_at")
    private String createdAt;
}
