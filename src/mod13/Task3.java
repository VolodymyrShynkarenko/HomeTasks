package mod13;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Task3 {
    static String getJSON(String urlString) throws IOException {
        URL url = new URL(urlString);
        Scanner scanner = new Scanner(url.openStream(), "UTF-8");
        String jsonString = scanner.useDelimiter("\\A").next();
        scanner.close();
        return jsonString;
    }

    public static void printOpenTasks(int userID) throws IOException, JSONException {
        String urlString = "https://jsonplaceholder.typicode.com/users/" + userID + "/todos";
        String jsonString = getJSON(urlString);
        JSONArray jsonArray = new JSONArray(jsonString);
        for(int i=0;i<jsonArray.length();i++){
            JSONObject task = jsonArray.getJSONObject(i);
            if(!task.getBoolean("completed")){
                System.out.println(task.getString("title"));
            }
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        printOpenTasks(1);
    }
}