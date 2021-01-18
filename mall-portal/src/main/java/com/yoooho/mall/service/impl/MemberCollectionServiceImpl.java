package com.yoooho.mall.service.impl;

import com.yoooho.mall.model.UmsMember;

import com.yoooho.mall.domain.MemberProductCollection;
import com.yoooho.mall.repository.MemberProductCollectionRepository;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.service.MemberCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 会员收藏Service实现类
 * Created by yoooho on 2019/8/2.
 */
@Service
public class MemberCollectionServiceImpl implements MemberCollectionService {
    @Autowired
    private MemberProductCollectionRepository productCollectionRepository;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public int addProduct(MemberProductCollection productCollection) {
        int count = 0;

        MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(productCollection.getMemberId(), productCollection.getProductId());
        if (findCollection == null) {
            UmsMember member = memberService.getCurrentMember();
            productCollection.setMemberId(member.getId());
            productCollection.setMemberIcon(member.getIcon());
            productCollection.setMemberNickname(member.getNickname());
            productCollection.setCreateTime(new Date());
            productCollectionRepository.save(productCollection);
            count = 1;
        }
        return count;
    }

    @Override
    public int deleteProduct(Long productId) {
        UmsMember member = memberService.getCurrentMember();
        Long memberId = member.getId();
        return productCollectionRepository.deleteByMemberIdAndProductId(memberId, productId);
    }

    @Override
    public List<MemberProductCollection> listProduct() {
        UmsMember member = memberService.getCurrentMember();
        return productCollectionRepository.findByMemberId(member.getId());
    }
}
