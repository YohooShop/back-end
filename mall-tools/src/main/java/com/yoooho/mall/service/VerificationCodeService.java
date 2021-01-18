package com.yoooho.mall.service;

import com.yoooho.mall.vo.EmailVo;
import com.yoooho.mall.domian.VerificationCode;

public interface VerificationCodeService {
    /**
     * 发送邮件验证码
     * @param code 验证码
     * @return EmailVo
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code 验证码
     */
   boolean validated(VerificationCode code);
}
