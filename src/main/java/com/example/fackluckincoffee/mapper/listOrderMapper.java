package com.example.fackluckincoffee.mapper;

import com.example.fackluckincoffee.Pojo.individualCoffee;
import com.example.fackluckincoffee.Pojo.listOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface listOrderMapper {

    @Select("select order_id orderId, total_price totalPrice, status from orders where user_id = #{userId}")
    List<listOrder> getListOrder(String userId);

    @Select("select order_date from orders where user_id = #{userId}")
    List<LocalDateTime> getListOrderTime(String userId);

    @Select("select order_items.quantity, order_items.price, coffees.name coffeeName from order_items, coffees where order_id = #{orderId} and " +
            "order_items.coffee_id = coffees.coffee_id")
    List<individualCoffee> getCoffeeById(String orderId);

    @Select("select balance from users where user_id = #{userId}")
    double getBalanceNumber(String userId);

    @Update("update users set balance = #{balance} where user_id = #{userId}")
    int modifyBalance(String userId, double balance);
}
