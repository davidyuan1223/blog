package cn.f33v.app.result;

/**
 * @author Administrator
 */
public interface IResult {
    /**
     * 获得响应码
     *
     * @return 响应码
     */
    Integer getCode();

    /**
     * 获得消息
     *
     * @return 消息
     */
    String getMessage();
}
