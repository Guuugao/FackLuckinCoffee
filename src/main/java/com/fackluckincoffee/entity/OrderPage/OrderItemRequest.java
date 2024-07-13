package com.fackluckincoffee.entity.OrderPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
    private String coffeeId;
    private int quantity;
}
