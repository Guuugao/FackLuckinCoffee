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
@TableName(value = "coffees")
public class Coffee {
    @TableId(type = IdType.ASSIGN_UUID)
    private String coffee_id;
    private String name;
    private String category;
    private BigDecimal price;
    private String description;
    private String image_url;
}
