package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class PlanetMapImplTest{
    
//    @ParameterizedTest
//    final void testobstaclePositions(){
//        Set<Position> mapObstacles = new HashSet<Position>();
//        for (int x = 10; x < 20; x++) {
//            for (int y = 10; y < 20; y++)
//                mapObstacles.add(Position.of(x, y, Direction.NORTH));
//        }
//        return mapObstacles;
//    }
//    

    @Test
    void testGetSize() {
        int[] planetDims = {10, 10};
        PlanetMapImpl planet = new PlanetMapImpl(planetDims);
        assertArrayEquals(planetDims, planet.getSize());
    }

    @ParameterizedTest
    @CsvFileSource(resources="/planetMapImplConvert.csv")
    void testConvert(int coord, int excpectedCoord, int planetDim) {
        for (int idx = 0; idx < 1; idx++) {
            int[] planetDims = {planetDim, 10};
            PlanetMapImpl planet = new PlanetMapImpl(planetDims);
            int retCoord = planet.convert(coord, idx);
            assertEquals(excpectedCoord, retCoord);
        }
    }
}

