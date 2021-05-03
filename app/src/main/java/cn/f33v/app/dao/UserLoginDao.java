package cn.f33v.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (UserLogin)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:25:13
 */
@Mapper
@Repository
public interface UserLoginDao extends BaseMapper<UserLogin> {

}
