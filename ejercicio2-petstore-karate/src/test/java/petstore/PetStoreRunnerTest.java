package petstore;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetStoreRunnerTest {

    @Test
    void ejecutarPruebasPetStore() {
        Results resultados = Runner.path("classpath:features")
                .tags("~@ignore")
                .outputCucumberJson(true)
                .parallel(1);
        assertEquals(0, resultados.getFailCount(), resultados.getErrorMessages());
    }
}
