package cn.f33v.app.entity;

import cn.f33v.app.vo.SaveOrUpdateArticleVO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2021-04-24 16:48:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Article对象", description = "文章实体类")
@TableName("article")
public class Article implements Serializable {
    private static final long serialVersionUID = -28435917411123739L;
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

    public Article(SaveOrUpdateArticleVO articleVO) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
        this.articleId = articleVO.getArticleId();
        this.categoryId = articleVO.getCategoryId();
        this.articleCover = articleVO.getArticleCover();
        this.articleTitle = articleVO.getArticleTitle();
        this.articleContent = articleVO.getArticleContent();
        this.createTime = this.articleId == null ? date : null;
        this.updateTime = this.articleContent != null ? date : null;
        this.isTop = articleVO.getIsTop();
        this.isDraft = articleVO.getIsDraft();
    }

}
