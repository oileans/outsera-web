package support;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {
    @Before
    public void beforeScenario() {
        DriverManager.iniciar();
    }

    @After
    public void afterScenario() {
        DriverManager.finalizar();
    }
}