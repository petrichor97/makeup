package com.tianxuan.makeup.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 微信属性配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {



    /** 公众平台测试id */
    private String mpAppId;

    /** 公众平台测试密钥 */
    private String mpAppSecret;

    /**  消息token */
    private String token;

    /** 开放平台测试id */
    private String openAppId;

    /** 开放平台测试密钥 */
    private String openAppSecret;

    /** 商户号 */
    private String mchId;

    /** 商户密钥 */
    private String mchKey;

    /** 商户证书路径 */
    private String keyPath;

    /** 微信支付异步通知地址 */
    private String notifyUrl;

    /** 微信推送模板id */
    private Map<String, String> templateId;

}
