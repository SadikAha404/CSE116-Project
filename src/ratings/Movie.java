package ratings;

import java.util.ArrayList;

public class Movie extends Ratable{

    ArrayList<String> cast;
    public Movie(String title, ArrayList<String> cast){
        this.setTitle(title);
        this.cast=cast;
    }

    public ArrayList<String> getCast(){
        return cast;
    }

}
