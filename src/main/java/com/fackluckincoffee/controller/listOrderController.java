package com.fackluckincoffee.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.fackluckincoffee.entity.PersonalInfoPage.*;
import com.fackluckincoffee.entity.Result;
import com.fackluckincoffee.service.serviceImpl.listOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/luckin")
public class listOrderController {

    @Autowired
    listOrderServiceImpl listOrderServiceImpl;

    @GetMapping("/user/{id}/orders")
    public Result getListOrders(@PathVariable int id){
        try{
            StpUtil.checkLogin();
            String userId = String.valueOf(id);
            System.out.println(userId);
            List<listOrder> listOrders = listOrderServiceImpl.getListOrder(userId);
            return Result.success(listOrders);
        }catch (NotLoginException n){
            return Result.error("未登录，请先登录");
        }catch (Exception e){
            return Result.error("获取列表信息失败");
        }
    }

    @GetMapping("/user/{id}/wallet")
    public Result getBalanceNumber(@PathVariable int id){
        try{
            StpUtil.checkLogin();
            String userId = String.valueOf(id);
            double balance = listOrderServiceImpl.getBalanceNumber(userId);
            return Result.success(balance);
        }catch (NotLoginException n){
            return Result.error("未登录，请先登录");
        }catch (Exception e){
            return Result.error("获取余额信息有误");
        }
    }

    @PutMapping("/user/{id}/wallet")
    public Result modifyBalance(@PathVariable int id, @RequestBody earlierAmount earlierAmount){
        try{
            StpUtil.checkLogin();
            String userId = String.valueOf(id);
            modifyState modifyState = listOrderServiceImpl.modifyBalance(userId, earlierAmount.getAmount());
            return Result.success(modifyState);
        }catch (NotLoginException n){
            return Result.error("未登录，请先登录");
        }
    }

    @RequestMapping("/login")
    public SaResult login(@RequestBody LoginRequest loginRequest){
        try{
            User user = listOrderServiceImpl.login(loginRequest.getUsername());
            if(loginRequest.getUsername().equals(user.getUsername()) && loginRequest.getPassword().equals(user.getPassword())){
                StpUtil.login(user.getUser_id());
                return SaResult.ok("登录成功");
            }else{
                return SaResult.error("用户名或密码错误");
            }
        }catch (Exception e){
            return SaResult.error("用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public SaResult logout(){
        StpUtil.logout();
        return SaResult.ok("退出登录成功");
    }
}
