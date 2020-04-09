package com.esiea.tp4A;

public class MarsRoverImpl implements MarsRover {
    private PlanetMapImpl map;
    private Position position; // remplacer par getter/setter

    public MarsRoverImpl(int x, int y, Direction dir, int[] sizeMap) {
        position = Position.of(x, y, dir);
        map = new PlanetMapImpl(sizeMap);
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
            int dirIdx = d.ordinal(), inc = (dirIdx < 2) ? -1 : 1;
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
        xy = onSphericalGrid(xy); // voir apres impl initialize
        return Position.of(xy[0], xy[1], d);
    }
    
    public int[] onSphericalGrid(int[] posXY) {
        int[] adaptPosXY = posXY.clone(), planetDims = map.getSize();
        for (int idx = 0; idx < 2; idx++) {
            adaptPosXY[idx] = adaptPosXY[idx] % planetDims[idx];
            if ((posXY[idx] < 0) && (posXY[idx] < adaptPosXY[idx]))
                adaptPosXY[idx]++;
            if (adaptPosXY[idx] == -(planetDims[idx] / 2)) // peut etre imbrique dans la condition (posXY[idx] < 0)
                adaptPosXY[idx] = planetDims[idx] / 2;
            else if (Math.abs(adaptPosXY[idx]) > (planetDims[idx] / 2)) {
                int sign = (posXY[idx] > 0) ? -1 : 1;
                adaptPosXY[idx] = sign * planetDims[idx] % adaptPosXY[idx];
            }
        }
        return adaptPosXY;
    }
    
    public Position getPosition() {
        return position;
    }
}

