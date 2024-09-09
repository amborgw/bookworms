package bookworms;

import java.util.Map;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PocketBaseClient {
    private static final String POCKETBASE_URL = "http://localhost:8090";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Stores given data into specified pocketbase database
     * 
     * @param collection
     * @param data
     * @return record created
     */
    public static Boolean createRecord(String collection, Map<String, String> data) throws Exception {
        String json = objectMapper.writeValueAsString(data);

        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(POCKETBASE_URL + "/api/collections/" + collection + "/records"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
        .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // if record failed to be created
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            return false;
        } else {
            return true;
        }
    }

    public static String getRecord(String collection, String id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(POCKETBASE_URL + "/api/collections/" + collection + "/records/" + id))
        .GET()
        .build();

        // TODO: reformat perhaps to be more friendly
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /**
     * Given a username, searches for that user's info in the database
     * @param collection
     * @param username
     * @return
     * @throws Exception
     */
    public static String getUserRecord(String username) throws Exception {
        // Encode the username for the URL to handle special characters
        String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8.toString());

        // Create the URI with a filter to search for the username
        String url = POCKETBASE_URL + "/api/collections/users/records?filter=username='" + encodedUsername + "'";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Check the response status code
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            return null;
        } else {
            return response.body();
        }

    }
}
