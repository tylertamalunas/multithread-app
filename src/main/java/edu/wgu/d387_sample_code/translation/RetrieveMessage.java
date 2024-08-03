package edu.wgu.d387_sample_code.translation;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class RetrieveMessage {
    /*static ExecutorService messageExecutor = newFixedThreadPool(2);

    public static void getMessage() {
        Properties prop = new Properties();
        messageExecutor.execute(() -> {
            InputStream stream = null;
            try {
                stream = new ClassPathResource("translation_en_EN_US.properties").getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                prop.load(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(prop.getProperty("welcome"));
        });

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_FR_CA.properties").getInputStream();
                prop.load(stream);
                System.out.println(prop.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }*/

    private Locale locale;
    private ResourceBundle resourceBundle;

    public String getWelcomeMessage() {
        return resourceBundle.getString("welcome");
    }

    public RetrieveMessage(String language, String country) {
        locale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("translation_en_EN_US", locale);
        System.out.printf("%s, %s%n",language, country);
    }
}
