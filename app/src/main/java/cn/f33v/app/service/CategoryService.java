package cn.f33v.app.service;

import cn.f33v.app.dto.ArticlePreviewDTO;
import cn.f33v.app.dto.ArticlePreviewListDTO;
import cn.f33v.app.dto.CategoryDTO;
import cn.f33v.app.vo.AddOrEditCategoryVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Category;

import java.util.List;

/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 08:32:12
 */
public interface CategoryService extends IService<Category> {
    List<CategoryDTO> listCategories();

    ArticlePreviewListDTO listArticlesByCategoryId(Integer categoryId, Integer current);

    boolean addOrEditCategory(AddOrEditCategoryVO addOrEditCategoryVO);

    void deleteCategoryById(Integer categoryId);

}
