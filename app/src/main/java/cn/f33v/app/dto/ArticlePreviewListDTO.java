package cn.f33v.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePreviewListDTO {
    private List<ArticlePreviewDTO> articlePreviewDTOList;
    private String name;

}
