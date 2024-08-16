package bookworms;

import java.util.Map;
import java.net.URI;
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
    public Boolean createRecord(String collection, Map<String, String> data) throws Exception {
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

    public String getRecord(String collection, String id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(POCKETBASE_URL + "/api/collections/" + collection + "/records/" + id))
        .GET()
        .build();

        // TODO: reformat perhaps to be more friendly
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


}
