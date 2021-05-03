package cn.f33v.app.service;

import cn.f33v.app.dto.MenuDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Menu;

import java.util.List;

/**
 * (Menu)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 08:32:14
 */
public interface MenuService extends IService<Menu> {
    List<MenuDTO> listProduct();
}
