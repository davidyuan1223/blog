package cn.f33v.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.FriendLinkDao;
import cn.f33v.app.entity.FriendLink;
import cn.f33v.app.service.FriendLinkService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * (FriendLink)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 08:32:14
 */
@Service("friendLinkService")
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkDao, FriendLink> implements FriendLinkService {

    @Override
    public boolean addOrEditFriendLink(FriendLink friendLink) {
        Integer id = friendLink.getId();
        //如果是新增
        if (id == null) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(date);
            friendLink.setCreateTime(date);
        }
        return this.saveOrUpdate(friendLink);
    }

    @Override
    public IPage<FriendLink> pageLinks(Integer current, Integer size, String keywords) {
        Page<FriendLink> page = new Page<>(current, size);
        QueryWrapper<FriendLink> wrapper = null;
        if (keywords != null && !Objects.equals(keywords, "")) {
            wrapper = new QueryWrapper<>();
            wrapper.like("link_name", keywords);
        }
        return this.page(page, wrapper);
    }
}
