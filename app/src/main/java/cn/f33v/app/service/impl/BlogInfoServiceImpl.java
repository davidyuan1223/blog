package cn.f33v.app.service.impl;

import cn.f33v.app.dao.ArticleDao;
import cn.f33v.app.dao.CategoryDao;
import cn.f33v.app.dao.TagDao;
import cn.f33v.app.dao.UserDao;
import cn.f33v.app.dto.BlogHomeInfoDTO;
import cn.f33v.app.entity.User;
import cn.f33v.app.service.BlogInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private TagDao tagDao;


    @Override
    public BlogHomeInfoDTO getBlogHomeInfo() {
        //昵称,头像,简介,公告,文章数量,分类数量,标签数量,公告,访问量
        //公告先写死,访问量后面再弄
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("nickname", "avatar", "intro").eq("username", "admin");
        User user = userDao.selectOne(queryWrapper);
        //获取文章数量
        Integer articleCount = articleDao.selectCount(null);
        //分类数量
        Integer categoryCount = categoryDao.selectCount(null);
        //标签数量
        Integer tagCount = tagDao.selectCount(null);
        //公告
        String notice = "this is a notice";
        return new BlogHomeInfoDTO(
                user.getNickname(),
                user.getAvatar(),
                user.getIntro(),
                articleCount,
                categoryCount,
                tagCount,
                notice,
                null);
    }
}
