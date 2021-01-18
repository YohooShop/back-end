package com.yoooho.mall.service;

import com.yoooho.mall.domain.MemberSignData;

import java.util.List;

public interface UmsMemberSignService {

     List<MemberSignData> getMemberSignData(String dStr);
     boolean sign();
     int signContinueDay();
}
