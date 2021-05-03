package cn.f33v.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.TableOrder;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * (TableOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-27 19:51:15
 */
@Mapper
@Repository
public interface TableOrderDao extends BaseMapper<TableOrder> {
    IPage<TableOrder> selectPage(Page<?> page, @Param("username") String username);

    int insertWithOutId(TableOrder tableOrder);
}
