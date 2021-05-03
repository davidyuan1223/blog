package cn.f33v.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListPagDTO {
    private Integer userId;
    private String description;
    private String nickname;
    private String avatar;
    private Date createTime;
    private Date updateTime;
    private Boolean isSilence;
}
