package com.esiea.tp4A;

import java.util.Set;
import java.util.HashSet;

public class PlanetMapImpl implements PlanetMap {

    public PlanetMapImpl() {
        // a voir pour faire evoluer
        
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
        int[] size = {100, 100};
        return size;
    }
}

