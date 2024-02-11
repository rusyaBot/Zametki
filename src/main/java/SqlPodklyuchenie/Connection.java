package SqlPodklyuchenie;

public class Connection {
    private Boolean isConnection;
    public Connection(){
        this.isConnection = true;
    }

    public Boolean getConnection() {
        return isConnection;
    }

    public void setConnection(Boolean connection) {
        isConnection = connection;
    }
}
