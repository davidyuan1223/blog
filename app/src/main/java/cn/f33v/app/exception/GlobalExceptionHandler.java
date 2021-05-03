package cn.f33v.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.f33v.app.result.Result;

/**
 * @author Administrator
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result err(Exception e) {
        log.error(e.toString());
        e.printStackTrace();
        return Result.error();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result err1(BusinessException e) {
        log.error(e.getErrMsg());
        return Result.error().code(e.getCode()).message(e.getMessage());
    }
}
