package cn.f33v.app.dao;

import cn.f33v.app.dto.CategoryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Category)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 21:33:09
 */
@Mapper
@Repository
public interface CategoryDao extends BaseMapper<Category> {
    List<CategoryDTO> listCategories();
}
