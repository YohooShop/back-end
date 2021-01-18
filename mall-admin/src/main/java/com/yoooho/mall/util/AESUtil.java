package com.yoooho.mall.util;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class AESUtil {

//    private static Prop prop = DataDictionary.getProp();

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";
    /**
     * 生成key
     */
    //微信支付API密钥设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
    private static String paySign = "微信支付API密钥";
    //对商户key做md5，得到32位小写key*
    private static SecretKeySpec key = new SecretKeySpec(MD5Util.MD5Encode(paySign).toLowerCase().getBytes(), ALGORITHM);

    static {

    }

    /**
     * AES加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptData(String data) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64Util.encode(cipher.doFinal(data.getBytes()));
    }

    /**
     * AES解密
     *
     *（1）对加密串A做base64解码，得到加密串B
     *（2）用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
     * @param base64Data
     * @return
     * @throws Exception
     */
    public static String decryptData(String base64Data) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64Util.decodeBite(base64Data)));
    }

}
