package cn.f33v.app.dao;

import cn.f33v.app.dto.MenuDTO;
import cn.f33v.app.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:05:39
 */
@Mapper
@Repository
public interface MenuDao extends BaseMapper<Menu> {
    List<MenuDTO> listProduct();

}

