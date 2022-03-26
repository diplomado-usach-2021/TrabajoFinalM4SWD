package com;

import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static ChromeOptions options = new ChromeOptions();
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() throws MalformedURLException{
        System.out.println("seteando ");
        ChromeOptions chromeOptions = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1024,768");
        System.out.println("Iniciando configuración...");
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

     @Test
    public void test10xc() {
        System.out.println("Starting 10xc");
        driver.get("http://localhost:3000/");
        System.out.println("ejecucion");
        
        try {
            Thread.sleep(3000);
            WebElement retirarInput = driver.findElement(By.className("MuiCardMedia-img"));
            retirarInput.click();
            Thread.sleep(1000);
            WebElement montoAhorro = driver.findElement(By.id("ahorro"));
            WebElement sueldo = driver.findElement(By.id("sueldo"));
            
            montoAhorro.sendKeys("40000000");
            sueldo.sendKeys("2000000");

            Thread.sleep(1000);

            sueldo.submit();

            Thread.sleep(14000);

            WebElement getAmount = driver.findElement(By.id("getAmount"));
            WebElement getAvailable = driver.findElement(By.id("getAvailable"));
            WebElement getTax = driver.findElement(By.id("getTax"));

            // parsing to string

            String retirar = getAmount.getText();
            String disponible = getAvailable.getText();
            String impuesto = getTax.getText();

            System.out.println("retirar 1" + retirar);
            System.out.println("disponible 1" + disponible);
            System.out.println("impuesto 1" + impuesto);

            // asserts

            Assert.assertEquals("$4.000.000".equals(retirar), true);
            Assert.assertEquals("$36.000.000".equals(disponible), true);
            Assert.assertEquals("$600.000".equals(impuesto), true);

        }catch(Exception e) {
            System.out.println(e);
        }
    }     
    
}