package com.fackluckincoffee.entity.OrderPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String userId;
    private List<OrderItemRequest> items;
}
