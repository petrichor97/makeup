package com.tianxuan.makeup.service.impl;

import com.tianxuan.makeup.dto.OrderDTO;
import com.tianxuan.makeup.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: makeup
 * @description:
 * @author: Petrichor
 * @create: 2018-08-21 11:47
 **/
@Service
@Slf4j
public class PushMessageService implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {

        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("");
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
         //  log.error("【微信模板消息发送失败  】",);
        }
    }
}
