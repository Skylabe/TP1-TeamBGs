package com.esiea.tp4A;

import java.util.Set;
import java.util.HashSet;

public class PlanetMapImpl implements PlanetMap {
    private int[] size = new int[2];

    public PlanetMapImpl(int[] size) {
        // a voir pour faire evoluer
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
}

