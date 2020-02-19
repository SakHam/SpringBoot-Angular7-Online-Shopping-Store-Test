package me.zhulin.shopapi.service.impl;

import me.zhulin.shopapi.entity.ProductCategory;
import me.zhulin.shopapi.repository.ProductCategoryRepository;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    ProductCategory productCategory = new ProductCategory("String1",1);
    ProductCategory productCategory1 = new ProductCategory("String2",2);

    @Mock
    ProductCategoryRepository productCategoryRepositoryMock;

    @InjectMocks
    CategoryServiceImpl categoryServiceImpl;


    @Test
    public void findAllTest() {
        //ProductCategoryRepository productCategoryRepositoryMock = mock(ProductCategoryRepository.class);
        //CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl(productCategoryRepositoryMock);
        List<ProductCategory> list1 = new ArrayList<ProductCategory>();
        list1.add(productCategory);
        list1.add(productCategory1);
        //when(productCategoryRepositoryMock.findAll()).thenReturn(list1);

        when(productCategoryRepositoryMock.findAllByOrderByCategoryType()).thenReturn(list1);
        try {

            assertEquals(list1, categoryServiceImpl.findAll());
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findAllTest)");
            throw e;
        }
        System.out.println("Equal (findAllTest)");

    }

    @Test
    public void findByCategoryTypeTest() {
        //ProductCategoryRepository productCategoryRepositoryMock = mock(ProductCategoryRepository.class);
        //CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl(productCategoryRepositoryMock);
        when(productCategoryRepositoryMock.findByCategoryType(anyInt())).thenReturn(productCategory);
        try {

            assertEquals(productCategory, categoryServiceImpl.findByCategoryType(anyInt()));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findByCategoryTypeTest)");
            throw e;
        }
        System.out.println("Equal (findByCategoryTypeTest)");

    }

    @Test
    public void findByCategoryTypeInTest() {
        //ProductCategoryRepository productCategoryRepositoryMock = mock(ProductCategoryRepository.class);
        //CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl(productCategoryRepositoryMock);
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        List<ProductCategory> list1 = new ArrayList<ProductCategory>();
        list1.add(productCategory);
        list1.add(productCategory1);
        when(productCategoryRepositoryMock.findByCategoryTypeInOrderByCategoryTypeAsc(list)).thenReturn(list1);
        try {

            assertEquals(list1, categoryServiceImpl.findByCategoryTypeIn(list));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (findByCategoryTypeInTest)");
            throw e;
        }
        System.out.println("Equal (findByCategoryTypeInTest)");

    }

    @Test
    public void saveTest() {
        //ProductCategoryRepository productCategoryRepositoryMock = mock(ProductCategoryRepository.class);
        //CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl(productCategoryRepositoryMock);

        when(productCategoryRepositoryMock.save(productCategory1)).thenReturn(productCategory1);
        try {

            assertEquals(productCategory1, categoryServiceImpl.save(productCategory1));
        }
        catch (AssertionError e) {
            System.out.println("Not equal (saveTest)");
            throw e;
        }
        System.out.println("Equal (saveTest)");

    }
}

