package com.esiea.tp4A;

public class MarsRoverImpl implements MarsRover {
    private final PlanetMapImpl map;
    private Position position; // Non final car varie lors des déplacements avec l'API...
    private final int laserRange;

    public MarsRoverImpl(int x, int y, Direction dir, PlanetMapImpl map, int laserRange) {
        this.map = map;
        this.laserRange = laserRange;
        position = Position.of(x, y, dir);
        this.initialize(position);
    }

    @Override
    public MarsRover initialize(Position position) {
        System.out.println("f avancer\nb reculer\nl pivoter a gauche\nr pivoter a droite\n'end' pour stopper");
        return this;
    }

    @Override
    public MarsRover updateMap(PlanetMap map) {
        return this;
    }

    @Override
    public MarsRover configureLaserRange(int range) {
        return new MarsRoverImpl(position.getX(), position.getY(), position.getDirection(), map, range);
    }

    @Override
    public Position move(String command) {
        int[] xy = {position.getX(), position.getY()}; Direction d = position.getDirection();
        for (int idx = 0; idx < command.length(); idx++) {
            xy = (MarsRoverAction.detectObstacle(xy, moveDirection(command.charAt(idx), d), 1, map) == null) ? MarsRoverAction.roll(xy, d, command.charAt(idx)) : xy;
            d = MarsRoverAction.rotate(d, command.charAt(idx));
            if (command.charAt(idx) == 's') MarsRoverAction.shoot(xy, d, laserRange, map);
        }
        return Position.of(map.convert(xy[0], 0), map.convert(xy[1], 1), d);
    }
    public Position move(String command, PlanetMapImpl map) {
        int[] xy = {position.getX(), position.getY()}; Direction d = position.getDirection();
        for (int idx = 0; idx < command.length(); idx++) {
            xy = (MarsRoverAction.detectObstacle(xy, moveDirection(command.charAt(idx), d), 1, map) == null) ? MarsRoverAction.roll(xy, d, command.charAt(idx)) : xy;
            d = MarsRoverAction.rotate(d, command.charAt(idx));
            if (command.charAt(idx) == 's') MarsRoverAction.shoot(xy, d, laserRange, map);
        }
        return Position.of(map.convert(xy[0], 0), map.convert(xy[1], 1), d);
    }
    public Position getPosition() { return position;}
    public void setPosition(Position position) {this.position = position; }
    public PlanetMap getMap() { return map;}
    public static Direction moveDirection(char letter, Direction d) {
        if (letter == 'b')
            return Direction.values()[(d.ordinal() + 2) % 4];
        return d;
    }
}

