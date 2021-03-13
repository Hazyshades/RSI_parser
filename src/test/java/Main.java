import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

import static common.Constant.RSI30_URL;

public class Main {

    public static void go () throws IOException {
        Runtime.getRuntime().exec("java -jar /path/to/program.jar");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        //Создан экземпляр класса Webdriver - в него помещаем метод ChromeD
        WebDriver driver = new ChromeDriver();
        driver.get(RSI30_URL);
        // Узнаем количество Symbol в таблице
        List<String> list2 = Files.readAllLines(new File("popularTickers.txt").toPath(), Charset.defaultCharset());
        PrintStream output = new PrintStream(new File("C:\\IdeaProjects\\BotRSI_py\\finalTeckers3.txt"));
        List<WebElement> list5 = driver.findElements(By.cssSelector("table.styled tbody tr td:nth-child(1)"));

        List<String> list3 = new ArrayList<String>();
        for (WebElement s: list5){
            list3.add(s.getText());
        }

        Collections.sort(list3);
        Collections.sort(list2);

        list3.retainAll(list2);

        for (int i=0; i<list3.size(); i++){
            System.out.println(list3.get(i));
            output.println(list3.get(i));
            driver.quit();

        }
    }}
