package com.vaia.constant;

/**
 * Created by nicholas.chi on 2018/4/16.
 */
public enum RetMessageEnum {
    /**
     * 操作成功
     */
    SUCCESS("00000", "operation_succeeded", ServerConstant.RET_STATUS_SUCCESS),
    /**
     * 操作失败
     */
    FAILUE("00001", "operation_failed"),
    /**
     * session超时
     */
    SESSION_TIMEOUT("00002", "session_timeout",ServerConstant.RET_STATUS_SESSION),
    /**
     * 参数为空
     */
    PARAMETER_IS_EMPTY("00003", "parameter_is_empty"),

    /**
     * 找不到对象
     * */
    CAN_NOT_FIND_OBJECT("10000","Can_not_find_object")


    ;


    private String code;
    private String message;
    private String status = ServerConstant.RET_STATUS_FAILURE;

    private RetMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private RetMessageEnum(String code, String message, String status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
