[![Build Status](https://travis-ci.com/Skylabe/TP1-TeamBGs.svg?branch=master)](https://travis-ci.com/Skylabe/TP1-TeamBGs)



[![codecov](https://codecov.io/gh/Skylabe/TP1-TeamBGs/branch/master/graph/badge.svg)](https://codecov.io/gh/Skylabe/TP1-TeamBGs)


## Link of the project statement
You can found it [here](https://github.com/ledoyen/tp-java/blob/master/projet/4A_2020/TP.md).

## Launch the project
The following command shows how to compile the project using javac:  
```javac -cp "src/main/java/com/esiea/tp4A/domain/bin" -d src/main/java/com/esiea/tp4A/domain/bin/ src/main/java/com/esiea/tp4A/domain/*.java src/main/java/com/esiea/tp4A/domain/impl/*.java```  
Next, you can lauch the project as follows:  
```java -cp src/main/java/com/esiea/tp4A/domain com.esiea.tp4A.MarsRoverConsole x y direction [width map] [height map] obstacles```  
The "obstacles" argument takes all the x and y coordinates to put an obstacle, for example:  
```java -cp src/main/java/com/esiea/tp4A/domain com.esiea.tp4A.MarsRoverConsole 0 0 NORTH 5 5 1 1 2 1```  
This will make appear two obstacles in (1, 1) and in (2, 1) in a map of 5x5 cases.

## Launch the tests
Test all the project:  
```mvn test```  

