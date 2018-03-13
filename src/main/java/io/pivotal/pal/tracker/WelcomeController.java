package io.pivotal.pal.tracker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String sayHello(@Value("${WELCOME_MESSAGE}") String message) {
        return message;
    }
}