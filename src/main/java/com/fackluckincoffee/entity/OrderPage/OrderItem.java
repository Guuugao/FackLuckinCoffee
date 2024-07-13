package com.fackluckincoffee.entity.OrderPage;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "order_items")
public class OrderItem {
    @TableId(type = IdType.ASSIGN_UUID)
    private String order_item_id;
    private String order_id;
    private String coffee_id;
    private int quantity;
    private BigDecimal price;
}
