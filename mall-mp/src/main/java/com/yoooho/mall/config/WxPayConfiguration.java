package com.yoooho.mall.config;

import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.google.common.collect.Maps;
import com.yoooho.mall.common.utils.RedisUtil;
import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.model.WxPayConfig;
import com.yoooho.mall.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 支付配置
 * @author hupeng
 * @date 2020/03/01
 */
@Slf4j
@Configuration
public class WxPayConfiguration {


	private static Map<String, WxPayService> payServices = Maps.newHashMap();




	/**
	 *  获取WxPayService
	 * @return
	 */
	public  WxPayService getPayService(SystemConfigService systemConfigService) {
		WxPayService wxPayService = payServices.get(ShopKeyUtils.getYshopWeiXinPayService());
		WxPayConfig wxPayConfig = systemConfigService.queryWXPayConfig();
		WxOfficialAccountConfig wxOfficialAccountConfig = systemConfigService.queryWXOfficialAccountConfig();
		if(wxPayService == null || RedisUtil.get(ShopKeyUtils.getYshopWeiXinPayService()) == null) {
			com.github.binarywang.wxpay.config.WxPayConfig payConfig = new com.github.binarywang.wxpay.config.WxPayConfig();
			payConfig.setAppId(wxOfficialAccountConfig.getAppid());
			payConfig.setMchId(wxPayConfig.getMchId());
			payConfig.setMchKey(wxPayConfig.getMchKey());
			payConfig.setKeyPath(wxPayConfig.getKeyPath());
			// 可以指定是否使用沙箱环境
			payConfig.setUseSandboxEnv(false);
			wxPayService = new WxPayServiceImpl();
			wxPayService.setConfig(payConfig);
			payServices.put(ShopKeyUtils.getYshopWeiXinPayService(), wxPayService);

			//增加标识
			RedisUtil.set(ShopKeyUtils.getYshopWeiXinPayService(),"yooohoshop");
		}
		return wxPayService;
    }

	/**
	 *  获取小程序WxAppPayService
	 * @return
	 */
	public WxPayService getWxAppPayService(SystemConfigService systemConfigService) {
		WxPayService wxPayService = payServices.get(ShopKeyUtils.getYshopWeiXinMiniPayService());
		WxAppConfig wxAppConfig = systemConfigService.queryWXAPPConfig();
		WxPayConfig wxPayConfig = systemConfigService.queryWXPayConfig();
		if(wxPayService == null || RedisUtil.get(ShopKeyUtils.getYshopWeiXinPayService()) == null) {
			com.github.binarywang.wxpay.config.WxPayConfig payConfig = new com.github.binarywang.wxpay.config.WxPayConfig();
			payConfig.setAppId(wxAppConfig.getAppId());
			payConfig.setMchId(wxPayConfig.getMchId());
			payConfig.setMchKey(wxPayConfig.getMchKey());
			payConfig.setKeyPath(wxPayConfig.getKeyPath());
			// 可以指定是否使用沙箱环境
			payConfig.setUseSandboxEnv(false);
			wxPayService = new WxPayServiceImpl();
			wxPayService.setConfig(payConfig);
			payServices.put(ShopKeyUtils.getYshopWeiXinMiniPayService(), wxPayService);

			//增加标识
			RedisUtil.set(ShopKeyUtils.getYshopWeiXinPayService(),"yooohoshop");
		}
		return wxPayService;
	}

	/**
	 *  获取APPPayService
	 * @return
	 */
	public static WxPayService getAppPayService() {
		WxPayService wxPayService = payServices.get(ShopKeyUtils.getYshopWeiXinAppPayService());
		if(wxPayService == null || RedisUtil.get(ShopKeyUtils.getYshopWeiXinPayService()) == null) {
			com.github.binarywang.wxpay.config.WxPayConfig payConfig = new com.github.binarywang.wxpay.config.WxPayConfig();
			payConfig.setAppId(RedisUtil.get(ShopKeyUtils.getWxNativeAppAppId()));
			payConfig.setMchId(RedisUtil.get(ShopKeyUtils.getWxPayMchId()));
			payConfig.setMchKey(RedisUtil.get(ShopKeyUtils.getWxPayMchKey()));
			payConfig.setKeyPath(RedisUtil.get(ShopKeyUtils.getWxPayKeyPath()));
			// 可以指定是否使用沙箱环境
			payConfig.setUseSandboxEnv(false);
			wxPayService = new WxPayServiceImpl();
			wxPayService.setConfig(payConfig);
			payServices.put(ShopKeyUtils.getYshopWeiXinAppPayService(), wxPayService);

			//增加标识
			RedisUtil.set(ShopKeyUtils.getYshopWeiXinPayService(),"yooohoshop");
		}
		return wxPayService;
	}

	/**
	 * 移除WxPayService
	 */
	public static void removeWxPayService(){
		RedisUtil.del(ShopKeyUtils.getYshopWeiXinPayService());
		payServices.remove(ShopKeyUtils.getYshopWeiXinPayService());
		payServices.remove(ShopKeyUtils.getYshopWeiXinMiniPayService());
		payServices.remove(ShopKeyUtils.getYshopWeiXinAppPayService());
	}




}
