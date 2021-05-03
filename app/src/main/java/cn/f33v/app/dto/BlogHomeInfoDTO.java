package cn.f33v.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
public class BlogHomeInfoDTO {
    private String nickname;
    private String avatar;
    private String intro;
    private Integer articleCount;
    private Integer categoryCount;
    private Integer tagCount;
    private String notice;
    private String viewCount;


}
