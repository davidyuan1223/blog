package cn.f33v.app.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ArticleHomeDTO {
    private Integer articleId;
    private String articleCover;
    private String articleTitle;
    private String articleContent;
    private Date createTime;
    private Boolean isTop;
    private Integer categoryId;
    private String categoryName;
    private List<TagDTO> tagDTOList;
}
