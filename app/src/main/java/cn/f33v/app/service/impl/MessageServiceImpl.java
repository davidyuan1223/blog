package cn.f33v.app.service.impl;

import cn.f33v.app.utils.IpUtil;
import cn.f33v.app.vo.MessageVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.MessageDao;
import cn.f33v.app.entity.Message;
import cn.f33v.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 08:32:15
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {
    @Resource
    private HttpServletRequest request;

    @Override
    public void saveMessage(MessageVO messageVO) {
        String ipAddr = IpUtil.getIp(request);
        String ipSource = IpUtil.getIpSource(ipAddr);
        Message message = new Message();
        message.setAvatar(messageVO.getAvatar());
        message.setNickname(messageVO.getNickname());
        message.setCreateTime(new Date());
        message.setMessageContent(messageVO.getMessageContent());
        message.setIpAddress(ipAddr);
        message.setIpSource(ipSource);
        message.setTime(messageVO.getTime());
        this.baseMapper.insert(message);
    }

    @Override
    public IPage<Message> getMessageList(Integer current, Integer size, String nickname) {
        Page<Message> page = null;
        if (current == null || size == null) {
            current = 1;
            size = 999;
        }
        page = new Page<>(current, size);
        QueryWrapper<Message> wrapper = null;
        if (nickname != null) {
            assert wrapper != null;
            wrapper.like("nickname", nickname);
        }
        return this.baseMapper.selectPage(page, wrapper);
    }
}
