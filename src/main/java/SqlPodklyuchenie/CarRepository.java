package SqlPodklyuchenie;

public class CarRepository {
    private final String tableName = "car";
    private SqlExecutor sqlExecutor;
    public CarRepository(SqlExecutor executor){
        this.sqlExecutor = executor;
    }
    public String getAllCars(){
        return sqlExecutor.dbSelectSq("get all car from " + tableName) + " from CAR REPOSITORY";
    }
    public  String updateCar(){
        return sqlExecutor.dbSelectSq("update car in" + tableName);
    }




}
