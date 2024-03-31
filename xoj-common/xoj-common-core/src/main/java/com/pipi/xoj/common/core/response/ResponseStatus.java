package com.pipi.xoj.common.core.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    ACCESS_DENIED(401, "访问受限"),
    FORBIDDEN(403, "拒绝访问"),
    NOT_FOUND(404, "数据不存在"),
    AUTH_CODE_EXCEPTION(420, "验证码发送频率过高"),
    DATA_VERIFICATION_FAILS(421, "数据校验不通过"),
    SYSTEM_ERROR(500, "系统内部异常");

    private final int status;
    private final String description;
}
