package com.esiea.tp4A;

import java.util.Iterator;
import java.util.Set;


public class MarsRoverImpl implements MarsRover {
    private PlanetMapImpl map;
    private Position position;

    public MarsRoverImpl(int x, int y, Direction dir, PlanetMapImpl map) {
        position = Position.of(x, y, dir);
        this.map = map;
        //this.initialize(position);
    }

    /*public MarsRover initialize(Position position) {
        //map = new PlanetMapImpl();
        position = position;
        //map = new PlanetMap(100, 100);
        return this;
    }*/

// checker ici si la position retournee par move appartient a l'un des obstacles de la map
// Si non, affecter a "this.position" la valeur retournee par move
// Si la taille de la planete fait 100x100 et que le rover passe de (0,50,N) a 51, la fonction doit se charger de mettre
// -49 a la place
//    default MarsRover updateMap(PlanetMap map) {
//        return this;
//    }

//    default MarsRover configureLaserRange(int range) {
//        return this;
//    }

    public Position move(String command) {
        int[] xy = {position.getX(), position.getY()};
        Direction d = position.getDirection();
        for (int idx = 0; idx < command.length(); idx++) {
            int dirIdx = d.ordinal(), inc = (dirIdx < 2) ? -1 : 1; // juste pour les deux premiers cas
            if(detectObstacle(xy, dirIdx, 1) == null || (detectObstacle(xy, dirIdx, 1) != null && command.charAt(idx) != 'f' && command.charAt(idx) != 'b')){
                switch (command.charAt(idx)) {
                    case 'f':
                        inc = inc * -1;
                    case 'b':
                        xy[(dirIdx + 1) % 2] = xy[(dirIdx + 1) % 2] + inc;
                        break;
                    case 'l':
                        dirIdx = (dirIdx == 0) ? 3 : (dirIdx - 1);
                        d = Direction.values()[dirIdx];
                        break;
                    case 'r':
                        d = Direction.values()[(dirIdx + 1) % 4];
                        break;
                    case 's':
                    	shoot(xy, dirIdx, 3);
                }
            }  
        }
        return Position.of(map.convert(xy[0], 0), map.convert(xy[1], 1), d); // tester ca aussi
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Position detectObstacle(int[] pos, int dirIdx, int range) {
    	Set<Position> obstacles = map.obstaclePositions();
    	Iterator<Position> it = obstacles.iterator();
    	while(it.hasNext()){
            Position current = it.next();
            
            for(int i = 1 ; i <= range ; i++){
                switch(dirIdx){
                    case 0:
                        if(current.getX() == pos[0] && current.getY() == map.convert(pos[1]+i, 1))
                            return current;
                        break;
                    case 1:
                        if(current.getX() == map.convert(pos[0]+i, 0) && current.getY() == pos[1])
                            return current;
                        break;
                    case 2:
                        if(current.getX() == pos[0] && current.getY() == map.convert(pos[1]-i, 1))
                            return current;
                        break;
                    case 3:
                        if(current.getX() == map.convert(pos[0]-i, 0) && current.getY() == pos[1])
                            return current;
                        break;
                }
            }
        }
        return null;
    }
    
    public void shoot(int[] pos, int dirIdx, int range) {
    	Position obstaclePosition = detectObstacle(pos, dirIdx, range);
    	if(obstaclePosition != null) {
    		Set<Position> obstacles = map.obstaclePositions();
        	obstacles.remove(obstaclePosition);
    	}
    	
    }
}

