package SqlPodklyuchenie;

public class CarService {

    private CarRepository carRepository;
    public  CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    public  String processCarStatistics(){
        return "PROCRSSING: " + carRepository.getAllCars();
    }
}
