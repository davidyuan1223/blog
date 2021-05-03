package cn.f33v.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListArticleDTO {
    private Integer articleId;
    private String articleTitle;
    private String categoryName;
    private List<String> tagsName;
    private Date createTime;
    private Date updateTime;
    private Boolean isTop;
}
