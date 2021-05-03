package cn.f33v.app.controller;

import cn.f33v.app.dao.TagDao;
import cn.f33v.app.dto.ArticlePreviewListDTO;
import cn.f33v.app.dto.PageDTO;
import cn.f33v.app.dto.TagDTO;
import cn.f33v.app.entity.Tag;
import cn.f33v.app.service.impl.TagServiceImpl;
import cn.f33v.app.vo.AddOrEditTagVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
@RestController
@Api("标签模块")
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagServiceImpl tagService;

    @Autowired
    private TagDao tagDao;

    @ApiOperation("后台获取所有标签")
    @GetMapping("/getTagList")
    public Result getTagList() {
        List<Tag> tags = tagService.list();
        return Result.ok().data("data", tags);
    }

    @ApiOperation("后台分页条件查询标签列表")
    @GetMapping("/listTags")
    public Result listTags(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                           @RequestParam(value = "size", required = true, defaultValue = "5") Integer size,
                           @RequestParam(value = "tagName", required = false) String tagName) {
        Page<Tag> page = new Page<>(current, size);
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        if (tagName != null && !Objects.equals(tagName, "")) {
            wrapper.like("tag_name", tagName);
        }
        Page<Tag> tagPage = tagService.page(page, wrapper);
        long total = tagPage.getTotal();
        List<Tag> data = tagPage.getRecords();
        return Result.ok().data("data", data).data("total", total);
    }

    @ApiOperation("博客查看标签列表")
    @GetMapping("/tags")
    public Result tags() {
        List<TagDTO> data = tagService.listTagDTO();
        int count = tagService.count();
        return Result.ok().data("data", data).data("count", count);
    }

    @ApiOperation("查看标签下对应文章")
    @GetMapping("/{tagId}")
    public Result listArticlesByTagId(@PathVariable(value = "tagId") Integer tagId, Integer current) {
        ArticlePreviewListDTO data = tagService.listTagByTagId(tagId, current);
        return Result.ok().data("data", data);
    }

    @ApiOperation("新增或编辑标签")
    @PostMapping("/addOrEditTag")
    public Result addOrEditTag(@RequestBody AddOrEditTagVO addOrEditTagVO) {
        if (tagService.addOrEditTag(addOrEditTagVO)) {
            return Result.ok();
        }
        return Result.error();
    }

    @ApiOperation("根据id删除标签")
    @DeleteMapping("/deleteTag")
    public Result deleteTag(Integer tagId) {
        if (tagService.deleteTag(tagId)) {
            return Result.ok();
        }
        return Result.error();
    }
}
