package cn.f33v.app.service;

import cn.f33v.app.dto.ArticlePreviewListDTO;
import cn.f33v.app.dto.TagDTO;
import cn.f33v.app.vo.AddOrEditTagVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Tag;

import java.util.List;

/**
 * (Tag)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 16:24:09
 */
public interface TagService extends IService<Tag> {
    List<TagDTO> listTagDTO();

    ArticlePreviewListDTO listTagByTagId(Integer tagId, Integer current);

    boolean addOrEditTag(AddOrEditTagVO addOrEditTagVO);

    boolean deleteTag(Integer tagId);
}
