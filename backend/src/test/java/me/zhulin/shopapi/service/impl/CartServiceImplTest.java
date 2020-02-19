package me.zhulin.shopapi.service.impl;

import me.zhulin.shopapi.entity.User;

//import org.junit.jupiter.api.Test;
import me.zhulin.shopapi.repository.CartRepository;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartServiceImplTest {
    User user =new User("email","password","name","1234567890","address",true);
    //Cart cart =new Cart(user);

    //CartRepository cartRepository = new cartRepository;
    @Test
    void getCartTest() {
        CartServiceImpl cartServiceImpl = new CartServiceImpl();

        try {

            assertEquals(cartServiceImpl.getCart(user), user.getCart());
        }
        catch (AssertionError e) {
            System.out.println("Not equal (getCartTest)");
            throw e;
        }
        System.out.println("Equal (getCartTest)");
    }

    @Test
    void mergeLocalCartTest() {
    }

    @Test
    void deleteTest() {
    }

    @Test
    void checkoutTest() {
    }
}