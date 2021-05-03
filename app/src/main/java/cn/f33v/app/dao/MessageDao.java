package cn.f33v.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Message)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:19:28
 */
@Mapper
@Repository
public interface MessageDao extends BaseMapper<Message> {

}
