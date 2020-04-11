package com.esiea.tp4A;

import java.util.Set;
import java.util.HashSet;

public class PlanetMapImpl implements PlanetMap {
    private final int[] size;
    private final Set<Position> obstacles = new HashSet<Position>();

    public PlanetMapImpl(int[] size) {
        this.size = size;
    }

    public void setObstaclePositions(String[] args) {
        for (int idx = 0; idx < args.length; idx += 2)
            obstacles.add(Position.of(Integer.parseInt(args[idx]), Integer.parseInt(args[idx + 1]), Direction.NORTH));
    }
    
    @Override
    public Set<Position> obstaclePositions() {
        return obstacles;
    }

    public static boolean compPos(Position posRef, Position posComp) {
        if ((posRef.getX() != posComp.getX()) || (posRef.getY() != posComp.getY()) || (posRef.getDirection() != posComp.getDirection()))
            return false;
        return true;
    }
    
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

