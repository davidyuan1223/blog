package cn.f33v.app.service.impl;

import cn.f33v.app.dao.ArticleDao;
import cn.f33v.app.dto.ArticlePreviewDTO;
import cn.f33v.app.dto.ArticlePreviewListDTO;
import cn.f33v.app.dto.CategoryDTO;
import cn.f33v.app.vo.AddOrEditCategoryVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.CategoryDao;
import cn.f33v.app.entity.Category;
import cn.f33v.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 08:32:12
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<CategoryDTO> listCategories() {
        return this.baseMapper.listCategories();
    }

    @Override
    public ArticlePreviewListDTO listArticlesByCategoryId(Integer categoryId, Integer current) {
        //转换页码
        Page<ArticlePreviewDTO> page = new Page<>(current, 9);
        IPage<ArticlePreviewDTO> articles = articleDao.listArticlesByCondition(page, categoryId);
        List<ArticlePreviewDTO> records = articles.getRecords();
        return new ArticlePreviewListDTO(records, null);
    }

    @Override
    public boolean addOrEditCategory(AddOrEditCategoryVO addOrEditCategoryVO) {
        if (addOrEditCategoryVO == null) {
            throw new RuntimeException();
        }
        Integer categoryId = addOrEditCategoryVO.getCategoryId();
        Category category = new Category();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(date);
        category.setCategoryName(addOrEditCategoryVO.getCategoryName());
        if (categoryId != null) {
            //说明这是编辑博客,需要给一个更新时间
            category.setId(categoryId);
            category.setUpdateTime(date);
        } else {
            //说明是新增标签
            category.setCreateTime(date);
        }
        return this.saveOrUpdate(category);
    }

    @Override
    public void deleteCategoryById(Integer categoryId) {
        this.removeById(categoryId);
    }
}
