package cn.f33v.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.TableOrderDao;
import cn.f33v.app.entity.TableOrder;
import cn.f33v.app.service.TableOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (TableOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-04-27 19:51:15
 */
@Service("tableOrderService")
public class TableOrderServiceImpl extends ServiceImpl<TableOrderDao, TableOrder> implements TableOrderService {
    @Autowired
    private TableOrderDao tableOrderDao;

    @Override
    public IPage<TableOrder> selectPage(Page<TableOrder> page, String username) {
        return tableOrderDao.selectPage(page, username);
    }

    @Override
    public int saveWithOutId(TableOrder tableOrder) {
        return tableOrderDao.insertWithOutId(tableOrder);
    }
}
