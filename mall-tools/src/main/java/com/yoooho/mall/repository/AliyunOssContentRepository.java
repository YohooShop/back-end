package com.yoooho.mall.repository;

import com.yoooho.mall.domian.AliyunOssContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AliyunOssContentRepository extends JpaRepository<AliyunOssContent, Long> , JpaSpecificationExecutor<AliyunOssContent> {
    /**
     * 根据url查询
     * @param url 文件名
     * @return AliyunOssContent
     */
   List <AliyunOssContent> findByUrl(String url);

    /**
     * 根据url查询
     * @param bucket 文件名
     * @return AliyunOssContent
     */
    List <AliyunOssContent>  findByBucket(String bucket);

}
