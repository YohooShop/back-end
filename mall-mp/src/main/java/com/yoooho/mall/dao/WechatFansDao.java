package com.yoooho.mall.dao;




import com.yoooho.mall.model.WechatFans;

import java.util.List;
import java.util.Map;

public interface WechatFansDao {

    List<WechatFans> selectFans(Map params);


}
