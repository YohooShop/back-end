package com.yoooho.mall.service;

import com.yoooho.mall.dto.UmsMemberQueryParam;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface UmsMemberService {
    Map<String, Object> queryAll(UmsMemberQueryParam criteria, Pageable pageable);
}
