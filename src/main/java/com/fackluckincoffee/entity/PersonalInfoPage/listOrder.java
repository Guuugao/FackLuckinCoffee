package com.fackluckincoffee.entity.PersonalInfoPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class listOrder {
    private String orderId;
    private String date;
    private List<individualCoffee> items;
    private double totalPrice;
    private String status;
}
