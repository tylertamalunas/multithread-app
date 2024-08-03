package edu.wgu.d387_sample_code.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/welcome/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public String getWelcomeMessage() {

        Future<String> englishMessageFuture = messageService.getEnglishMessage();
        Future<String> frenchMessageFuture = messageService.getFrenchMessage();

        try {
            String englishMessage = englishMessageFuture.get();
            String frenchMessage = frenchMessageFuture.get();
            return "<html><body><h1>Welcome Messages</h1>" +
                    "<p>English: " + englishMessage + "</p>" +
                    "<p>French: " + frenchMessage + "</p>" +
                    "</body></html>";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error retrieving welcome message";
        }
    }
}*/

/* katrinars?
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/welcome")
    private RetrieveMessage retrieveMessage;

    @Autowired
    public MessageController(RetrieveMessage retrieveMessage) {
        this.retrieveMessage = retrieveMessage;
    }
    @PostMapping("/message")
}
 */

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/welcome/messages")
public class MessageController {
    private Executor executor = Executors.newFixedThreadPool(2);

    @GetMapping("welcome")
    public ResponseEntity<List<String>>getWelcomeMessage() {
        List<String> welcomeMessage = new ArrayList<String>();

        executor.execute(() -> {
            RetrieveMessage english = new RetrieveMessage("en", "US");
            welcomeMessage.add(english.getWelcomeMessage());
            System.out.println("translation_en_EN_US.properties");
        });

        executor.execute(() -> {
            RetrieveMessage french = new RetrieveMessage("fr", "CA");
            welcomeMessage.add(french.getWelcomeMessage());
            System.out.println("translation_en_fr_CA.properties");
        });

        return ResponseEntity.ok(welcomeMessage);
    }

}