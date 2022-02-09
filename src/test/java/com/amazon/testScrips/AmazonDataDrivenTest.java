package com.amazon.testScrips;

import com.amazon.utilies.BaseClass;
import org.testng.annotations.Test;

public class AmazonDataDrivenTest extends BaseClass
{
    @Test(dataProvider = "loginData",groups = {"smoke"}, dataProviderClass = AmazonTests.class)
    public void dataProviderTest(String userName, String password)
    {
        System.out.println("User Name = "+userName+" Password = "+password);
    }
}
