package com.sjt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by dengjing on 2018年7月31日16:44:01.
 * 消费服务  调用 servic-producer hi接口
 */
//绑定該接口到CalculatorServer服务，并通知Feign组件对该接口进行代理（不需要编写接口实现）
@FeignClient(value = "producer-server",fallback = SchedualService.SchedualServiceHiHystric.class)
public interface SchedualService {

    /**
     * @PathVariable這種也是支持的
     * @RequestMapping(value="/add/{a}", method=RequestMethod.GET)
     * int myadd(@PathVariable("a") int a, @RequestParam("b") int b);

     * 通过SpringMVC的注解来配置所綁定的服务下的具体实现
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam("name") String name);


    /**
     * 这里采用和SpringCloud官方文档相同的做法，把fallback类作为内部类放入Feign接口中
     * http://cloud.spring.io/spring-cloud-static/Camden.SR6/#spring-cloud-feign-hystrix
     * （也可以外面独立定义该类，个人觉得没必要，这种东西写成内部类最合适）
     */
    @Component
    class SchedualServiceHiHystric implements SchedualService {
        @Override
        public String sayHiFromClientOne(@RequestParam("name") String name) {
            return "-999";
        }
    }

}
