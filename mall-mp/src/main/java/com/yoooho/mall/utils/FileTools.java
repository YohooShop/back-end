package com.yoooho.mall.utils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class FileTools {

public static File urlToFile(String fileUrl) {
 String path = System.getProperty("user.dir");
File upload = new File(path, "tmp");
if (!upload.exists()) {
upload.mkdirs();
}
return urlToFile(fileUrl,upload);
}

    /**
          * @Description: 网络资源转file,用完以后必须删除该临时文件
          * @param fileUrl 资源地址
          * @param upload 临时文件路径
          * @author: 赵兴炎
          * @date: 2019年7月10日
          * @return: 返回值
          */
public static File urlToFile(String fileUrl, File upload) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/"));
        FileOutputStream downloadFile = null;
        InputStream openStream = null;
        File savedFile = null;
        fileUrl = getURLEncoderString(fileUrl);

       savedFile = new File(upload.getAbsolutePath() + fileName);

        if (fileUrl.startsWith("https://")){
            URL url = null;
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }
            try {
                sslContext.init(null, tm, new java.security.SecureRandom());
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            try {
                url = new URL(fileUrl);
                try {
                    HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
                    httpUrlConn.setSSLSocketFactory(ssf);
                    openStream = httpUrlConn.getInputStream();
                    int index;
                    byte[] bytes = new byte[1024];
                    downloadFile = new FileOutputStream(savedFile);
                    while ((index = openStream.read(bytes)) != -1) {
                        downloadFile.write(bytes, 0, index);
                        downloadFile.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (openStream != null) {
                            openStream.close();
                        }
                        if (downloadFile != null) {
                            downloadFile.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }else {
            try {
                URL url = new URL(fileUrl);
                java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
                openStream = connection.getInputStream();
                int index;
                byte[] bytes = new byte[1024];
                downloadFile = new FileOutputStream(savedFile);
                while ((index = openStream.read(bytes)) != -1) {
                    downloadFile.write(bytes, 0, index);
                    downloadFile.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (openStream != null) {
                        openStream.close();
                    }
                    if (downloadFile != null) {
                        downloadFile.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


       return savedFile;
   }
    public static String getURLEncoderString(String string) {
        String resultURL = "";
        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            //只对汉字处理
            if (isChineseChar(charAt)) {
                String encode = null;
                try {
                    encode = URLEncoder.encode(charAt+"","UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                resultURL+=encode;
            }else {
                resultURL+=charAt;
            }
        }
   return resultURL;
    }
    //判断汉字的方法,只要编码在\u4e00到\u9fa5之间的都是汉字
    public static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }



}
