package com.xqxls.one.controller;

import com.xqxls.one.service.RmOneInterface;
import com.xqxls.one.service.RmOneService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneController {

    @Autowired
    RmOneService rmOneService;

    @GetMapping("/one")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String one() throws InterruptedException {
        rmOneService.rm1();
//        TimeUnit.MINUTES.sleep(1);
//        System.out.println(1/0);
        return "success";
    }

    @Autowired
    private RmOneInterface rmOneInterface;

    @GetMapping("/one-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String oneTcc() throws InterruptedException {
        rmOneInterface.rm1(null);
        return "success";
    }

}
