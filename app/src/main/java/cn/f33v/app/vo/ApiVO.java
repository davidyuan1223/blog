package cn.f33v.app.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class ApiVO {
    @TableId(value = "api_id", type = IdType.AUTO)
    @ApiModelProperty("apiId")
    private Integer apiId;
    @ApiModelProperty("api")
    private String name;
    @ApiModelProperty("请求地址")
    private String url;
    @ApiModelProperty("请求方式")
    private String method;
    @ApiModelProperty("父id")
    private Integer pid;
    @ApiModelProperty("描述")
    private String description;
}
