package com.example.fackluckincoffee.controller;

import com.example.fackluckincoffee.Pojo.Result;
import com.example.fackluckincoffee.Pojo.earlierAmount;
import com.example.fackluckincoffee.Pojo.listOrder;
import com.example.fackluckincoffee.Pojo.modifyState;
import com.example.fackluckincoffee.service.serviceImpl.listOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class listOrderController {

    @Autowired
    listOrderServiceImpl listOrderServiceImpl;

    @GetMapping("/luckin/user/{id}/orders")
    public Result getListOrders(@PathVariable int id){
        try{
            String userId = String.valueOf(id);
            System.out.println(userId);
            List<listOrder> listOrders = listOrderServiceImpl.getListOrder(userId);
            return Result.success(listOrders);
        }catch (Exception e){
            return Result.error("获取列表信息有误");
        }
    }

    @GetMapping("/luckin/user/{id}/wallet")
    public Result getBalanceNumber(@PathVariable int id){
        try{
            String userId = String.valueOf(id);
            double balance = listOrderServiceImpl.getBalanceNumber(userId);
            return Result.success(balance);
        }catch (Exception e){
            return Result.error("获取余额信息有误");
        }
    }

    @PutMapping("/luckin/user/{id}/wallet")
    public Result modifyBalance(@PathVariable int id, @RequestBody earlierAmount earlierAmount){
        String userId = String.valueOf(id);
        modifyState modifyState = listOrderServiceImpl.modifyBalance(userId, earlierAmount.getAmount());
        return Result.success(modifyState);
    }
}
