package com.academy.techcenture;

import org.junit.*;

public class JunitExample {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("running before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("running after class");
    }


    @Before
    public void before(){
        System.out.println("before each test case");
    }

    @After
    public void after(){
        System.out.println("after each test case");
    }

    @Test
    public void test1(){
        Assert.assertEquals("not matching",54, 54);
    }

    @Test
    public void test2(){
        Assert.assertTrue("not matching", 56 == 56);
    }

    @Test
    public void test3(){
        Assert.assertNotEquals("not matching",54, 57);
    }

    @Test
    public void test4(){
        Assert.assertFalse("not matching", 56 == 57);
    }

}
