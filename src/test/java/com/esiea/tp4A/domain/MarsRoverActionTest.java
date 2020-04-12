package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MarsRoverActionTest {
    int[] planetDims = {5, 5};
    PlanetMapImpl planet = new PlanetMapImpl(planetDims);

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverActionRoll.csv")
    void testRoll(Direction d, int x, int y) {
        int[] xyStart = {0, 0}, xyF = {x, y}, xyB = {-x, -y};
        for (char letter : "lrs".toCharArray())
            assertArrayEquals(MarsRoverAction.roll(xyStart, d, letter), xyStart);
        assertArrayEquals(MarsRoverAction.roll(xyStart, d, 'f'), xyF);
        assertArrayEquals(MarsRoverAction.roll(xyStart, d, 'b'), xyB);
    }

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverActionRotate.csv")
    void testRoll(Direction d, Direction dLeft, Direction dRight) {
        for (char letter : "fbs".toCharArray())
            assertEquals(MarsRoverAction.rotate(d, letter), d);
        assertEquals(MarsRoverAction.rotate(d, 'l'), dLeft);
        assertEquals(MarsRoverAction.rotate(d, 'r'), dRight);
    }
    
    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplDetectObstacle.csv")
    void testDetectObstacle(int roverX, int roverY, int obsNoX, int obsNoY, int obsOkX, int obsOkY, int idDir, int range) {
        MarsRoverImpl rover = new MarsRoverImpl(roverX, roverY, Direction.NORTH, planet); int[] posRover = {roverX,roverY};
        String[] obs = {Integer.toString(obsNoX), Integer.toString(obsNoY)};// When TIRE SANS OBSTACLE
        planet.setObstaclePositions(obs);
        assertNull(MarsRoverAction.detectObstacle(posRover, Direction.values()[idDir], range, planet));// Then
        obs[0] = Integer.toString(obsOkX); obs[1]=Integer.toString(obsOkY);// When TIRE A L'EST AVEC OBSTACLE avec range 1
        planet.setObstaclePositions(obs);
        assertNotNull(MarsRoverAction.detectObstacle(posRover, Direction.values()[idDir], range, planet));  // Then
    }
    
    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverActionShoot.csv")
    void testShoot(int x, int y, Direction d, String coordsObstacles, int shootedObsX, int shootedObsY, int range) {
        int[] xy = {x, y}; int nbObsLess = (shootedObsX != -100) ? 1 : 0, nbObstacles = coordsObstacles.split(" ").length / 2 - nbObsLess;
        planet.setObstaclePositions(coordsObstacles.split(" "));
        MarsRoverAction.shoot(xy, d, range, planet);
        if (shootedObsX != -100) {
            for (Position obstacle : planet.obstaclePositions())
                assertFalse(PlanetMapImpl.compPos(Position.of(shootedObsX, shootedObsY, Direction.NORTH), obstacle));
        } assertEquals(nbObstacles, planet.obstaclePositions().size());
    }
}

