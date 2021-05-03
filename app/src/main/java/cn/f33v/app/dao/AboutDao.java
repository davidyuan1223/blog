package cn.f33v.app.dao;

import cn.f33v.app.dto.AboutDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
@Mapper
public interface AboutDao {
    AboutDTO getAbout();

    int updateAbout(@Param("aboutContent") String aboutContent);
}
