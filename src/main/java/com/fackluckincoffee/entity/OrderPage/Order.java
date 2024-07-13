package com.fackluckincoffee.entity.OrderPage;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "orders")
public class Order {
    @TableId(type = IdType.ASSIGN_UUID)
    private String order_id;
    private String user_id;
    private BigDecimal total_price;
    private String status;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime order_date;
}
