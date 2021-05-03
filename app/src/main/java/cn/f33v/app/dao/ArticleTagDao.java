package cn.f33v.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (ArticleTag)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 21:32:02
 */
@Mapper
@Repository
public interface ArticleTagDao extends BaseMapper<ArticleTag> {

}
