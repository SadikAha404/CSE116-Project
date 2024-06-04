package ratings;

import java.util.*;

public class DegreesOfSeparation {

    ArrayList<Movie> movies = new ArrayList<>();

    public DegreesOfSeparation(ArrayList<Movie> movies){
        this.movies=movies;
    }

    public int degreesOfSeparation(String cast1, String cast2){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> path = new HashMap<>();

        queue.add(cast1);
        visited.add(cast1);
        path.put(cast1, 0);

        while (!queue.isEmpty()) {
            String cast = queue.poll();

            if(cast.equals(cast2)){
                return path.get(cast);
            }

            ArrayList<Movie> moviesWithCast = findActor(cast);

            for (Movie movie : moviesWithCast) {
                for (String castMember:movie.getCast()){
                    if(!visited.contains((castMember))){
                        queue.add(castMember);
                        visited.add(castMember);
                        path.put(castMember, path.get(cast)+1);
                    }
                }
            }
        }

        return -1;

    }

    private ArrayList<Movie> findActor(String castMember) {
        ArrayList<Movie> moviesWithActor = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCast().contains(castMember)) {
                moviesWithActor.add(movie);
            }
        }
        return moviesWithActor;
    }

}
