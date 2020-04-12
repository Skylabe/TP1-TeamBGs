package com.esiea.tp4A;

import java.lang.Integer;
import java.util.Scanner;
import java.util.Arrays;

public class MarsRoverConsole {
    private final MarsRoverImpl rover;
    private final PlanetMapImpl planet;
    private final Scanner scan;

    public MarsRoverConsole(int x, int y, Direction d, int laserRange, int planetWidth, int planetHeight, String[] coordsObstacles) {
        int[] planetDims = {planetWidth, planetHeight};
        planet = new PlanetMapImpl(planetDims);
        planet.setObstaclePositions(coordsObstacles);
        rover = new MarsRoverImpl(x, y, d, planet, laserRange);
        scan = new Scanner(System.in);
        launch();
    }
    
    public void launch() {
        Position newPos; String newCommand = "";
        while (!newCommand.equals("end")) {
            newCommand = scan.nextLine();
            rover.setPosition(rover.move(newCommand));
            rover.updateMap(rover.getMap());
        }
    }
    
    public static Direction stringToDirection(String arg) {
        for (Direction d : Direction.values()) {
            if (d.toString().charAt(0) == arg.charAt(0))
                return d;
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            String[] coordsObstacles = Arrays.copyOfRange(args, 6, args.length);
            new MarsRoverConsole(Integer.parseInt(args[0]), Integer.parseInt(args[1]), stringToDirection(args[2]),
            Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), coordsObstacles);
        } catch (NumberFormatException | java.lang.ArrayIndexOutOfBoundsException | java.lang.NullPointerException e) {
            System.out.println("Argument(s) saisi(s) invalide(s)");
        }
    }
}

