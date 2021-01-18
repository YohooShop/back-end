package com.yoooho.mall.dao;

import com.yoooho.mall.domain.UmsMemberWX;

import java.util.List;

public interface  MemberCoustomDao {

    List<UmsMemberWX> select(String open_id);

    void  insert(UmsMemberWX memberWX);
}
