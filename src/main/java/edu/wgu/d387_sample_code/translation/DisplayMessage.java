package edu.wgu.d387_sample_code.translation;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayMessage extends Thread {

    private final Locale locale;
    private String message;

    public DisplayMessage(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void run() {
        ResourceBundle bundle = ResourceBundle.getBundle("translation_en", locale);
        message = bundle.getString("message");
    }

    public String getMessage() {
        return message;
    }
}
