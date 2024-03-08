import com.sun.jdi.IntegerValue;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Movie {
    public static final String API_KEY = "d117016a";
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        this.actorsList = actorsList ;
        this.rating = rating ;
        this.ImdbVotes = ImdbVotes ;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        //handle an error if the chosen movie is not found
        return stringBuilder.toString();
    }
    public Integer getImdbVotesViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        String ImdbVotes = jsonObject.getString("imdbVotes");
        ImdbVotes = ImdbVotes.replace(",", "");
        Integer number = Integer.valueOf(ImdbVotes);
        return number ;
    }

    public String getRatingViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson) ;
        String raiting = "";
        raiting = jsonObject.getString("imdbRating") ;
        raiting += "/10" ;
        return raiting;
    }

//    public ArrayList(String) getActorListViaApi(String movieInfoJson){
//        JSONObject jsonObject = new JSONObject(movieInfoJson) ;
//        ArrayList acters = new ArrayList<>() ;
//        acters = jsonObject.get
//    }
}