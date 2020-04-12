package com.esiea.tp4A;

import java.util.Iterator;

public class MarsRoverAction {
    
    public static int[] roll(int[] xy, Direction d, char letter) {
        if ((letter != 'f') && (letter != 'b'))
            return xy;
        int[] xyRet = xy.clone(); int dirIdx = d.ordinal(), inc = (dirIdx < 2) ? -1 : 1;
        if (letter == 'f')
            inc *= -1;
        xyRet[(dirIdx + 1) % 2] = xy[(dirIdx + 1) % 2] + inc;
        return xyRet;
    }
    
    public static Direction rotate(Direction d, char letter) {
        int dirIdx = d.ordinal();
        if (letter == 'r')
            return Direction.values()[(dirIdx + 1) % 4];
        if (letter == 'l')
            dirIdx = (dirIdx == 0) ? 3 : (dirIdx - 1);
        return Direction.values()[dirIdx];
    }
    
    public static Position detectObstacle(int[] pos, Direction d, int range, PlanetMapImpl map) {
    	Iterator<Position> it = map.obstaclePositions().iterator(); int dirIdx = d.ordinal(), axisCommon = dirIdx % 2, axisDiff = (axisCommon + 1) % 2, sens = (dirIdx < 2) ? 1 : -1;
    	while(it.hasNext()){
            Position current = it.next(); int[] currentXY = {current.getX(), current.getY()};
            if (currentXY[axisCommon] == map.convert(pos[axisCommon], axisCommon) && currentXY[axisDiff] == map.convert(pos[axisDiff] + range * sens, axisDiff))
                return current;
        }
        return null;
    }
    
    public static void shoot(int[] pos, Direction d, int range, PlanetMapImpl map) {
        for(int checkedRange = 0 ; checkedRange <= range ; checkedRange++){
        	Position obstaclePosition = MarsRoverAction.detectObstacle(pos, d, checkedRange, map);
        	if (obstaclePosition != null) {
            	map.obstaclePositions().remove(obstaclePosition);
            	break;
        	}
        }
    }
}

