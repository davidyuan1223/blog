package cn.f33v.app.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class UrlRoleDTO {
    private Integer id;
    private String url;
    private String requestMethod;
    private List<String> roleList;
    private Integer isAnonymous;
}
