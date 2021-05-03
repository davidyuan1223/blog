package cn.f33v.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.TableCustomerDao;
import cn.f33v.app.entity.TableCustomer;
import cn.f33v.app.service.TableCustomerService;
import org.springframework.stereotype.Service;

/**
 * (TableCustomer)表服务实现类
 *
 * @author makejava
 * @since 2021-04-27 19:51:15
 */
@Service("tableCustomerService")
public class TableCustomerServiceImpl extends ServiceImpl<TableCustomerDao, TableCustomer> implements TableCustomerService {

}
