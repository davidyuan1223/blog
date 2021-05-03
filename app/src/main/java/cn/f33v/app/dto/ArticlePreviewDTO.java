package cn.f33v.app.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ArticlePreviewDTO {
    private Integer id;
    private String articleCover;
    private String articleTitle;
    private Date createTime;
    private Integer categoryId;
    private String categoryName;
    private List<TagDTO> tagDTOList;
}
