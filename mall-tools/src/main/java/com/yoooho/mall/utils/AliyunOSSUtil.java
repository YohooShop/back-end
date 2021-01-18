package com.yoooho.mall.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.model.*;
import com.yoooho.mall.domian.AliyunossConfig;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;


import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AliyunOSSUtil {


    private static final Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    /**
     * 上传文件。
     *
     * @param file 需要上传的文件路径
     * @return 如果上传的文件是图片的话，会返回图片的"URL"，如果非图片的话会返回"非图片，不可预览。文件路径为：+文件路径"
     */
    public static boolean upLoad(File file, String fileHost, String filename, AliyunossConfig config) {
        // 默认值为：true
        boolean isImage = true;
        // 判断所要上传的图片是否是图片，图片可以预览，其他文件不提供通过URL预览
        try {
            Image image = ImageIO.read(file);
            isImage = image == null ? false : true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("------OSS文件上传开始--------" + file.getName());


        // 判断文件
        if (file == null) {
            return false;
        }
        // 创建OSSClient实例。

        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());
        try {
            // 判断容器是否存在,不存在就创建
            if (!ossClient.doesBucketExist(config.getBucketName())) {
                ossClient.createBucket(config.getBucketName());
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(config.getBucketName());
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = fileHost + "/" + filename;

            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(config.getBucketName(), fileUrl, file));
            // 设置权限(公开读)
            ossClient.setBucketAcl(config.getBucketName(), CannedAccessControlList.PublicRead);
            if (result != null) {
                logger.info("------OSS文件上传成功------" + fileUrl);
            }
        } catch (OSSException oe) {
            logger.error(oe.getMessage());
            return false;
        } catch (ClientException ce) {
            logger.error(ce.getErrorMessage());
            return false;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return true;
    }

    /**
     * 通过文件名下载文件
     *
     * @param objectName    要下载的文件名
     * @param localFileName 本地要创建的文件名
     */
    public static void downloadFile(String objectName, String localFileName, AliyunossConfig config) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(config.getBucketName(), objectName), new File(localFileName));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 删除文件
     * objectName key 地址
     *
     * @param filePath
     */
    public static Boolean delFile(String filePath, AliyunossConfig config) {
        logger.info("删除开始，objectName=" + filePath);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());

        // 删除Object.
        boolean exist = ossClient.doesObjectExist(config.getBucketName(), filePath);
        if (!exist) {
            logger.error("文件不存在,filePath={}", filePath);
            return false;
        }
        logger.info("删除文件,filePath={}", filePath);
        ossClient.deleteObject(config.getBucketName(), filePath);
        ossClient.shutdown();
        return true;
    }

    /**
     * 批量删除
     *
     * @param keys
     */
    public static Boolean delFileList(List<String> keys, AliyunossConfig config) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());

        try {
            // 删除文件。
            DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(config.getBucketName()).withKeys(keys));
            List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
        return true;

    }

    /**
     * 获取文件夹
     *
     * @param fileName
     * @return
     */
    public static List<String> fileFolder(String fileName, AliyunossConfig config) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());
        // 构造ListObjectsRequest请求。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(config.getBucketName());
        // 设置正斜线（/）为文件夹的分隔符。
        listObjectsRequest.setDelimiter("/");
        // 设置prefix参数来获取fun目录下的所有文件。
        if (StringUtils.isNotBlank(fileName)) {
            listObjectsRequest.setPrefix(fileName + "/");
        }
        // 列出文件
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        // 遍历所有commonPrefix
        List<String> list = new ArrayList<>();
        for (String commonPrefix : listing.getCommonPrefixes()) {
            String newCommonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            String[] s = newCommonPrefix.split("/");
            list.add(s[1]);
        }
        // 关闭OSSClient
        ossClient.shutdown();
        return list;
    }

    /**
     * 列举文件下所有的文件url信息
     */
    public static List<OSSObjectSummary> listFile(String fileHost, AliyunossConfig config) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(config.getBucketName());

        // 设置prefix参数来获取fun目录下的所有文件。
        listObjectsRequest.setPrefix(fileHost + "/");
        // 列出文件。
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        // 遍历所有文件。
        List<OSSObjectSummary> list = new ArrayList<>();
        for (int i = 0; i < listing.getObjectSummaries().size(); i++) {
            if (i == 0) {
                continue;
            }

            OSSObjectSummary ossObjectSummary = listing.getObjectSummaries().get(i);
            list.add(ossObjectSummary);
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        return list;
    }
    /**
     * 获得url链接
     *
     * @param objectName
     * @return
     */
    public static String getUrl(String objectName, AliyunossConfig config) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());
        // 设置权限(公开读)
        ossClient.setBucketAcl(config.getBucketName(), CannedAccessControlList.PublicRead);
        // 设置图片处理样式。
//        String style = "image/resize,m_fixed,w_100,h_100/rotate,90";
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 100);
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(config.getBucketName(), objectName, HttpMethod.GET);
        req.setExpiration(expiration);
//        req.setProcess(style);
        URL signedUrl = ossClient.generatePresignedUrl(req);
        // 关闭OSSClient。
        logger.info("------OSS文件文件信息--------" + signedUrl.toString());
        ossClient.shutdown();
        if (signedUrl != null) {
            return signedUrl.toString();
        }
        return null;
    }

    /**
     * 创建文件夹
     *
     * @param folder
     * @return
     */
    public static String createFolder(String folder, AliyunossConfig config) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(config.getEndpoint(),  config.getAccessKeyId(), config.getAccessKeySecre());
        // 文件夹名
        final String keySuffixWithSlash = folder;
        // 判断文件夹是否存在，不存在则创建
        if (!ossClient.doesObjectExist(config.getBucketName(), keySuffixWithSlash)) {
            // 创建文件夹
            ossClient.putObject(config.getBucketName(), keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            logger.info("创建文件夹成功");
            // 得到文件夹名
            OSSObject object = ossClient.getObject(config.getBucketName(), keySuffixWithSlash);
            String fileDir = object.getKey();
            ossClient.shutdown();
            return fileDir;
        }
        return keySuffixWithSlash;
    }

}
