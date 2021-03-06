package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.io.ByteArrayInputStream;

class MarsRoverConsoleTest {

    // Permet de tester que le main ne leve pas d'erreur en cas de mauvais arguments et de faire des simulations
    @ParameterizedTest
    @CsvFileSource(resources = "/MarsRoverConsole.csv")
    void testMain(String x, String y, String d, String laserRange, String obstacles) {
        String[] args = {x, y, d, laserRange, "5", "5"};
        for (int idx = 0; idx < 3; idx++) {
            if (args[idx].equals("EMPTY"))
                args[idx] = null;
        }
        System.setIn(new ByteArrayInputStream("end\r\n".getBytes()));
        MarsRoverConsole.main((String.join(" ", args) + " " + obstacles).split(" "));
    }
    
    // Optionnel
    @ParameterizedTest
    @CsvFileSource(resources = "/MarsRoverConsole.csv", numLinesToSkip = 5)
    void testConstructor(int x, int y, Direction d, int laserRange, String osbtacles) {
        String userInput = "end\r\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        new MarsRoverConsole(x, y, d, laserRange, 5, 5, osbtacles.split(" "));
    }

    @Test
    void testStringToDirection() {
        assertEquals(MarsRoverConsole.stringToDirection("NORTH"), Direction.NORTH);
        assertEquals(MarsRoverConsole.stringToDirection("EAST"), Direction.EAST);
        assertEquals(MarsRoverConsole.stringToDirection("SOUTH"), Direction.SOUTH);
        assertEquals(MarsRoverConsole.stringToDirection("WEST"), Direction.WEST);
        assertEquals(MarsRoverConsole.stringToDirection("TEST"), null);
    }
}

