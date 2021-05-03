package cn.f33v.app.controller;

import cn.f33v.app.dto.ArchiveDTO;
import cn.f33v.app.dto.ArticleHomeDTO;
import cn.f33v.app.dto.ListArticleDTO;
import cn.f33v.app.entity.Article;
import cn.f33v.app.service.impl.ArticleServiceImpl;
import cn.f33v.app.vo.SaveOrUpdateArticleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@Api(tags = "文章模块")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @ApiOperation("保存或更新文章")
    @PostMapping("/article/saveOrUpdateArticle")
    public Result saveOrUpdateArticle(@RequestBody SaveOrUpdateArticleVO saveOrUpdateArticleVO) {
        if (saveOrUpdateArticleVO != null) {
            articleService.saveOrUpdateArticle(saveOrUpdateArticleVO);
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("根据文章标题分页查询文章列表")
    @GetMapping("/article/listArticle")
    public Result listArticle(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                              @RequestParam(value = "size", required = true, defaultValue = "5") Integer size,
                              @RequestParam(value = "articleTitle", required = false) String articleTitle) {
        //获取这个数据,但是还要拿到总条数
        List<ListArticleDTO> data = articleService.getArticleList(current, size, articleTitle);
        int total = articleService.count();
        return Result.ok().data("data", data).data("total", total);
    }

    @ApiOperation("查看首页文章")
    @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "Integer")
    @GetMapping("/article/articles")
    public Result listArticles(Integer current) {
        List<ArticleHomeDTO> data = articleService.listArticle(current);
        return Result.ok().data("data", data);
    }

    @ApiOperation("查看首页文章中的某篇文章")
    @GetMapping("/articles/{articleId}")
    public Result getArticleById(@PathVariable("articleId") Integer articleId) {
        Article article = articleService.getById(articleId);
        return Result.ok().data("data", article);
    }

    @ApiOperation("根据id删除文章")
    @DeleteMapping("/article/deleteArticleById")
    public Result deleteArticleById(Integer articleId) {
        int i = articleService.deleteArticleById(articleId);
        return Result.ok();
    }

    @ApiOperation("查询文章归档")
    @GetMapping("/articles/archives")
    public Result listArchives(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current) {
        IPage<ArchiveDTO> archiveDTOIPage = articleService.listArchives(current);
        List<ArchiveDTO> data = archiveDTOIPage.getRecords();
        int count = (int) archiveDTOIPage.getTotal();
        return Result.ok().data("data", data).data("count", count);
    }

    @ApiOperation("根据文章id查询文章信息")
    @GetMapping("/article/getArticleById")
    public Result getArticleByArticleId(@RequestParam(value = "articleId", required = true, defaultValue = "null") Integer articleId) {
        SaveOrUpdateArticleVO saveOrUpdateArticleVO = articleService.getArticleById(articleId);
        return Result.ok().data("data", saveOrUpdateArticleVO);
    }
}
