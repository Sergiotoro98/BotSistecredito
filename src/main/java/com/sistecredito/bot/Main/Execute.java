package com.sistecredito.bot.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Execute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);

        driver.get("https://csm3.serviceaide.com/#login");

        Thread.sleep(5000);

        driver.findElement(
                        By.id("textfield-1016-inputEl"))
                .sendKeys("analistadbapp-marco@arus.com.co", Keys.TAB);

        driver.findElement(
                        By.id("textfield-1017-inputEl"))
                .sendKeys("Arus2021**+Octubre");

        driver.findElement(
                        By.id("button-1021-btnEl"))
                .click();

        Thread.sleep(20000);

        WebElement ticket;
        int ticketCounter = 2;
        String ticketPath;
        String validation;

        do {
            ticketPath = "/html/body/div[3]/div[2]/div[1]/div/div[2]/div/div[1]/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[5]/div/table/tbody/tr["+ ticketCounter +"]/td/div/table/tbody/tr[1]/td[5]/div/div/table/tbody/tr[3]/td[1]";
            ticket = driver.findElement(By.xpath(ticketPath));
            validation = ticket.getText();
            if (!validation.equals("En cola | Asignación")) ticketCounter++;

        }while (!validation.equals("En cola | Asignación"));


        actions.doubleClick(ticket).perform();

        Thread.sleep(5000);
//        driver.close();
    }
}
