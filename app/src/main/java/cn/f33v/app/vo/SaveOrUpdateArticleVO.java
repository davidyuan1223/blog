package cn.f33v.app.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel("文章视图传输实体")
public class SaveOrUpdateArticleVO {
    /**
     * 文章主键id
     */
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer articleId;
    /**
     * 文章标题
     */
    @ApiModelProperty("文章标题")
    private String articleTitle;
    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    private String articleContent;
    /**
     * 文章封面
     */
    @ApiModelProperty("文章封面")
    private String articleCover;
    /**
     * 分类id
     */
    @ApiModelProperty("分类id")
    private Integer categoryId;
    /**
     * 是否置顶,0:不置顶,1:置顶
     */
    @ApiModelProperty("是否置顶,0:不置顶,1:置顶")
    private Boolean isTop;
    /**
     * 是否草稿.0:不是草稿,1:是草稿
     */
    @ApiModelProperty("是否草稿.0:不是草稿,1:是草稿")
    private Boolean isDraft;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("标签列表")
    private List<Integer> tagIdList;

    public SaveOrUpdateArticleVO(Integer articleId, String articleTitle, String articleContent, String articleCover, Integer categoryId, Boolean isTop, Boolean isDraft, List<Integer> tagIdList) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleCover = articleCover;
        this.categoryId = categoryId;
        this.isTop = isTop;
        this.isDraft = isDraft;
        this.tagIdList = tagIdList;
    }
}
