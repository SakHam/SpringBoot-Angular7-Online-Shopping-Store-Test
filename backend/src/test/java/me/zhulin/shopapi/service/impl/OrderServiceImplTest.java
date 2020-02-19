package me.zhulin.shopapi.service.impl;

import me.zhulin.shopapi.entity.OrderMain;
import me.zhulin.shopapi.entity.ProductCategory;
import me.zhulin.shopapi.entity.User;
import me.zhulin.shopapi.repository.OrderRepository;
//import org.junit.jupiter.api.Test;
import me.zhulin.shopapi.repository.OrderRepository;
import me.zhulin.shopapi.repository.ProductCategoryRepository;
import org.junit.Test;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
    User user =new User("email.com","password","name","1234567890","address",true);
    User user1 =new User("email1.com","password1","name1","1234567890","address1",true);

    OrderMain orderMain = new OrderMain(user);
    OrderMain orderMain1 = new OrderMain(user1);
    //Page<OrderMain> page  = new ArrayList<OrderMain>();
    Pageable pageable = PageRequest.of(0, 20);

    Page<OrderMain> pagedResponse = new PageImpl((List) orderMain);

    @Mock
    OrderRepository orderRepositoryMock;

    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    @Test
    public void findAll() {
        when(orderRepositoryMock.findAllByOrderByOrderStatusAscCreateTimeDesc(pageable)).thenReturn(pagedResponse);
        try {

            assertEquals(pagedResponse, orderServiceImpl.findAll(pageable));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findAllTest)");
            throw e;
        }
        System.out.println("Equal (findAllTest)");

    }

    @Test
    public void findByStatus() {
    }

    @Test
    public void findByBuyerEmail() {
    }

    @Test
    public void findByBuyerPhone() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void cancel() {
    }
}