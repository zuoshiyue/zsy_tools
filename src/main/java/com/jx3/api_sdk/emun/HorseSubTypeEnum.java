package com.jx3.api_sdk.emun;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HorseSubTypeEnum {
    /**
     *
     */
    FORESHOW("foreshow","普通马匹到达喊话"),
    NPC_CHAT("npc_chat","马匹预告喊话"),
    SHARE_MSG("share_msg", "赤兔到达喊话"),
    ;
    private String type;
    private String desc;
}
