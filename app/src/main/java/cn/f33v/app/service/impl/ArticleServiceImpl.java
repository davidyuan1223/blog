package cn.f33v.app.service.impl;

import cn.f33v.app.dto.ArchiveDTO;
import cn.f33v.app.dto.ArticleHomeDTO;
import cn.f33v.app.dto.ListArticleDTO;
import cn.f33v.app.entity.ArticleTag;
import cn.f33v.app.entity.Comment;
import cn.f33v.app.utils.HtmlUtil;
import cn.f33v.app.vo.SaveOrUpdateArticleVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.ArticleDao;
import cn.f33v.app.entity.Article;
import cn.f33v.app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 08:29:17
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Autowired
    private ArticleTagServiceImpl articleTagService;
    @Autowired
    private CommentServiceImpl commentService;


    @Override
    public int saveOrUpdateArticle(SaveOrUpdateArticleVO articleVO) {
        Integer articleId = articleVO.getArticleId();
        Article article = new Article(articleVO);
        if (articleId != null && !articleVO.getIsDraft()) {
            QueryWrapper<ArticleTag> wrapper = new QueryWrapper<>();
            wrapper.eq("article_id", article);
            articleTagService.remove(wrapper);
        }
        saveOrUpdate(article);
        List<Integer> tagIdList = articleVO.getTagIdList();
        ArrayList<ArticleTag> articleTags = new ArrayList<>();
        ArticleTag articleTag;
        for (Integer tagId : tagIdList) {
            articleTag = new ArticleTag(tagId, article.getArticleId());
            articleTags.add(articleTag);
        }
        boolean b1 = articleTagService.saveBatch(articleTags);
        return 1;
    }

    @Override
    public List<ListArticleDTO> getArticleList(Integer current, Integer size, String articleTitle) {
        return this.baseMapper.getArticleList((current - 1) * size, size, articleTitle);
    }

    @Override
    public List<ArticleHomeDTO> listArticle(Integer current) {
        List<ArticleHomeDTO> articleHomeDTOS = this.baseMapper.listArticles((current - 1) * 10);
        for (ArticleHomeDTO articleHomeDTO : articleHomeDTOS) {
            articleHomeDTO.setArticleContent(HtmlUtil.deleteArticleTag(articleHomeDTO.getArticleContent()));
        }
        return articleHomeDTOS;
    }

    @Override
    public int deleteArticleById(Integer articleId) {
        int i = this.baseMapper.deleteById(articleId);
        QueryWrapper<ArticleTag> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", articleId);
        int delete = articleTagService.getBaseMapper().delete(wrapper);
        QueryWrapper<Comment> wrapper1 = new QueryWrapper<>();
        wrapper.eq("article_id", articleId);
        boolean remove = commentService.remove(wrapper1);
        return delete;
    }

    @Override
    public IPage<ArchiveDTO> listArchives(Integer current) {
        Page<ArchiveDTO> page = new Page<>(current, 10);
        return this.baseMapper.listArchives(page);
    }

    @Override
    public SaveOrUpdateArticleVO getArticleById(Integer articleId) {
        //获取当前文章信息
        Article article = getById(articleId);
        //获取当前文章的标签列表Id信息
        QueryWrapper<ArticleTag> wrapper = new QueryWrapper<>();
        wrapper.eq("article_id", article);
        List<ArticleTag> articleTags = articleTagService.list(wrapper);
        List<Integer> tagsId = new ArrayList<>();
        for (ArticleTag articleTag : articleTags) {
            tagsId.add(articleTag.getTagId());
        }
        return new SaveOrUpdateArticleVO(article.getArticleId()
                , article.getArticleTitle(), article.getArticleContent(), article.getArticleCover(), article.getCategoryId(), article.getIsTop(), article.getIsDraft(), tagsId);
    }
}
