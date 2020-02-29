import java.util.Set;
import java.util.HashSet;

public class PlanetMapImpl implements PlanetMap {

    public PlanetMapImpl() {
    // implementer taille map
        
    }
    
    @Override
    public Set<Position> obstaclePositions(){
        Set<Position> mapObstacles = new HashSet<Position>();
//        for (int x = 10; x < 20; x++) {
//            for (int y = 10; y < 20; y++)
//                mapObstacles.add(Position.of(x, y, Direction.NORTH));
//        }
        return mapObstacles;
    }
//    
//    
//    public static void main(String[] args) {
//        PlanetMapImpl p = new PlanetMapImpl();
//        Set<Position> a = p.obstaclePositions();
//        /*for (Position pos : a) {
//            System.out.println(a.getClass().getName());
//        }*/
//        System.out.println(a.getClass().getName());
//    }
}

