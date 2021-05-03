package cn.f33v.app.controller;

import cn.f33v.app.dto.ArticlePreviewListDTO;
import cn.f33v.app.dto.CategoryDTO;
import cn.f33v.app.entity.Category;
import cn.f33v.app.service.impl.CategoryServiceImpl;
import cn.f33v.app.vo.AddOrEditCategoryVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/category")
@Api("分类模块")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @ApiOperation("获取所有分类")
    @GetMapping("/getCategories")
    public Result getTagList() {

        if (redisTemplate.opsForValue().get("categories") != null) {
            return Result.ok().data("data", redisTemplate.opsForValue().get("categories"));
        } else {
            List<Category> categoryList = categoryService.list();
            redisTemplate.opsForValue().set("categories", categoryList);
            return Result.ok().data("data", categoryList);
        }


    }

    @ApiOperation("分页条件查询分类列表")
    @GetMapping("/listCategory")
    public Result listTag(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                          @RequestParam(value = "size", required = true, defaultValue = "5") Integer size,
                          @RequestParam(value = "categoryName", required = false) String categoryName) {
        Page<Category> page = new Page<>(current, size);
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if (categoryName != null && !Objects.equals(categoryName, "")) {
            wrapper.like("category_name", categoryName);
        }
        Page<Category> tagPage = categoryService.page(page, wrapper);
        long total = tagPage.getTotal();
        List<Category> data = tagPage.getRecords();
        return Result.ok().data("data", data).data("total", total);
    }

    @ApiOperation("查看博客展示分类列表")
    @GetMapping("/listCategories")
    public Result listCategories() {
        List<CategoryDTO> data = categoryService.listCategories();
        Integer count = categoryService.getBaseMapper().selectCount(null);
        return Result.ok().data("data", data).data("count", count);
    }

    @ApiOperation("查看分类下对应的文章")
    @GetMapping("/{categoryId}")
    public Result listArticleByCategoryId(@PathVariable(value = "categoryId") Integer categoryId, Integer current) {
        ArticlePreviewListDTO data = categoryService.listArticlesByCategoryId(categoryId, current);
        return Result.ok().data("data", data);
    }

    @ApiOperation("新增或编辑分类")
    @PostMapping("/addOrEditCategory")
    public Result addOrEditCategory(@RequestBody AddOrEditCategoryVO addOrEditCategoryVO) {
        if (categoryService.addOrEditCategory(addOrEditCategoryVO)) {
            return Result.ok();
        }
        return Result.error().message("更新失败");
    }

    @ApiOperation("根据id删除分类")
    @DeleteMapping("/deleteCategory}")
    public Result deleteCategory(Integer categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return Result.ok();
    }
}
