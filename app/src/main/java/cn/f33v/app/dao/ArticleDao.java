package cn.f33v.app.dao;

import cn.f33v.app.dto.ArchiveDTO;
import cn.f33v.app.dto.ArticleHomeDTO;
import cn.f33v.app.dto.ArticlePreviewDTO;
import cn.f33v.app.dto.ListArticleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Article;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 21:05:26
 */
@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {
    List<ListArticleDTO> getArticleList(@Param("current") Integer current, @Param("size") Integer size, @Param("articleTitle") String articleTitle);

    List<ArticleHomeDTO> listArticles(Integer current);

    IPage<ArchiveDTO> listArchives(Page<ArchiveDTO> page);

    IPage<ArticlePreviewDTO> listArticlesByCondition(Page<ArticlePreviewDTO> page, @Param("categoryId") Integer categoryId);

    IPage<ArticlePreviewDTO> listTagsByCondition(Page<ArticlePreviewDTO> page, @Param("tagId") Integer tagId);

}
