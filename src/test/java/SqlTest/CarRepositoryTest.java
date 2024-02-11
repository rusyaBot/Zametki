package SqlTest;

import SqlPodklyuchenie.CarRepository;
import SqlPodklyuchenie.SqlExecutor;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CarRepositoryTest {
    @Mock
    SqlExecutor sqlExecutor;  // Создаём болванку
    @Test
    public void testGetAllCars(){
        MockitoAnnotations.openMocks(this);
        CarRepository carRepository = new CarRepository(sqlExecutor);
        when(sqlExecutor.dbSelectSq("get all car from car")).thenReturn("THIS IS MOCK DATA"); // Тут задаём что нужно подложить в мок
        assertEquals("THIS IS MOCK DATA",carRepository.getAllCars());
    }
}
