package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

/*   Go to URL: http://facebook.com
       getCookies,
       addCookie,
       deleteCookieNamed,
       deleteAllCookies
    */
public class As5_4 extends Tests{
    @Test
    public void cookieTest(){
        driver.navigate().to("http://facebook.com");
        // Getting all cookies
        System.out.println("All Cookie: " + driver.manage().getCookies());

        Cookie addCookie = new Cookie("Njood" ,"saad");
        driver.manage().addCookie(addCookie);
        driver.manage().deleteCookieNamed("Njood");
        driver.manage().deleteAllCookies();


    }
}