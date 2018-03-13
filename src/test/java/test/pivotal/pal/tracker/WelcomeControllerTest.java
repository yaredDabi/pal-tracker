package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.WelcomeController;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomeControllerTest {

    @Test
    public void itSaysHello() throws Exception {
        WelcomeController controller = new WelcomeController();
        assertThat(controller.sayHello("A welcome message")).isEqualTo("A welcome message");
    }
}
