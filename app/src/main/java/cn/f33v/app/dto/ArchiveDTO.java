package cn.f33v.app.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class ArchiveDTO {
    private Integer id;
    private String articleTitle;
    private Date createTime;
}
