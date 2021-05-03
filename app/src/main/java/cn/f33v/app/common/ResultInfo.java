package cn.f33v.app.common;

import cn.f33v.app.result.IResult;

/**
 * @author Administrator
 */

public enum ResultInfo implements IResult {
    /**
     * 结果信息
     * code: 返回码
     * message: 相关信息
     */
    SUCCESS(200, "操作成功"),
    ERROR(400, "操作失败"),
    NOT_FOUND(404, "没有找到"),
    UPDATE_ERROR(678, "更新失败"),
    UPDATE_SUCCESS(679, "更新成功"),
    NO_DATA_FOUND(999, "没有找到相关数据"),
    LOGIN_SUCCESS(123, "登录成功"),
    LOGIN_FAILED(1232, "用户名或密码错误哦"),
    VERIFY_SUCCESS(756, "登录验证成功"),
    VERIFY_FAILED(885, "登录验证失败"),
    ;
    private Integer code;
    private String message;

    ResultInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
