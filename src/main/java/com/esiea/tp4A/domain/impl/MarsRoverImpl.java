package com.esiea.tp4A;

public class MarsRoverImpl implements MarsRover {
    private final PlanetMapImpl map;
    private final Position position;

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
        int[] xy = {position.getX(), position.getY()}; Direction d = position.getDirection();
        for (int idx = 0; idx < command.length(); idx++) {
            xy = (MarsRoverAction.detectObstacle(xy, moveDirection(command.charAt(idx), d), 1, map) == null) ? MarsRoverAction.roll(xy, d, command.charAt(idx)) : xy;
            d = MarsRoverAction.rotate(d, command.charAt(idx));
            if (command.charAt(idx) == 's') MarsRoverAction.shoot(xy, d, 3, map);
        }
        return Position.of(map.convert(xy[0], 0), map.convert(xy[1], 1), d);
    }
    
    public Position getPosition() {
        return position;
    }
    
    public static Direction moveDirection(char letter, Direction d) {
        if (letter == 'b')
            return Direction.values()[(d.ordinal() + 2) % 4];
        return d;
    }
}

