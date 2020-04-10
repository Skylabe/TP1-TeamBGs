package com.esiea.tp4A;

import java.util.Set;
import java.util.HashSet;

public class PlanetMapImpl implements PlanetMap {
    private final int[] size;

    public PlanetMapImpl(int[] size) {
        // METTRE LES OBSTACLES C'EST RAPIDE VOIR TESTS
        this.size = size;
    }
    
    @Override
    public Set<Position> obstaclePositions(){
        Set<Position> mapObstacles = new HashSet<Position>();
//        for (int x = 10; x < 20; x++) {
//            for (int y = 10; y < 20; y++)
//                mapObstacles.add(Position.of(x, y, Direction.NORTH));
//        }
        return mapObstacles;
    }
    
    // taille totale de la map (pour les delimitations)
    public int[] getSize() {
        return size;
    }
    
    public int convert(int coord, int axisIdx) {
        int convCoord = coord % size[axisIdx];
        if ((coord < 0) && (coord < convCoord)) convCoord++;
        if (convCoord == -(size[axisIdx] / 2)) convCoord = size[axisIdx] / 2;
        else if (Math.abs(convCoord) > (size[axisIdx] / 2)) {
            int sign = (coord > 0) ? -1 : 1;
            convCoord = sign * size[axisIdx] % convCoord;
        } return convCoord;
    }
}

