package me.zhulin.shopapi.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import me.zhulin.shopapi.entity.User;
import me.zhulin.shopapi.repository.UserRepository;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


@RunWith(MockitoJUnitRunner.class)
 class UserServiceImplTest {
    User user =new User("email.com","password","name","1234567890","address",true);
    @Test
    void findOneTest() {
        String email ="email.com";
        PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class);

        UserRepository userRepositoryMock = mock(UserRepository.class);
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryMock,passwordEncoderMock);
        when(userRepositoryMock.findByEmail(email)).thenReturn(user);
        try {
            assertEquals(user, userServiceImpl.findOne(email));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findOneTest)");
            throw e;
        }
        System.out.println("Equal (findOneTest)");
    }



    @Test
    void findByRole() {
    }

    @Test
    void saveTest() {
        String psw ="password";

        PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class);
        UserRepository userRepositoryMock = mock(UserRepository.class);

        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryMock,passwordEncoderMock);
        when(passwordEncoderMock.encode(user.getPassword())).thenReturn(psw);
        when(userRepositoryMock.save(user)).thenReturn(user);


        try {
            assertEquals(user, userServiceImpl.save(user));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findOneTest)");
            throw e;
        }
        System.out.println("Equal (findOneTest)");
    }

    @Test
    void update() {
    }
}