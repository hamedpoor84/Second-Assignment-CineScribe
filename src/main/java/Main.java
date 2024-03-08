import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Error clearing the console screen: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {
        String wait ;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1 _ Movie");
            System.out.println("2 _ Celebrity");
            System.out.println("3 _ Exit");
            int option = scanner.nextInt();
            System.out.println();
            System.out.println();
            clearScreen();
            if (option == 1) {
                String json ;
                System.out.println("What is the title of the movie you want?");
                System.out.print("Enter the title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                Movie movie = new Movie(new ArrayList<>(), "", 0);
                try {
                    json = movie.getMovieData(title);

                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        JsonNode rootNode = objectMapper.readTree(json);

                        Iterator<String> fieldNames = rootNode.fieldNames();
                        while (fieldNames.hasNext()) {
                            String key = fieldNames.next();
                            JsonNode node = rootNode.get(key);
                            System.out.print(key + " : ");
                            System.out.println(node.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    // Handle the IOException as needed
                }
                scanner.nextLine() ;
                runMenu();
            }
            else if (option == 2)
            {
                System.out.println("What is the full name of the celebrity you want?");
                System.out.print("Enter the name: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                Actors actor = new Actors("", true);
                String json = actor.getActorData(name);

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    JsonNode rootNode = objectMapper.readTree(json);

                    Iterator<String> fieldNames = rootNode.fieldNames();
                    while (fieldNames.hasNext()) {
                        String key = fieldNames.next();
                        JsonNode node = rootNode.get(key);
                        System.out.print(key + " : ");
                        System.out.println(node.toString());
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                scanner.nextLine() ;
                runMenu();
            }
            else if (option == 3 )
            {
                System.out.println("Don't have good day");
                System.out.println("Have great day");
                return;
            }
            else
            {
                System.out.println("Invalid option selected. Please choose 1 for Movie or 2 for Celebrity.");
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter a valid option.");
        }
    }



}