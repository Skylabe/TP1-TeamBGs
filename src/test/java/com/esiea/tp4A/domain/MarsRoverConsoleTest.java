package com.esiea.tp4A;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.io.ByteArrayInputStream;

class MarsRoverConsoleTest {

    // Permet de tester le main
    @ParameterizedTest
    @CsvFileSource(resources = "/MarsRoverImplStart.csv")
    void testMain(String x, String y, String d) {
        String[] args = {x, y, d};
        for (int idx = 0; idx < 3; idx++) {
            if (args[idx].equals("EMPTY"))
                args[idx] = "";
        }
        // Simule l'input de l'utilisateur, possibilite d'ajouter les inputs a executer en argument depuis un csv dedie
        // dans src/main/resources
        String userInput = "end\r\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        MarsRoverConsole.main(args);
    }
}

