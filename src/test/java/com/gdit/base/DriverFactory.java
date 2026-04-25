package com.gdit.base;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties config = new Properties();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {

        loadConfig();

        String browser = config.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(config.getProperty("headless", "false"));

        WebDriver localDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                localDriver = new ChromeDriver(options);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                localDriver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.set(localDriver);

        getDriver().get(config.getProperty("url"));
    }

    private static void loadConfig() {

        if (!config.isEmpty()) return;

        try (InputStream is = DriverFactory.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            config.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // VERY IMPORTANT for parallel
        }
    }
}