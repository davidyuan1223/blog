package cn.f33v.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.TableOrder;

/**
 * (TableOrder)表服务接口
 *
 * @author makejava
 * @since 2021-04-27 19:51:15
 */
public interface TableOrderService extends IService<TableOrder> {
    IPage<TableOrder> selectPage(Page<TableOrder> page, String username);

    int saveWithOutId(TableOrder tableOrder);
}
