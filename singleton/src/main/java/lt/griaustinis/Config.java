package lt.griaustinis;

public class Config {
    private String apiKey;
    private Config() {
        this.apiKey = System.getenv("API_KEY");
    }

    public String getApiKey() {
        return apiKey;
    }

    private static Config _instance = null;
    public static Config getInstance() {
        if(_instance == null) {
            _instance = new Config();
        }
        return _instance;
    }
}
