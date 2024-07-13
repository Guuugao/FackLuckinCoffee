package com.fackluckincoffee.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.fackluckincoffee.entity.Result;
import com.fackluckincoffee.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/luckin")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping("/home")
    public Result getHomePage() {
        Result result = new Result(1, "请求成功", null);

        try {
            StpUtil.checkLogin();
        } catch (NotLoginException e) {
            result.setCode(0);
            result.setMsg("用户未登录");
            return result;
        }

        result.setData(homePageService.getHomePage());

        return result;
    }
}
