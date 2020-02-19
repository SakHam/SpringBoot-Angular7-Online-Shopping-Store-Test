package me.zhulin.shopapi.service.impl;

import me.zhulin.shopapi.entity.ProductInfo;
import me.zhulin.shopapi.enums.ProductStatusEnum;
import me.zhulin.shopapi.repository.ProductCategoryRepository;
import me.zhulin.shopapi.repository.ProductInfoRepository;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    ProductInfo productInfo = new ProductInfo();
    ProductInfo productInfo1 = new ProductInfo();


    Pageable pageable = PageRequest.of(0, 3);

    //Pageable pageable = new Pageable();
    //SpringDataWebProperties.Pageable = new SpringDataWebProperties.Pageable();
    @Mock
    ProductInfoRepository productInfoRepositoryMock;

    @InjectMocks
    ProductServiceImpl productServiceImpl;


    @Test
    public void findOne() {
        String prodId = "PrdID";
        when(productInfoRepositoryMock.findByProductId(prodId)).thenReturn(productInfo);
        try {

            assertEquals(productInfo, productServiceImpl.findOne(prodId));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findOneTest)");
            throw e;
        }
        System.out.println("Equal (findOneTest)");
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list1  = new ArrayList<ProductInfo>();
        list1.add(productInfo);
        list1.add(productInfo1);
        PageImpl page = new PageImpl(list1);
        when(productInfoRepositoryMock.findAllByProductStatusOrderByProductIdAsc(ProductStatusEnum.UP.getCode(),pageable)).thenReturn(page);
        try {

            assertEquals(page,productServiceImpl.findUpAll(pageable));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findOneTest)");
            throw e;
        }
        System.out.println("Equal (findOneTest)");

    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllInCategory() {
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }

    @Test
    public void offSale() {
    }

    @Test
    public void onSale() {
    }

    @Test
    public void update() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }
}