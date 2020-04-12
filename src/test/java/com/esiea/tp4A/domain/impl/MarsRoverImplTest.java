package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Test;

class MarsRoverImplTest {
    int[] planetDims = {5, 5};
    PlanetMapImpl planet = new PlanetMapImpl(planetDims);

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImpl.csv")
    void testMarsRoverImpl(int x, int y, Direction d) {
        MarsRoverImpl rover = new MarsRoverImpl(x, y, d, planet);
        assertTrue(PlanetMapImpl.compPos(Position.of(x, y, d), rover.getPosition()));
    }

//    default MarsRover testUpdateMap(PlanetMap map) {
//    
//        return this;
//    }

//    default MarsRover testConfigureLaserRange(int range) {
//        return this;
//    }

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplMove.csv")
    void testMove(int x, int y, Direction d, String command, String obstacles) {
        MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planet);
        if (obstacles != null)
            planet.setObstaclePositions(obstacles.split(" "));
        Position pos = rover.move(command);
        assertTrue(PlanetMapImpl.compPos(Position.of(x, y, d), pos));
    }
    
    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplMoveDirection.csv")
    void testMoveDirection(char letter, Direction d, Direction dRes) {
        assertEquals(MarsRoverImpl.moveDirection(letter, d), dRes);
    }
}

