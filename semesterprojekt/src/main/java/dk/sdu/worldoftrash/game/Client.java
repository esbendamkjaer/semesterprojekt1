package dk.sdu.worldoftrash.game;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.worldoftrash.shared.ScoreData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Client {

    private HttpClient httpClient;

    private String url;

    private int timeout;

    public Client(int timeout, String url) {
        this.url = url;
        this.timeout = timeout;

        httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(timeout))
                .build();
        
    }

    /**
     * Send a given ScoreData object to the web server.
     * @param scoreData ScoreData object to send.
     */
    public void sendScoreData(ScoreData scoreData) {
        ObjectMapper objectMapper = new ObjectMapper();

        String data;
        try {
            data = objectMapper.writeValueAsString(scoreData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(data);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(url + "/createScoreData"))
                .timeout(Duration.ofSeconds(timeout))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
