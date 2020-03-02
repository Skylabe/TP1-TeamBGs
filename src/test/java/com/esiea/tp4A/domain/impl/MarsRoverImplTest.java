package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverImplTest {

    @ParameterizedTest
    @CsvSource({
        "1, 1, NORTH",
        "1, 1, SOUTH",
        "1, 1, EAST",
        "1, 1, WEST",
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

//    default Position testMove(String command) {
//        return Position.of(0, 0, Direction.NORTH);
//    }
}

