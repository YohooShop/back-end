package com.yoooho.mall.service;

import com.yoooho.mall.model.WechatMsg;

import java.util.List;
import java.util.Map;

public interface WechatMsgSevice {

    List<WechatMsg>  queryPage(Map<String, Object> params);

    /**
     * 保存消息到数据库（会先添加到队列，再使用定时任务写入）
     * @param log
     */
    void addWxMsg(WechatMsg log);

   WechatMsg getById(long id);
   void removeByIds(List<Long> ids);
}
