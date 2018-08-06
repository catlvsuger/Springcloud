package com.sjt.controller;

import com.sjt.service.SchedualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/17/017.
 */

@RestController
public class HiController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualService schedualService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return  schedualService.sayHiFromClientOne(name);
    }
}
