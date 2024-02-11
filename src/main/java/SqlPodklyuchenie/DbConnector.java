package SqlPodklyuchenie;

public class DbConnector {

    private Config config;
    private  final Integer defaulPuort = 5432;

    public  DbConnector(Config config){
        this.config = config;
    }

    public  Connection connect(){
        if (config.getUsername() != "test"){
            return new Connection();
        } else {
            Connection connection = new Connection();
            connection.setConnection(false);
            return connection;
        }
    }




}
