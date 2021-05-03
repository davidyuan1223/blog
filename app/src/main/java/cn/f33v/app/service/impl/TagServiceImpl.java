package cn.f33v.app.service.impl;

import cn.f33v.app.dao.ArticleDao;
import cn.f33v.app.dao.ArticleTagDao;
import cn.f33v.app.dto.ArticlePreviewDTO;
import cn.f33v.app.dto.ArticlePreviewListDTO;
import cn.f33v.app.dto.TagDTO;
import cn.f33v.app.entity.ArticleTag;
import cn.f33v.app.vo.AddOrEditTagVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.TagDao;
import cn.f33v.app.entity.Tag;
import cn.f33v.app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 16:24:10
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleTagDao articleTagDao;

    @Override
    public List<TagDTO> listTagDTO() {
        return this.baseMapper.listTagDTO();
    }

    @Override
    public ArticlePreviewListDTO listTagByTagId(Integer tagId, Integer current) {
        //转换页码
        Page<ArticlePreviewDTO> page = new Page<>(current, 9);
        IPage<ArticlePreviewDTO> articles = articleDao.listArticlesByCondition(page, tagId);
        List<ArticlePreviewDTO> records = articles.getRecords();
        return new ArticlePreviewListDTO(records, null);
    }

    @Override
    public boolean addOrEditTag(AddOrEditTagVO addOrEditTagVO) {
        if (addOrEditTagVO == null) {
            throw new RuntimeException();
        }
        Integer tagId = addOrEditTagVO.getTagId();
        Tag tag = new Tag();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(date);
        tag.setTagName(addOrEditTagVO.getTagName());
        if (tagId != null) {
            tag.setId(tagId);
            tag.setUpdateTime(date);
        } else {
            tag.setCreateTime(date);
        }
        return this.saveOrUpdate(tag);
    }

    @Override
    public boolean deleteTag(Integer tagId) {
        //先删除这个标签列表
        boolean b = this.removeById(tagId);
        QueryWrapper<ArticleTag> wrapper = new QueryWrapper<>();
        wrapper.eq("tag_id", tagId);
        int delete = articleTagDao.delete(wrapper);
        return b;
    }
}
