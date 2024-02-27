package com.jx3.api_sdk.emun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HorseTypeEnum {
    /**
     *
     */
    UNIVERSAL("horse","普通"),

    RED_RABBIT("chitu-horse","赤兔"),
            ;

    private String type;

    private String desc;
}
