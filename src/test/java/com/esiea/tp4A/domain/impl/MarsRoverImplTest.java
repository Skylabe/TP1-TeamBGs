package com.esiea.tp4A;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.io.ByteArrayInputStream;

class MarsRoverImplTest {

    // Permet de tester le main
    @ParameterizedTest
    @CsvFileSource(resources = "/MarsRoverImplStart.csv")
    void testMain(String x, String y, String d) {
        String[] args = {x, y, d};
        // Simule l'input de l'utilisateur, possibilite d'ajouter les inputs a executer en argument depuis un csv dedie
        // dans src/main/resources
        String userInput = "end\r\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        MarsRoverImpl.main(args);
    }

    // Permet de tester le constructeur
    @ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplStart.csv", numLinesToSkip=1)
    void testMarsRoverImpl(int x, int y, Direction d) {
        MarsRoverImpl marsRover = new MarsRoverImpl(x, y, d);
        assertEquals(x, marsRover.position.getX());
        assertEquals(y, marsRover.position.getY());
        assertEquals(d, marsRover.position.getDirection());
    }

//    default MarsRover testUpdateMap(PlanetMap map) {
//        return this;
//    }

//    default MarsRover testConfigureLaserRange(int range) {
//        return this;
//    }

    /*@ParameterizedTest
    @CsvFileSource(resources="/MarsRoverImplMove.csv", numLinesToSkip=1)
    void testMove(String command, int x) {
        Position pos = Position.of();
        marsRover
    }*/
}

