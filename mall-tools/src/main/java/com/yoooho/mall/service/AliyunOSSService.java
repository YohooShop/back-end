package com.yoooho.mall.service;

import com.yoooho.mall.domian.AliyunOssContent;
import com.yoooho.mall.domian.AliyunossConfig;
import com.yoooho.mall.service.dto.AliyunOssQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface AliyunOSSService {
    public Object  find();
    public Object update(AliyunossConfig aliyunossConfig);
    public Object upload(MultipartFile file, AliyunossConfig aliyunossConfig) throws IOException;
    public Object queryAll(AliyunOssQueryCriteria criteria, Pageable pageabl);

    /**
     * 同步数据
     * @param config 配置
     */
    Object synchronize(AliyunossConfig config);

    List<AliyunOssContent> queryAll(AliyunOssQueryCriteria criteria);

    void downloadList(List<AliyunOssContent> queryAll, HttpServletResponse response);
    /**
     * 查询文件
     * @param id 文件ID
     * @return AliyunOssContent
     */
    AliyunOssContent findByContentId(Long id);

    /**
     * 下载文件
     * @param content 文件信息
     * @param config 配置
     * @return String
     */
    String download(AliyunOssContent  content, AliyunossConfig config);

    /**
     * 删除文件
     * @param content 文件
     * @param config 配置
     */
    void delete(AliyunOssContent  content, AliyunossConfig config);

    /**
     * 删除文件
     * @param ids 文件ID数组
     * @param config 配置
     */
    void deleteAll(Long[] ids, AliyunossConfig config);

    void uploadByte(byte[] content, AliyunossConfig config ,String name);


}
