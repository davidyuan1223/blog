package cn.f33v.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.FriendLink;

/**
 * (FriendLink)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 08:32:14
 */
public interface FriendLinkService extends IService<FriendLink> {
    boolean addOrEditFriendLink(FriendLink friendLink);

    IPage<FriendLink> pageLinks(Integer current, Integer size, String keywords);
}
