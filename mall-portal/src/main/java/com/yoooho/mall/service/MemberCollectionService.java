package com.yoooho.mall.service;



import com.yoooho.mall.domain.MemberProductCollection;

import java.util.List;

/**
 * 会员收藏Service
 * Created by yoooho on 2019/8/2.
 */
public interface MemberCollectionService {
    int addProduct(MemberProductCollection productCollection);

    int deleteProduct(Long productId);

    List<MemberProductCollection> listProduct();
}
