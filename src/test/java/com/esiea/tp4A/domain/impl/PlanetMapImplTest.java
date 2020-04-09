package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlanetMapImplTest{
    private int[] planetDims = {10, 10};
    private PlanetMapImpl planet = new PlanetMapImpl(planetDims);
    
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
        int[] size = planet.getSize();
        assertEquals(size.length, 2);
        for (int dim : size)
            assertTrue(dim > 0);
    }
}

