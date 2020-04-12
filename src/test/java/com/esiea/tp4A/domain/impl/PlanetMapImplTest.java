package com.esiea.tp4A;
import java.util.Set;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class PlanetMapImplTest{
    int[] planetDims = {10, 10};
    PlanetMapImpl planet = new PlanetMapImpl(planetDims);
    
    @ParameterizedTest
    @CsvFileSource(resources="/planetMapImplCompPos.csv")
    void testComparePositions(int x1, int y1, Direction d1, int x2, int y2, Direction d2) {
        if ((x1 == x2) && (y1 == y2) && (d1 == d2))
            assertTrue(PlanetMapImpl.compPos(Position.of(x1, y1, d1), Position.of(x2, y2, d2)));
        else
            assertFalse(PlanetMapImpl.compPos(Position.of(x1, y1, d1), Position.of(x2, y2, d2)));
    }
    
    @ParameterizedTest
    @CsvSource({
        "1 1",
        "4 7 85 2 64 555"
    })
    void testObstaclePositions(String args){
        String[] coordsObstacles = args.split(" "); Set<Position> planetObstacles = planet.obstaclePositions(); boolean success;
        planet.setObstaclePositions(coordsObstacles);
        for (int idx = 0; idx < coordsObstacles.length; idx += 2) {
            success = false; int x = Integer.parseInt(coordsObstacles[idx]); int y = Integer.parseInt(coordsObstacles[idx + 1]);
            for (Position pos : planetObstacles) success = (success == true) ? true : PlanetMapImpl.compPos(Position.of(x, y, Direction.NORTH), pos);
            assertTrue(success);
        } assertEquals((coordsObstacles.length / 2), planetObstacles.size());
    }

    @Test
    void testGetSize() {
        assertArrayEquals(planetDims, planet.getSize());
    }

    @ParameterizedTest
    @CsvFileSource(resources="/planetMapImplConvert.csv")
    void testConvert(int coord, int excpectedCoord, int planetDim) {
        for (int idx = 0; idx < 1; idx++) {
            int[] planetDims = {planetDim, 10};
            planet = new PlanetMapImpl(planetDims);
            int retCoord = planet.convert(coord, idx);
            assertEquals(excpectedCoord, retCoord);
        }
    }
}

