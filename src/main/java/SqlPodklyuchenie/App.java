package SqlPodklyuchenie;

public class App {

    public static void main(String[] arg){
        Config config = new Config("test", "username", "password", 5432);
        DbConnector dbConnector = new DbConnector(config);
        SqlExecutor sqlExecutor = new SqlExecutor(dbConnector.connect());
        CarRepository carRepository = new CarRepository(sqlExecutor);
        CarService carService = new CarService(carRepository);
        System.out.println(carService.processCarStatistics());
    }

}
