package com.esiea.tp4A;


import java.util.Set;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class PlanetMapImplTest{
    int[] planetDims = {10, 10};
    PlanetMapImpl planet = new PlanetMapImpl(planetDims);
    
    @ParameterizedTest
    @CsvSource({
        "1 1",
        "4 7 85 2 64 555",
    }) // tester erreurs
    void testObstaclePositions(String args){
        String[] coordsObstacles = args.split(" "); Set<Position> planetObstacles = planet.obstaclePositions(); int nbObstacles = coordsObstacles.length / 2;
        planet.setObstaclePositions(coordsObstacles);
        assertEquals((nbObstacles), planetObstacles.size());
        Iterator<Position> itPlanetObs = planetObstacles.iterator();
        for (int idx = 0; idx < nbObstacles; idx += 2) {
            Position posObstacle = itPlanetObs.next();
            //System.out.println("checker ici");
            System.out.println("checker ici");
            System.out.println("checker ici"); // chelou mais sans ca ca marche pas (en ajoutant ou suppr une ligne) tester sur autre editeur
            int x = Integer.parseInt(coordsObstacles[idx]); int y = Integer.parseInt(coordsObstacles[idx + 1]);
            assertEquals(x, posObstacle.getX());
            assertEquals(y, posObstacle.getY());
            assertEquals(Direction.NORTH, posObstacle.getDirection());
        }
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

