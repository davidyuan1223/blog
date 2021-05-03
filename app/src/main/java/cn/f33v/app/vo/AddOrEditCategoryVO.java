package cn.f33v.app.vo;

import lombok.*;

/**
 * @author yuan
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddOrEditCategoryVO {
    private Integer categoryId;
    private String categoryName;
}
