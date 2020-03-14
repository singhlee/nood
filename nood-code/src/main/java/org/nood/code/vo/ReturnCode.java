package org.nood.code.vo;

public enum ReturnCode {
    SUCCESS("成功","00000"),
    FAILURE("失败","50000"),
    PARAM_FAIL("参数错误","50001"),
    SYSTEM_FAIL("系统错误","50002"),
    USER_NEED_AUTHORITIES("用户未登录","50101"),
    USER_LOGIN_FAILED("用户账号或密码错误","50102"),
    USER_NO_ACCESS("用户无权访问","50103"),
    TOKEN_IS_BLACKLIST("此token为黑名单","50104"),
    LOGIN_IS_OVERDUE("登录已失效","50105");
    private String value;
    private String code;

    private ReturnCode(String value, String code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
