package com.esiea.tp4A;

import java.lang.Integer;
import java.util.Scanner;
import java.util.Arrays;

public class MarsRoverConsole {
    private final MarsRoverImpl rover;
    private final PlanetMapImpl planet;
    private final Scanner scan;

    public MarsRoverConsole(int x, int y, Direction d, int planetWidth, int planetHeight, String[] coordsObstacles) {
        int[] planetDims = {planetWidth, planetHeight};
        planet = new PlanetMapImpl(planetDims);
        planet.setObstaclePositions(coordsObstacles);
        rover = new MarsRoverImpl(x, y, d, planet);
        scan = new Scanner(System.in);
        launch();
    }
    
    public void launch() {
        System.out.println("f avancer\nb reculer\nl pivoter a gauche\nr pivoter a droite\n'end' pour stopper");
        Position newPos; String newCommand = "";
        // entrer "end" pour stopper le programme s'applique aussi dans les tests
        while (!newCommand.equals("end")) {
            newCommand = scan.nextLine();
            newPos = rover.move(newCommand);
            //rover.updateMap(newPos);
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
            String[] coordsObstacles = Arrays.copyOfRange(args, 5, args.length);
            new MarsRoverConsole(Integer.parseInt(args[0]), Integer.parseInt(args[1]), stringToDirection(args[2]),
            Integer.parseInt(args[3]), Integer.parseInt(args[4]), coordsObstacles);
        } catch (NumberFormatException | java.lang.ArrayIndexOutOfBoundsException | java.lang.NullPointerException e) {
            System.out.println("Argument(s) saisi(s) invalide(s)");
        }
    }
}

