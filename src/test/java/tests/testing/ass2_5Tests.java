package tests.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Go to URL: https://opensource-demo.orangehrmlive.com/
//Login with negative credentilas by Data Provider.
//Then assert that ‘’Invalid credentials’’ is displayed.
//Run it parallel with 3 threads
//Generate Allure report



public class ass2_5Tests extends Tests{
    @DataProvider(name = "credentilas")
    public Object[][] getData(){
        return new Object[][]{
                {"admin*","admin123"},
                {"admin12","123"},
                {"Admin1","***00**"},
                {"test","123"},
                {"user","369"},

        };
    }
    @Test(dataProvider = "credentilas")
    public void test01(String userName , String password) throws InterruptedException {
        bot.navigate("https://opensource-demo.orangehrmlive.com/");

        bot.type(By.name("username"), userName);
        bot.type(By.name("password"), password);
        bot.click(By.tagName("button"));

        String expectedErrorMessage = "Invalid credentials";
        Thread.sleep(15000);

        String actualErrorMessage = driver.findElement(By.xpath("//*[.='Invalid credentials']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials");

    }
}