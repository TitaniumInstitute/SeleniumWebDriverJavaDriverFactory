package com.titanium.testcases;

import com.titanium.base.BrowserType;
import com.titanium.base.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverFactoryTest {
    String baseURL = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";

    @BeforeTest
    @Parameters("browser")
    void setup(String browser){
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
    }

    @AfterTest
    void turnDown(){
        DriverFactory.getInstance().removeDriver();
    }

    @Test
    void test(){
        DriverFactory.getInstance().getDriver().navigate().to(baseURL);
    }
}
