package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class Constant {
    public static final String MyDriver = "\"webdriver.chrome.driver\", \"C:\\\\chromedriver.exe\")";
    public static final String RSI30_URL = "https://stock-screener.org/rsi-below-30.aspx";
    public static final String RSI30_TABLE1_URL = "//table[@class=\"styled\"]/tbody/tr[*]/td[1]";

    public void CompareFiles() throws IOException {
        List<String> list = Files.readAllLines(new File("new.txt").toPath(), Charset.defaultCharset());
        List<String> list2 = Files.readAllLines(new File("popularTickers.txt").toPath(), Charset.defaultCharset());
        Collections.sort(list);
        Collections.sort(list2);
        System.out.println(list.size());
        System.out.println(list2.size());
        PrintStream output = new PrintStream(new File("finalTeckers.txt"));

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list.get(i).equals(list2.get(j))) {
                    System.out.println("final " + list.get(i));
                    output.println(list.get(i));
                }
            }
        }

    }
}

