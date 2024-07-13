package com.fackluckincoffee.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fackluckincoffee.entity.OrderPage.*;
import com.fackluckincoffee.entity.PersonalInfoPage.User;
import com.fackluckincoffee.mapper.OrderPage.CoffeesMapper;
import com.fackluckincoffee.mapper.OrderPage.OrderItemsMapper;
import com.fackluckincoffee.mapper.OrderPage.OrderMapper;
import com.fackluckincoffee.mapper.PersonalInfoPage.ListOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemsMapper orderItemsMapper;
    @Autowired
    private CoffeesMapper coffeesMapper;
    @Autowired
    private ListOrderMapper listOrderMapper;

    // 查询所有咖啡记录
    public List<Coffee> getCoffees(){
        return coffeesMapper.selectList(null);
    }

    public OrderResponse postOrder(OrderRequest orderRequest) throws RuntimeException{
        Order order = new Order();

        // 计算总价格
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<OrderItemRequest> items = orderRequest.getItems();

        for (OrderItemRequest item : items) {
            Coffee coffee = coffeesMapper.selectById(item.getCoffeeId());
            if (coffee != null) {
                BigDecimal itemTotal = coffee.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                totalPrice = totalPrice.add(itemTotal);
            } else {
                throw new RuntimeException("未知产品ID");
            }
        }

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_id", orderRequest.getUserId());
        User user = listOrderMapper.selectOne(userQueryWrapper);

        if (user.getBalance().compareTo(totalPrice) < 0) {
            throw new RuntimeException("账户余额不足");
        } else {
            user.setBalance(user.getBalance().subtract(totalPrice));
            listOrderMapper.update(user, userQueryWrapper);
        }

        order.setUser_id(orderRequest.getUserId())
                .setStatus("success")
                .setTotal_price(totalPrice);
        orderMapper.insert(order);

        List<OrderItem> orderItems = items.stream().map(orderItemRequest -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder_id(order.getOrder_id())
                    .setCoffee_id(orderItemRequest.getCoffeeId())
                    .setQuantity(orderItemRequest.getQuantity())
                    .setPrice(coffeesMapper.selectById(orderItemRequest.getCoffeeId()).getPrice());
            return orderItem;
        }).toList();
        orderItemsMapper.insert(orderItems);

        return new OrderResponse(order.getOrder_id(), "success", order.getTotal_price());
    }
}
