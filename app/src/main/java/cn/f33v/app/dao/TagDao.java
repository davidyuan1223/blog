package cn.f33v.app.dao;

import cn.f33v.app.dto.TagDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Tag)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:25:13
 */
@Mapper
@Repository
public interface TagDao extends BaseMapper<Tag> {
    List<TagDTO> listTagDTO();
}
