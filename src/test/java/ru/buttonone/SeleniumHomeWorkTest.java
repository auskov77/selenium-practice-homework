package ru.buttonone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumHomeWorkTest {

    @Test
    public void shouldHaveCorrectOpenGoogle(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.ru/");

        driver.navigate().to("https://ya.ru/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().refresh();

        WebElement element_1 = driver.findElement(By.id("tophf"));
        System.out.println(element_1.getTagName());

        System.out.println();
        WebElement element_2 = driver.findElement(By.name("btnI"));
        System.out.println(element_2.getDomAttribute("value"));

        System.out.println();
        WebElement element_3 = driver.findElement(By.className("ktLKi"));
        System.out.println(element_3.getText());

        System.out.println();
        List<WebElement> tagsDiv = driver.findElements(By.tagName("div"));
        for (WebElement el: tagsDiv){
            System.out.println(el.getText());
        }

        WebElement element_4 = driver.findElement(By.linkText("Картинки"));
        element_4.click();

        WebElement element_5 = driver.findElement(By.partialLinkText("Как работает"));
        element_5.click();

        System.out.println();
        WebElement element_6 = driver.findElement(By.className("header__title"));
        System.out.println(element_6.getText());
        Assertions.assertEquals(element_6.getText(), "Search");

        driver.quit();
    }
}
