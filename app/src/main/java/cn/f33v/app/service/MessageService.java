package cn.f33v.app.service;

import cn.f33v.app.vo.MessageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Message;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 08:32:15
 */
public interface MessageService extends IService<Message> {
    void saveMessage(MessageVO messageVO);

    IPage<Message> getMessageList(Integer current, Integer size, String nickname);

}
