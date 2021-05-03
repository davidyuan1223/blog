package cn.f33v.app.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ApiBackDTO {
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
    @ApiModelProperty("父名称")
    private String pName;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("排序")
    private String sort;
    private List<ApiBackDTO> children = new ArrayList<>();
}
