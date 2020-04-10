package com.esiea.tp4A;

import java.lang.Integer;
import java.util.Scanner;

public class MarsRoverConsole {

    public MarsRoverConsole(int x, int y, Direction d, int planetWidth, int planetHeight) {
        int[] planetDims = {planetWidth, planetHeight};
        PlanetMapImpl planet = new PlanetMapImpl(planetDims);
        MarsRoverImpl rover = new MarsRoverImpl(x, y, d, planet);
        Scanner scan = new Scanner(System.in);
        System.out.println("f avancer\nb reculer\nl pivoter a gauche\nr pivoter a droite\n'end' pour stopper");
        Position newPos;
        String newCommand = "";
        // entrer "end" pour stopper le programme s'applique aussi dans les tests'
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
            new MarsRoverConsole(Integer.parseInt(args[0]), Integer.parseInt(args[1]), stringToDirection(args[2]),
            Integer.parseInt(args[3]), Integer.parseInt(args[4]));
            //new MarsRoverConsole(Integer.parseInt(args[0]), Integer.parseInt(args[1]), stringToDirection(args[2]), 10, 10);
        } catch (NumberFormatException | java.lang.ArrayIndexOutOfBoundsException | java.lang.NullPointerException e) {
            System.out.println("Argument(s) saisi(s) invalide(s)");
        }
    }
}

