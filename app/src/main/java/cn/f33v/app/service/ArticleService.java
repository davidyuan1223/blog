package cn.f33v.app.service;

import cn.f33v.app.dto.ArchiveDTO;
import cn.f33v.app.dto.ArticleHomeDTO;
import cn.f33v.app.dto.ListArticleDTO;
import cn.f33v.app.vo.SaveOrUpdateArticleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Article;

import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 08:29:17
 */
public interface ArticleService extends IService<Article> {
    int saveOrUpdateArticle(SaveOrUpdateArticleVO articleVO);

    List<ListArticleDTO> getArticleList(Integer current, Integer size, String articleTitle);

    List<ArticleHomeDTO> listArticle(Integer current);

    int deleteArticleById(Integer articleId);

    IPage<ArchiveDTO> listArchives(Integer current);

    SaveOrUpdateArticleVO getArticleById(Integer articleId);
}
