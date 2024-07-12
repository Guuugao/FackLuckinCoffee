package com.example.fackluckincoffee.service.serviceImpl;

import com.example.fackluckincoffee.Pojo.individualCoffee;
import com.example.fackluckincoffee.Pojo.listOrder;
import com.example.fackluckincoffee.Pojo.modifyState;
import com.example.fackluckincoffee.mapper.listOrderMapper;
import com.example.fackluckincoffee.service.listOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class listOrderServiceImpl implements listOrderService {

    @Autowired
    listOrderMapper listOrderMapper;

    @Override
    public List<listOrder> getListOrder(String id) {

        List<listOrder> list = listOrderMapper.getListOrder(id);
        List<listOrder> lastList = new ArrayList<>();
        List<LocalDateTime> listTime = listOrderMapper.getListOrderTime(id);

        for (int i = 0; i < list.size(); i++) {
            listOrder listOrder = list.get(i);
            LocalDateTime time = listTime.get(i);
            String timeStr = time.toString();
            listOrder.setDate(timeStr);
            String orderId = listOrder.getOrderId();
            List<individualCoffee> individualList = listOrderMapper.getCoffeeById(orderId);
            listOrder.setItems(individualList);
            lastList.add(listOrder);
        }

        return lastList;

    }

    @Override
    public double getBalanceNumber(String userId) {

        return listOrderMapper.getBalanceNumber(userId);
    }

    @Override
    public modifyState modifyBalance(String userId, double balance) {
        try{
            int state = listOrderMapper.modifyBalance(userId, balance);
            return new modifyState(balance, String.valueOf(state));
        }catch (Exception e){
            return new modifyState(balance, "0");
        }

    }
}
