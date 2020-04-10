package com.esiea.tp4A;

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
            }
        }
        return Position.of(map.convert(xy[0], 0), map.convert(xy[1], 1), d); // tester ca aussi
    }
    
    public Position getPosition() {
        return position;
    }
}

