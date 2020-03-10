package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverImplTest {

    // Permet de tester le constructeur
    @ParameterizedTest
    @CsvSource({
        "1, 1, NORTH",
        "1, 1, SOUTH",
        "1, 1, EAST",
        "1, 1, WEST",
        "-51, 38, TEST",
    })
    void testMain(String x, String y, String d) {
        String[] args = {x, y, d};
        MarsRoverImpl.main(args);
        //assertEquals(x, y);
        //"{1, 1, NORTH}"
    }

//    default MarsRover testUpdateMap(PlanetMap map) {
//        return this;
//    }

//    default MarsRover testConfigureLaserRange(int range) {
//        return this;
//    }

    @ParameterizedTest
    @CsvSource({
        "f, 1, 1, NORTH, 1, 2, NORTH",
        "b, 1, 1, NORTH, 1, 0, SOUTH",
        "f, 1, 1, NORTH, 1, 2, NORTH"
    })
    void testMove(String command, int x) {
//        Position pos = Position.of();
//        marsRover
    }
}

