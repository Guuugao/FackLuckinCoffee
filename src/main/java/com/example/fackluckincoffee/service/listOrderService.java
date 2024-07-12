package com.example.fackluckincoffee.service;

import com.example.fackluckincoffee.Pojo.listOrder;
import com.example.fackluckincoffee.Pojo.modifyState;

import java.util.List;

public interface listOrderService {

    List<listOrder> getListOrder(String id);

    double getBalanceNumber(String userId);

    modifyState modifyBalance(String userId, double balance);
}
