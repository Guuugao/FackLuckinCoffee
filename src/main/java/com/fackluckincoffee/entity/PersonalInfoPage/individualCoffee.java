package com.fackluckincoffee.entity.PersonalInfoPage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class individualCoffee {
    private String coffeeName;
    private int quantity;
    private double price;
}
