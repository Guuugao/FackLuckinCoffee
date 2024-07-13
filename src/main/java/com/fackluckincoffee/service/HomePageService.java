package com.fackluckincoffee.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fackluckincoffee.entity.HomePage.Advertisement;
import com.fackluckincoffee.entity.HomePage.BrandIntroduction;
import com.fackluckincoffee.entity.HomePage.HomePageResponse;
import com.fackluckincoffee.mapper.HomePage.AdvertisementMapper;
import com.fackluckincoffee.mapper.HomePage.BrandIntroductionMapper;
import com.fackluckincoffee.mapper.HomePage.NewProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {
    @Autowired
    private AdvertisementMapper advertisementMapper;
    @Autowired
    private BrandIntroductionMapper brandIntroductionMapper;
    @Autowired
    private NewProductsMapper newProductsMapper;

    public HomePageResponse getHomePage(){
        HomePageResponse homePageResponse = new HomePageResponse();

        QueryWrapper<Advertisement> advertisementQueryWrapper = new QueryWrapper<>();
        advertisementQueryWrapper.last("limit 1");
        QueryWrapper<BrandIntroduction> brandIntroductionWapper = new QueryWrapper<>();
        advertisementQueryWrapper.last("limit 1");

        homePageResponse.setAdvertisement(advertisementMapper.selectOne(advertisementQueryWrapper))
                    .setNewProducts(newProductsMapper.selectList(null))
                    .setBrandIntroduction(brandIntroductionMapper.selectOne(brandIntroductionWapper).getContent());

        return homePageResponse;
    }
}
