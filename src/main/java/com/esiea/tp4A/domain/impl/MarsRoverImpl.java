package com.esiea.tp4A;

import java.lang.Integer;
import java.util.Scanner;

public class MarsRoverImpl implements MarsRover {
    private PlanetMapImpl map;
    public Position position;

    public MarsRoverImpl(int x, int y, Direction dir) {
        position = Position.of(x, y, dir);
        this.initialize(position);
    }

    public MarsRover initialize(Position position) {
        map = new PlanetMapImpl();
        position = position;
        return this;
    }

// checker ici si la position retournee par move appartient a l'un des obstacles de la map
// Si non, affecter a "this.position" la valeur retournee par move
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
                if (d.toString().charAt(0) == args[2].charAt(0))
                    dir = d;
            }
            MarsRoverImpl rover = new MarsRoverImpl(x, y, dir);
            Scanner scan = new Scanner(System.in);
            System.out.println("f avancer\nb reculer\nl pivoter a gauche\nr pivoter a droite\n'end' pour stopper");
            
            String newCommand = "";
            // entrer "end" pour stopper le programme s'applique aussi dans les tests'
            while (!newCommand.equals("end")) {
                newCommand = scan.nextLine();
                rover.move(newCommand);
            }
        } catch (NumberFormatException e) {
            System.out.println("Argument(s) saisi(s) invalide(s)");
        }
    }
}

