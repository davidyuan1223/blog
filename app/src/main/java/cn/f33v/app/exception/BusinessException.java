package cn.f33v.app.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("错误实体")
public class BusinessException extends RuntimeException {
    @ApiModelProperty("错误码")
    private Integer code;
    @ApiModelProperty("错误信息")
    private String errMsg;

    public BusinessException(String errMsg) {
        this.errMsg = errMsg;
    }
}
