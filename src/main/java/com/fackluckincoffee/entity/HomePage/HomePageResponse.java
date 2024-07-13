package com.fackluckincoffee.entity.HomePage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomePageResponse {
    private Advertisement advertisement;
    private List<NewProduct> newProducts;
    private String brandIntroduction;
}
