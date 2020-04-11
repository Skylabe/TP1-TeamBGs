package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
    void testMove(int x, int y, Direction d, String command) {
        MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planet);
        Position pos = rover.move(command);
        assertTrue(PlanetMapImpl.compPos(Position.of(x, y, d), pos));
    }
    
    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplDetectObstacle.csv")
    void testDetectObstacle(int roverX, int roverY, int obsNoX, int obsNoY, int obsOkX, int obsOkY, int idDir, int range) {
        MarsRoverImpl rover = new MarsRoverImpl(roverX, roverY, Direction.NORTH, planet);

        // When TIRE SANS OBSTACLE
        String[] obs = {Integer.toString(obsNoX), Integer.toString(obsNoY)};
        planet.setObstaclePositions(obs);
        int[] posRover = {roverX,roverY};
        Position pos = rover.detectObstacle(posRover, idDir, range);
        // Then
        assertNull(pos);

       
        // When TIRE A L'EST AVEC OBSTACLE avec range 1
        obs[0] = Integer.toString(obsOkX);obs[1]=Integer.toString(obsOkY);
        planet.setObstaclePositions(obs);
        pos = rover.detectObstacle(posRover, idDir, range);
        // Then
        assertNotNull(pos);  
    }
    
    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplMoveWithObstacle.csv")
    void testMoveWithObstacle(int roverX, int roverY, Direction d, int posX, int posY, String command, int trueEndX, int trueEndY, Direction trueEndD){
        MarsRoverImpl rover = new MarsRoverImpl(roverX, roverY, d, planet);
        String[] obs = {Integer.toString(posX), Integer.toString(posY)};
        planet.setObstaclePositions(obs);
        Position pos = rover.move(command);
        assertTrue(pos.getX() == trueEndX);
        assertTrue(pos.getY() == trueEndY);
        assertTrue(pos.getDirection() == trueEndD);
    }
}

