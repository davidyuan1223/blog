package cn.f33v.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.TableServerDao;
import cn.f33v.app.entity.TableServer;
import cn.f33v.app.service.TableServerService;
import org.springframework.stereotype.Service;

/**
 * (TableServer)表服务实现类
 *
 * @author makejava
 * @since 2021-04-27 19:51:16
 */
@Service("tableServerService")
public class TableServerServiceImpl extends ServiceImpl<TableServerDao, TableServer> implements TableServerService {

}
