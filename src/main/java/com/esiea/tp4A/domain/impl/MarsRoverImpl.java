package com.esiea.tp4A;

import java.lang.Integer;

public class MarsRoverImpl implements MarsRover {
    private PlanetMapImpl map;
    private Position posRover;

    public MarsRoverImpl(int x, int y, Direction dir) {
        posRover = Position.of(x, y, dir);
        this.initialize(posRover);
    }

    public MarsRover initialize(Position position) {
        map = new PlanetMapImpl();
        posRover = position;
        return this;
    }

//    default MarsRover updateMap(PlanetMap map) {
//        return this;
//    }

//    default MarsRover configureLaserRange(int range) {
//        return this;
//    }

    public Position move(String command) {
        return Position.of(0, 0, Direction.NORTH);
    }
    
    public static void main(String[] args) {
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            Direction dir = null;
            for (Direction d : Direction.values()) {
                if (d.toString().equals(args[2]))
                    dir = d;
            }
            MarsRoverImpl rover = new MarsRoverImpl(x, y, dir);
        } catch (NumberFormatException e) {
            System.out.println("Afficher aide");
        }
    }
}

