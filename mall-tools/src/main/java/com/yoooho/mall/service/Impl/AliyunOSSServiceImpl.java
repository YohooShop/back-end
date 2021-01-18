package com.yoooho.mall.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.PutObjectRequest;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.domian.AliyunOssContent;
import com.yoooho.mall.common.utils.FileUtil;
import com.yoooho.mall.repository.AliyunOssContentRepository;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.exception.BadRequestException;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.domian.AliyunossConfig;
import com.yoooho.mall.repository.AliyunossRepository;
import com.yoooho.mall.service.AliyunOSSService;
import com.yoooho.mall.service.dto.AliyunOssQueryCriteria;
import com.yoooho.mall.utils.AliyunOSSUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@SuppressWarnings("all")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AliyunOSSServiceImpl implements AliyunOSSService {
    private final AliyunossRepository aliyunossRepository;
    private final AliyunOssContentRepository aliyunOssContentRepository;
    public  AliyunOSSServiceImpl( AliyunossRepository aliyunossRepository, AliyunOssContentRepository aliyunOssContentRepository) {
        this.aliyunossRepository = aliyunossRepository;
        this.aliyunOssContentRepository = aliyunOssContentRepository;
    }
    @Override
    @Cacheable(key = "'1'")
    public Object find() {
        Optional<AliyunossConfig> alipayConfig = aliyunossRepository.findById(1L);
        return alipayConfig.orElseGet(AliyunossConfig::new);
    }

    @Override
    @CachePut(key = "'1'")
    @Transactional(rollbackFor = Exception.class)
    public Object update(AliyunossConfig aliyunossConfig) {
        return aliyunossRepository.save(aliyunossConfig);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public Object upload(MultipartFile file, AliyunossConfig aliyunossConfig) throws IOException {
        if(aliyunossConfig.getId() == null){
            throw new BadRequestException("请先添加相应配置，再操作");
        }
        FileUtil.checkSize(Long.parseLong(aliyunossConfig.getMaxSize()), file.getSize());

        File newFile = null;
        try {
          newFile =  FileUtil.toFile(file);
        } catch (Exception e) {
            return null;
        }
        boolean upload =  AliyunOSSUtil.upLoad(newFile,aliyunossConfig.getPrefix(),file.getOriginalFilename(), aliyunossConfig);
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = aliyunossConfig.getEndpoint();
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
//        String accessKeyId = aliyunossConfig.getAccessKeyId();
//        String accessKeySecret = aliyunossConfig.getAccessKeySecre();
//        String bucketName = aliyunossConfig.getBucketName();
//        String objectName = file.getOriginalFilename();
//// 您的回调服务器地址，如http://oss-demo.aliyuncs.com:23450或http://127.0.0.1:9090。
//        String callbackUrl = "http://d27af868.ngrok.io:8091/aliyun/oss/callback";
//// 创建OSSClient实例。
//       OSS ossClient = new OSSClientBuilder().build("oss-cn-beijing.aliyuncs.com", accessKeyId, accessKeySecret);
//
//
//        try{
//            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, aliyunossConfig.getPrefix() + "/" + objectName,new ByteArrayInputStream(file.getBytes()));
////            http://yoooho.bkbedu.com/mall/images/qwe.jpg
//// 上传回调参数。
//         //   Callback callback = new Callback();
////            callback.setCallbackUrl(callbackUrl);
////（可选）设置回调请求消息头中Host的值，即您的服务器配置Host的值。
//// callback.setCallbackHost("yourCallbackHost");
//// 设置发起回调时请求body的值。
//      //      callback.setCallbackBody("{\\\"mimeType\\\":${mimeType},\\\"size\\\":${size}}");
//// 设置发起回调请求的Content-Type。
////            callback.setCalbackBodyType(Callback.CalbackBodyType.JSON);
//// 设置发起回调请求的自定义参数，由Key和Value组成，Key必须以x:开始。
////        callback.addCallbackVar("x:var1", "value1");
////        callback.addCallbackVar("x:var2", "value2");
////            putObjectRequest.setCallback(callback);
//
//            PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
//
//// 读取上传回调返回的消息内容。
////            byte[] buffer = new byte[1024];
////            putObjectResult.getResponse().getContent().read(buffer);
//
//// 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
////            putObjectResult.getResponse().getContent().close();
//        }catch (Exception e){
//            return null;
//        }finally {
//            // 关闭OSSClient。
//            ossClient.shutdown();
//        }
        //存入数据库
        AliyunOssContent aliyunOssContent = new AliyunOssContent();
        aliyunOssContent.setSuffix(FileUtil.getExtensionName(file.getOriginalFilename()));
        aliyunOssContent.setBucket(aliyunossConfig.getBucketName());
//        aliyunOssContent.setType(aliyunossConfig.get);
        aliyunOssContent.setKey(FileUtil.getFileNameNoEx(file.getOriginalFilename()));
        aliyunOssContent.setUrl(aliyunossConfig.getPrefix()+"/"+file.getOriginalFilename());
        aliyunOssContent.setSize(FileUtil.getSize(Integer.parseInt(file.getSize()+"")));
        return aliyunOssContentRepository.save(aliyunOssContent);
    }


    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public Object synchronize(AliyunossConfig config) {
        if(config.getId() == null){
            return CommonResult.failed("请先添加相应配置，再操作");
        }
       List list = AliyunOSSUtil.listFile(config.getPrefix(),config);

        for (int i = 0; i <list.size() ; i++) {
            OSSObjectSummary item = (OSSObjectSummary) list.get(i);
            List <AliyunOssContent> contents = aliyunOssContentRepository.findByUrl(item.getKey());
                 if(contents.size() == 0 ){
                    String filename = null;
                     String[] splitstr=item.getKey().split("/");
                     List<String> list1 = Arrays.asList(splitstr);
                     filename = list1.get(list1.size() - 1);
                     AliyunOssContent aliyunOssContent = new AliyunOssContent();
                     aliyunOssContent.setSize(FileUtil.getSize(Integer.parseInt(item.getSize()+"")));
                     aliyunOssContent.setSuffix(FileUtil.getExtensionName(filename));
                     aliyunOssContent.setKey(FileUtil.getFileNameNoEx(filename));
                     aliyunOssContent.setType(config.getType());
                     aliyunOssContent.setBucket(item.getBucketName());
                     aliyunOssContent.setUrl(item.getKey());
                     aliyunOssContent.setUpdateTime(new Timestamp(item.getLastModified().getTime()));
                     aliyunOssContentRepository.save(aliyunOssContent);

                }else {
                     boolean hasFile = false;
                     for (int j = 0; j <  contents.size(); j++) {
                         AliyunOssContent content = contents.get(j);
                         if (content.getBucket().equals(item.getBucketName())){
                             hasFile = true;
                             break;
                         }
                     }
                     if (!hasFile){
                         String filename = null;
                         String[] splitstr=item.getKey().split("/");
                         List<String> list1 = Arrays.asList(splitstr);
                         filename = list1.get(list1.size() - 1);
                         AliyunOssContent aliyunOssContent = new AliyunOssContent();
                         aliyunOssContent.setSize(FileUtil.getSize(Integer.parseInt(item.getSize()+"")));
                         aliyunOssContent.setSuffix(FileUtil.getExtensionName(filename));
                         aliyunOssContent.setKey(FileUtil.getFileNameNoEx(filename));
                         aliyunOssContent.setUpdateTime(new Timestamp(item.getLastModified().getTime()));
                         aliyunOssContent.setType(config.getType());
                         aliyunOssContent.setBucket(item.getBucketName());
                         aliyunOssContent.setUrl(item.getKey());
                         aliyunOssContentRepository.save(aliyunOssContent);
                     }
                 }
        }
        return  null;
    }

    @Override
    public List<AliyunOssContent> queryAll(AliyunOssQueryCriteria criteria) {
        return aliyunOssContentRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder));
    }
    @Override
    @Cacheable
    public Object queryAll(AliyunOssQueryCriteria criteria, Pageable pageable){
        return PageUtil.toPage(aliyunOssContentRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable));
    }



    @Override
    public void downloadList(List<AliyunOssContent> queryAll, HttpServletResponse response) {
        List<Map<String, Object>> list = new ArrayList<>();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (AliyunOssContent content :  queryAll) {

            Map<String,Object> map = new LinkedHashMap<>();
            map.put("文件名", content.getKey());
            map.put("文件类型", content.getSuffix());
            map.put("空间名称", content.getBucket());
            map.put("文件大小", content.getSize());
            map.put("空间类型", content.getType());
            map.put("创建日期", sdf.format(content.getUpdateTime()));
            list.add(map);
        }
        try {
            FileUtil.downloadExcel(list, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Cacheable
    public AliyunOssContent findByContentId(Long id) {
        AliyunOssContent  AliyunOssContent= aliyunOssContentRepository.findById(id).orElseGet(AliyunOssContent ::new);
        ValidationUtil.isNull(AliyunOssContent.getId(),"QiniuContent", "id",id);
        return AliyunOssContent;
    }

    @Override
    public String download(AliyunOssContent content, AliyunossConfig config) {
        String finalUrl = null;
        String type = "公开";
        if(type.equals(content.getType())){
            String http = "http://", https = "https://";
            if (config.getHost()!= null && (config.getHost().toLowerCase().startsWith(http) || config.getHost().toLowerCase().startsWith(https))) {
                finalUrl = config.getHost() + "/"+ content.getUrl() ;
            }else {
              finalUrl  = https +config.getEndpoint() + "/"+ content.getUrl() ;
            }
        } else {
//            Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
//            // 1小时，可以自定义链接过期时间
//            long expireInSeconds = 3600;
//            finalUrl = auth.privateDownloadUrl(content.getUrl(), expireInSeconds);

        }
        return finalUrl;

    }

    @Override
    public void delete(AliyunOssContent content, AliyunossConfig config) {

        try {
            AliyunOSSUtil.delFile(content.getUrl(),config);
            aliyunOssContentRepository.delete(content);
        } catch (Exception e) {
            aliyunOssContentRepository.delete(content);
        }
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids, AliyunossConfig config) {
        for (Long id : ids) {
            delete(findByContentId(id), config);
        }
    }

    @Override
    public void uploadByte(byte[] content, AliyunossConfig config,String name) {
        String endpoint = config.getEndpoint();
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = config.getAccessKeyId();
        String accessKeySecret = config.getAccessKeySecre();
//        String content = "Hello OSS";
// 创建OSSClient实例。
        PutObjectRequest putObjectRequest = new PutObjectRequest(config.getBucketName(), name, new ByteArrayInputStream(content));

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

// 上传Byte数组。
        ossClient.putObject(putObjectRequest);

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
