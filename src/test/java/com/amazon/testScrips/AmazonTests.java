package com.amazon.testScrips;

import com.amazon.utilies.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonTests extends BaseClass
{
    @Test(groups = {"smoke","sanity"},priority = 2,invocationCount = 2,dependsOnMethods = "test2")
    public void test1()
    {
        System.out.println("smoke, sanity");
        //Assert.fail("invocation fail");

    }

    @Test(groups = {"smoke"},priority = 1)
    public void test2()
    {
        System.out.println("smoke");
       // Assert.fail("depends fail");
    }

    @Test(groups = {"sanity"},priority = 3)
    public void test3()
    {
        System.out.println("sanity");
    }

    @Test(groups = {"smoke","regresion"},priority = -1)
    public void test4()
    {
        System.out.println("smoke and regresion");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvFunc() {
        Object[][] data = new Object[2][2];
        data[0][0] = "ABC";
        data[0][1] = "Password@123";


        data[1][0] = "XYZ";
        data[1][1] = "Password@321";
        

        return data;

    }
    @Test(dataProvider = "loginData",groups = {"smoke"})
    public void test5(String userName, String password)
    {
        System.out.println("User Name = "+userName+" Password = "+password);
    }

}
