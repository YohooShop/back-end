package com.yoooho.mall.service.impl;

import com.yoooho.mall.domain.MemberReadHistory;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.repository.MemberReadHistoryRepository;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员浏览记录管理Service实现类
 * Created by yoooho on 2019/8/3.
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;
    @Autowired
    private UmsMemberService memberService;
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        UmsMember currentMember =memberService.getCurrentMember();
        if (currentMember == null){
            return 0;
        }
        memberReadHistory.setMemberId(currentMember.getId());
        memberReadHistory.setMemberNickname(currentMember.getNickname());
        memberReadHistory.setMemberIcon(currentMember.getIcon());
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> deleteList = new ArrayList<>();
        for(String id:ids){
            MemberReadHistory memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            deleteList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        Sort sort =  new Sort(Sort.Direction.DESC, "createTime");
        MemberReadHistory memberReadHistory = new MemberReadHistory();
        memberReadHistory.setMemberId(memberId);
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example< MemberReadHistory> example = Example.of(memberReadHistory, matcher);
        PageRequest pageable = new PageRequest(0, 10, sort);
        Page<MemberReadHistory> page= memberReadHistoryRepository.findAll(example, pageable);
        return page.getContent();
    }
}
