package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.translation.DisplayMessage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/")
public class MessageController {

    @RequestMapping(path = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showMessage() throws InterruptedException {
        DisplayMessage enThread = new DisplayMessage(Locale.US);
        DisplayMessage frThread = new DisplayMessage(Locale.CANADA_FRENCH);

        enThread.start();
        frThread.start();

        enThread.join();
        frThread.join();

        String enMessage = enThread.getMessage();
        String frMessage = frThread.getMessage();

        return enMessage + " / " + frMessage;

    }
}