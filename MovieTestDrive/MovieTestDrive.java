package MovieTestDrive;
class Movie {
    String title;
    String genre;
    int rating;

    void playIt(String title){
        System.out.println("Playing the " + title);
    }
}

public class MovieTestDrive{
    public static void main (String[] args){
        Movie one = new Movie();
        one.title = "Easier";
        one.genre = "tragedy";
        one.rating = 19;
        one.playIt(one.title);
    }
}