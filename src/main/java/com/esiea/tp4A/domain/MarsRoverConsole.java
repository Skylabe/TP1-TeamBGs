package com.esiea.tp4A;

import java.lang.Integer;
import java.util.Scanner;

public interface MarsRoverConsole {
    
    public static void main(String[] args) {
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            int[] planetDims = {100, 100};
            Direction dir = null;
            for (Direction d : Direction.values()) {
                if (d.toString().charAt(0) == args[2].charAt(0))
                    dir = d;
            }
            MarsRoverImpl rover = new MarsRoverImpl(x, y, dir, planetDims);
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
        } catch (NumberFormatException | java.lang.ArrayIndexOutOfBoundsException | java.lang.NullPointerException e) {
            System.out.println("Argument(s) saisi(s) invalide(s)");
        }
    }
}

