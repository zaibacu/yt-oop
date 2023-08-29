package lt.griaustinis;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    private String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=54.9027&longitude=23.9096&hourly=temperature_2m&forecast_days=1&format=csv";
    private HttpClient client;

    private List<TemperatureObserver> subscribers = new ArrayList<>();

    public WeatherService() {
        this.client = HttpClient.newHttpClient();
    }

    public void notifyAll(LocalDateTime dt, float value) {
        for(TemperatureObserver observer : subscribers) {
            observer.notify(dt, value);
        }
    }

    public void subscribe(TemperatureObserver observer) {
        this.subscribers.add(observer);
    }

    public void pullLatestData() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(apiUrl);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String[] rows = response.body().split("\n");
        for(int i = 4; i<rows.length; i++) {
            String[] data = rows[i].split(",");
            LocalDateTime dt = LocalDateTime.parse(data[0]);
            float temp = Float.parseFloat(data[1]);

            notifyAll(dt, temp);
        }
    }


    private static WeatherService instance = null;

    public static WeatherService getInstance() {
        if(instance == null) {
            instance = new WeatherService();
        }

        return instance;
    }

    public static class WeatherUpdater implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    WeatherService.getInstance().pullLatestData();
                }
                catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }

                try {
                    Thread.sleep(Duration.ofMinutes(30));
                }
                catch(InterruptedException ex) {

                }
            }
        }
    }
}
