package cn.f33v.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (ArticleTag)实体类
 *
 * @author makejava
 * @since 2021-04-24 16:58:11
 */
@Data
@TableName("article_tag")
@ApiModel(value = "Article Tag 实体对象", description = "文章标签关联类")
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = -18839831003356737L;
    @ApiModelProperty("article 和 tag 关联的主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("标签Id")
    private Integer tagId;
    @ApiModelProperty("文章Id")
    private Integer articleId;

    public ArticleTag(Integer tagId, Integer articleId) {
        this.tagId = tagId;
        this.articleId = articleId;
    }
}
