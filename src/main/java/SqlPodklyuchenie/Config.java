package SqlPodklyuchenie;

public class Config {
    private String url;
    private String username;
    private String password;
    private Integer port;
    public Config(String url, String username, String password, Integer port) {
        this.url = url;
        this.username =username;
        this.password = password;
        this.port = port;
    }
    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPort() {
        return port;
    }


}
