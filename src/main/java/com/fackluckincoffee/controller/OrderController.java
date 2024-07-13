package com.fackluckincoffee.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import com.fackluckincoffee.entity.OrderPage.OrderRequest;
import com.fackluckincoffee.entity.OrderPage.OrderResponse;
import com.fackluckincoffee.entity.Result;
import com.fackluckincoffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/luckin")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/coffees")
    public Result getCoffees() {
        Result result = new Result(1, "请求成功", null);

        try {
            StpUtil.checkLogin();
        } catch (NotLoginException e) {
            result.setCode(0);
            result.setMsg("用户未登录");
            return result;
        }

        result.setData(orderService.getCoffees());

        return result;
    }

    @PostMapping("/order")
    public Result postOrder(@RequestBody OrderRequest orderRequest) {
        Result result = new Result(1, "请求成功", null);
        OrderResponse orderResponse = null;

        try {
            StpUtil.checkLogin();
        } catch (NotLoginException e) {
            result.setCode(0);
            result.setMsg("用户未登录");
            return result;
        }

        try {
            orderResponse = orderService.postOrder(orderRequest);
        } catch (RuntimeException e) {
            result.setCode(0);
            result.setMsg(e.getMessage());
            return result;
        }

        result.setData(orderResponse);

        return result;
    }
}
