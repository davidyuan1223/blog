package cn.f33v.app.service.impl;

import cn.f33v.app.dto.MenuDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.MenuDao;
import cn.f33v.app.entity.Menu;
import cn.f33v.app.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 08:32:14
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Override
    public List<MenuDTO> listProduct() {
        List<MenuDTO> menuDTOS = this.baseMapper.listProduct();
        if (menuDTOS != null) {
            return menuDTOS;
        } else {
            return null;
        }
    }
}
