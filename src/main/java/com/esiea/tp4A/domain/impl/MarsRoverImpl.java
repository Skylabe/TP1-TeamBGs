import java.lang.Integer;

public class MarsRoverImpl implements MarsRover {

    public MarsRoverImpl(int x, int y, Direction d) {
        //TODO
    }

//    default MarsRover initialize(Position position) {
//        return this;
//    }

//    default MarsRover updateMap(PlanetMap map) {
//        return this;
//    }

//    default MarsRover configureLaserRange(int range) {
//        return this;
//    }

//    default Position move(String command) {
//        return Position.of(0, 0, Direction.NORTH);
//    }
    
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Direction dir = null;
        for (Direction d : Direction.values()) {
            if (d.toString().equals(args[2]))
                dir = d;
        }
        MarsRoverImpl rover = new MarsRoverImpl(x, y, dir);
    }
}

