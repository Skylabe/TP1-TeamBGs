package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Test;

class MarsRoverImplTest {
    private final int[] planetDims = {5, 5};
    private final PlanetMapImpl planet = new PlanetMapImpl(planetDims);

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImpl.csv")
    void testMarsRoverImpl(int x, int y, Direction d) {
        MarsRoverImpl rover = new MarsRoverImpl(x, y, d, planet, 3);
        assertTrue(PlanetMapImpl.compPos(Position.of(x, y, d), rover.getPosition()));
    }

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplLaser.csv")
    void testConfigureLaserRange(int range, String obstacle, int nbObsRem) {
        MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planet, range);
        planet.setObstaclePositions(obstacle.split(" "));
        rover.move("s");
        assertEquals(nbObsRem, planet.obstaclePositions().size());
    }

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplMove.csv")
    void testMove(int x, int y, Direction d, String command, String obstacles) {
        MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planet, 3);
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

