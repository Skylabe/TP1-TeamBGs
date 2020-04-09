package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MarsRoverImplTest {

    // pas besoin de tester juste pour avoir des tests plus propres
    boolean posEquals(Position posRef, Position posComp) {
        if (posRef.getX() != posComp.getX())
            return false;
        else if (posRef.getY() != posComp.getY())
            return false;
        else if (posRef.getDirection() != posComp.getDirection())
            return false;
        return true;
    }

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImpl.csv")
    void testMarsRoverImpl(int x, int y, Direction d) { // ajouter taille planete
        int[] planetDims = {10, 10};
        MarsRoverImpl rover = new MarsRoverImpl(x, y, d, planetDims);
        assertTrue(posEquals(Position.of(x, y, d), rover.getPosition()));
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
        int[] planetDims = {5, 5};
        MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planetDims);
        Position pos = rover.move(command);
        assertTrue(posEquals(Position.of(x, y, d), pos));
    }

    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplOnSphericalGrid.csv")
    void testOnSphericalGrid(int x, int y, int resX, int resY, int planetWidth, int planetHeight) {
        int[] posXY = {x, y};
        int[] resPosXY = {resX, resY};
        int[] planetDims = {planetWidth, planetHeight};
        MarsRoverImpl rover = new MarsRoverImpl(0, 0, Direction.NORTH, planetDims);
        int[] retPosXY = rover.onSphericalGrid(posXY);
        assertArrayEquals(resPosXY, retPosXY);
    }
}

