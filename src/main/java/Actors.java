import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
public class Actors {
    public static final String API_KEY = "0rqhJL06NM9FWPB0UKKXmQ==BNUh7Y3Jc3QK5KTo";
    String netWorth;
    Boolean isAlive;

    public Actors(String netWorth, boolean isAlive ){
        this.netWorth = netWorth ;
        this.isAlive = isAlive ;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            String ans ;
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
            name.replace(" ", "+"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            //System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
//                JSONArray ja = response.getJSONArray("Ingredients");
                in.close();
                ans = response.toString();
                ans = ans.substring(1 , ans.length()-1) ;
                return ans ;
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        double result = 0.0;
        result = jsonObject.getDouble("net_worth") ;
        return result;
    }

    public boolean isAlive(String actorsInfoJson){
        JSONObject jsonObject =  new JSONObject(actorsInfoJson) ;
        boolean statues = false;
        statues = jsonObject.getBoolean("is_alive");
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        String date = "";
        date = jsonObject.getString("death");
        return date;
    }

    public Integer Age(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        int age = 0;
        age = jsonObject.getInt("age") ;
        return age;
    }

    public String Occupation(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        String date = "";
        return date;
    }

    public Integer Height(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        int height = 0;
        height = jsonObject.getInt("height");
        return height;
    }

    public String Nationality(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        String nationality = "";
        nationality = jsonObject.getString("nationality") ;
        return nationality;
    }

    public String Gender(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        String gender = "";
        gender = jsonObject.getString("gender") ;
        return gender;
    }

    public String Birthday(String actorsInfoJson){
        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        String date = "";
        date = jsonObject.getString("birthday");
        return date;
    }

    public String Death(String actorsInfoJson){

        JSONObject jsonObject = new JSONObject(actorsInfoJson) ;
        String date = "";
        date = jsonObject.getString("death");
        return date;
    }

}