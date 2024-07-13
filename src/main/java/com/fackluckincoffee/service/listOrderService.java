package com.fackluckincoffee.service;

import com.fackluckincoffee.entity.PersonalInfoPage.LoginRequest;
import com.fackluckincoffee.entity.PersonalInfoPage.User;
import com.fackluckincoffee.entity.PersonalInfoPage.listOrder;
import com.fackluckincoffee.entity.PersonalInfoPage.modifyState;

import java.util.List;

public interface listOrderService {

    List<listOrder> getListOrder(String id);

    double getBalanceNumber(String userId);

    modifyState modifyBalance(String userId, double balance);

    User login(String username);

    User register(LoginRequest loginRequest);
}
