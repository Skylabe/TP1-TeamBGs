package com.esiea.tp4A.domain.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MarsRoverImplTest {

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "4, 7, 11"
    })
    void testMain(int x, int y, int D) {
        new MarsRoverImpl();
        MarsRoverImpl.main("1", "2");
        assertEquals(x, y);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "4, 7, 11"
    })
    void testInitialize(int x, int y, int D) {
        assertEquals(x, y);
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

