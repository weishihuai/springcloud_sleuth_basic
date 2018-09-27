package com.springcloud.wsh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: RibbonClient1Controller
 * @ProjectName springcloud_sleuth_basic
 * @Description: 测试Controller
 * @Author WeiShiHuai
 * @Date 2018/9/27 10:09
 */
@RestController
public class RibbonClient1Controller {

    private static Logger logger = LoggerFactory.getLogger(RibbonClient1Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon-client-1")
    public String test() {
        logger.info("RibbonClient1Controller--test() is requesting....");
        return restTemplate.getForObject("http://ribbon-client2/callRabbitClient2", String.class);
    }


    @RequestMapping("/callRabbitClient1")
    public String callRabbitClient1() {
        logger.info("RibbonClient1Controller--callRabbitClient1 is requesting...");
        return "hello ,Spring Cloud Sleuth!";
    }
}
