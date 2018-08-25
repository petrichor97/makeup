package com.tianxuan.makeup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-21 10:56
 **/
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 项目url
     */
    public String sell;
}
