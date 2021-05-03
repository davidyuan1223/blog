package cn.f33v.app.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class MenuDTO {
    private Integer menuId;
    private String userRole;
    private String menuName;
    private String menuUrl;
    private String parentId;
    private Integer sort;
    private String description;
    private String menuIcon;
    private List<MenuDTO> children;
}
