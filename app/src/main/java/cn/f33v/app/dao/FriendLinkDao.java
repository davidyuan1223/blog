package cn.f33v.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (FriendLink)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:04:51
 */
@Mapper
@Repository
public interface FriendLinkDao extends BaseMapper<FriendLink> {

}
