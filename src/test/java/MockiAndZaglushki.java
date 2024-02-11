import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito
public class MockiAndZaglushki {

    //Подключить Mockito к тестовому классу
    //Второй шаг — подключить Mockito к тестовому классу, чтобы использовать мок именно в нём.
    // В примере с курьерами пусть это будет класс OrderManagementServiceTest.
    //Есть два способа: аннотация и метод.
    //С помощью аннотации. Перед тестовым классом нужно добавить аннотацию @RunWith с раннером MockitoJUnitRunner:
//    @RunWith(MockitoJUnitRunner.class)
//    public class OrderManagementServiceTest {
//    ...
//    }

    // С помощью метода. Нужно добавить в тестовый класс специальный метод с телом MockitoAnnotations.initMocks(this).
    // Пусть метод называется init() — от initialize, «инициализировать».
    // Мок нужно создавать перед каждым тестом. Поэтому перед методом init() понадобится аннотация @Before.
//    public class OrderManagementServiceTest {
//        @Before
//        public void init() {
//            MockitoAnnotations.initMocks(this);
//        }
//    ...
//    }

    // Обычно моки подключают через аннотацию: так удобнее.
    // Но иногда это невозможно: например, когда уже есть аннотация для параметризованных тестов — @RunWith(Parameterized.class).
    // Две одинаковые аннотации использовать нельзя. Тогда подойдёт второй способ.

    //Зависимость к тестовому классу подключена. Теперь можно создать сам мок.
    //Создать мок
    //Тут тоже есть два способа — через аннотацию или метод.
    //Аннотацию @Mock нужно добавить перед тем, как создавать объект. Ты как будто говоришь: «этот объект будет моком».
    //@Mock
    //CourierManagementService courierManagementService;
    //Метод mock() нужно вызвать для объекта класса, который предстоит сымитировать. Как аргумент передают имя класса:
    //CourierManagementService courierManagementService = Mockito.mock(CourierManagementService.class);
    //📎 Аннотация лаконичнее, поэтому её используют чаще.


    //Вот как выглядит тест для OrderManagementService целиком. Библиотеку подключали через аннотацию, мок тоже создавали через неё:
//    @RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito
//    public class OrderManagementServiceTest {
//
//        @Mock // создали мок
//        CourierManagementService courierManagementService;
//
//        @Test
//        public void assignToCourierTest() { // сам тест
//            OrderManagementService orderManagementService = new OrderManagementService(courierManagementService);
//            orderManagementService.assignToCourier();
//            Mockito.verify(courierManagementService, Mockito.times(1)).getFreeCourier();
//        }

    //Задание
    //Представь, что тебе нужно протестировать объект класса ArrayList.
    //Создай мок-объект list: добавь аннотации @RunWith и @Mock.
//    @Mock
//    ArrayList<String> list;
//
//    @Test
//    public void test() {
//        list.add("1");
//        list.add("2");
//        list.add("3");
//    }


    //Значения по умолчанию
    //Методы моков не возвращают те же значения, что и реальные объекты. Например, реальный метод будет возвращать значение 100. Мок вернёт не 100, а 0.
    //Так получается, потому что моки меняют всё на значения по умолчанию. Если метод возвращал ссылочный тип, мок вернёт null. Если примитив — значение примитива по умолчанию.
    //Вот пример. Есть класс Delivery, в котором каждый метод возвращает своё значение:
    //public class Delivery {
    //
    //        ...
    //
    //        public String getDefaultName() {
    //        return "Unknown delivery"; // возвращает Unknown delivery
    //    }
    //
    //    public double getDefaultWeight() {
    //        return 100.0; // возвращает 100.0
    //    }
    //
    //    public boolean getDefaultImportanceState() {
    //        return true; // возвращает true
    //    }
    //
    //        ...
    //}

    //Если создать реальный объект класса Delivery, методы вернут Unknown delivery, 100.0 или true соответственно.
    //Если создать мок такого класса, методы вернут:
    //getDefaultName() — null;
    //getDefaultWeight() — 0.0;
    //getDefaultImportanceState() — false.
    //Именно это значения по умолчанию для данных типа String, double и boolean.
    //Сравни:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Delivery mockedDelivery;
    //
    //    Delivery testDelivery = new Delivery();
    //
    //    @Test
    //    public void test() {
    //        // Получаем значения из мока
    //        System.out.println(mockedDelivery.getDefaultName()); // выведется null
    //        System.out.println(mockedDelivery.getDefaultWeight()); // выведется 0.0
    //        System.out.println(mockedDelivery.getDefaultImportanceState()); // выведется false
    //                // Получаем значения из реального объекта
    //        System.out.println(testDelivery.getDefaultName()); // выведется Unknown delivery
    //        System.out.println(testDelivery.getDefaultWeight()); // выведется 100.0
    //        System.out.println(testDelivery.getDefaultImportanceState()); // выведется true
    //    }
    //
    //}

    //Моки для private или final
    //Можно создать мок любого класса или интерфейса. Но нельзя создать мок для private или final. Это ограничения самого Mockito.
    //Например, не получится создать мок строкового объекта: класс String в Java объявлен как final.
    //Если написать такой код:
    //@Mock
    //String mockedString;
    //Получится ошибка:
    //org.mockito.exceptions.base.MockitoException:
    //Cannot mock/spy class java.lang.String
    //Mockito cannot mock/spy because :
    // - final class
    //Если очень нужно создать мок для final, решение есть: оно описано в документации. Не будем останавливаться на нём подробно, потому что это не очень частый случай.
    //В следующем уроке ты узнаешь, какие методы можно использовать с моками.


    //Методы Mockito
    //В библиотеке Мockito есть специальные методы, которые понадобятся в разных проверках.
    //Проверить аргументы: verify()
    //Помогает убедиться, что метод вызвали с определёнными аргументами. Например, есть класс Car — он описывает машину. Метод setCarBrand() задаёт бренд машины:
    //Допустим, нужно убедиться, что в метод передали аргумент Lamborghini. Тут и поможет verify(). Сперва ты создаёшь мок-объект класса Car:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Car car; // создали мок
    //
    //    @Test
    //    public void test() {
    //        car.setCarBrand("Lamborghini"); // вызвали метод объекта с аргументом
    //        Mockito.verify(car).setCarBrand("Lamborghini"); // проверили, что метод вызван с этим параметром
    //    }
    //}

    // Задание
    // Допиши тест, который проверяет вызов метода updateText() с аргументом «Обновлённый комментарий».
//    @Mock
//    Comment comment;
//
//    @Test
//    public void test() {
//        comment.updateText("Обновлённый комментарий");
//        Mockito.verify(comment).updateText("Обновлённый комментарий");
//    }

    //Проверить, сколько раз вызвали метод: times()
    //Можно проверить, что метод вызвали два раза, три или ещё сколько угодно. Например, что пользователь два раза отредактировал комментарий.
    //Для этого внутри verify() нужно вызвать ещё один метод — times(). Выглядит это так: Mockito.verify(car, Mockito.times(3)).setCarBrand("Lamborghini").
    //Целиком так:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Car car;
    //
    //    @Test
    //    public void test() {
    //        car.setCarBrand("Lamborghini");
    //        car.setCarBrand("Lamborghini");
    //        car.setCarBrand("Lamborghini"); // вызвали метод с одним аргументом три раза
    //        Mockito.verify(car, Mockito.times(3)).setCarBrand("Lamborghini");
    //                // проверили, что метод вызван три раза с этим аргументом
    //    }
    //}

    //Задание 2
    //Представь, что пользователь несколько раз попытался стереть свой комментарий.
    // Проверь, что метод updateText() вызывался два раза.
    // @Mock
    //    Comment comment;
    //
    //    @Test
    //    public void test() {
    //        comment.updateText("");
    //        comment.updateText("");
    //        Mockito.verify(comment, Mockito.times(2)).updateText("");// допиши код тут
    //    }


    //Методы any
    //Иногда нужно проверить, что метод вызвали с каким-то аргументом. Неважно, с каким именно. Например, протестировать: машине задали бренд. Какой именно — не так важно, подойдёт любой.
    //Понадобятся методы семейства any:
    //any() проверяет, что в метод передан любой аргумент ссылочного типа. Например, объект.
    //anyString(), anyList(), anyInt() применяют для аргументов определённого типа: строка, список, целое число.
    //Например, можно проверить, что в метод setCarBrand() передали любую строку:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Car car;
    //
    //    @Test
    //    public void test() {
    //        car.setCarBrand("Lamborghini"); // вызвали метод объекта с аргументом
    //        Mockito.verify(car).setCarBrand(Mockito.anyString());
    //                // проверили, что метод вызван с любой строкой в качестве аргумента
    //        Mockito.verify(car).setCarBrand(Mockito.any()); // тоже сработает: String - ссылочный тип данных
    //    }
    //}

    // Что такое стаб
    // В прошлых уроках тебе удалось создать мок — «слепок» объекта. Есть ещё один вид «дублёров» реального кода — стабы.
    // От английского stub — «заглушка».
    // Чем отличаются моки и стабы
    // Моки проверяют поведение объектов. Они помогают убедиться, что метод сработал так, как и ожидалось.
    // Например, что его вызвали ровно два раза. Или что вообще вызвали.
    // Со стабами по-другому: они не проверяют поведение, а имитируют объект в определённом состоянии.
    // Например, объект-машину, у которой методу «задать бренд» передали Lamborgini. Стаб не проверит, как отработал метод. Он просто вернёт заранее определённые данные.
    //📌 Стаб имитирует состояние — например, кошку с аргументом «рыжая». А мок проверяет поведение объекта.
    // Например, что метод, который задаёт цвет кошке, вызвали с аргументом «рыжая».

    //Например, есть класс заказа Order. В нём написали метод getId(): он принимает имя пользователя, а возвращает номер заказа. Пользователи хранятся во внешней базе данных: метод ищет их там.
    //Ждать ответ от базы данных долго. Чтобы ускорить работу, можно создать стаб. Он всегда будет возвращать один и тот же номер заказа — например, 251. Выглядит так, как будто метод сходил в базу данных и принёс значение. А на самом деле никуда он не ходил: ему заранее сказали «принеси значение 251».
    //Мок тут не поможет. Он не умеет возвращать определённые данные — 2, 5 или 251. Он только смотрит, как отработал метод, и сверяет результат с ожиданиями.
    //Мок и методы Mockito	Стаб
    //👩‍💻: Проверь, как выполнится метод в объекте. Его должны были вызвать с аргументом «251». Какой там аргумент в реальности?	👩‍💻: Сделай вид, что выполнился метод, который забирает из базы данных номер заказа. Верни значение «251».
    //🤖: Реально вызвали с «251».	🤖: 251.
    //📌 Как только нужно получить данные от стороннего сервиса, понадобится стаб.

    // Как создавать и использовать стабы
    // Итак, стабы помогают сымитировать состояние объекта. Сейчас ты узнаешь, как их создавать.
    // Важный момент: в Mockito нет такой сущности как «стаб». Для программы это мок, только с особыми настройками.
    // Поэтому тебе нужно будет сделать всё то же самое, что для мока, а потом добавить завершающие штрихи.

    //Создать мок
    //Первые шаги — такие же, как для мока. Нужно:
    //подключить билиотеку Mockito в pom.xml,
    //подключить Mockito к тестовому классу,
    //написать аннотацию @Mock.
    //Допустим, так:
    //
    //    @Mock
    //    Engine engine; // создали мок, который попозже станет стабом
    //
    //}

    //Добавить два метода
    //Чтобы превратить мок в стаб, понадобится два метода:
    //when() — «когда вызван метод»;
    //thenReturn() — «вернуть значение».
    //Так ты задаёшь то самое значение, которое должен вернуть метод: «когда вызван метод такой-то, верни такое-то значение».
    //Например, в классе Engine есть метод getPower(). Он должен вернуть значение 125:
    //public class Engine {
    //
    //    public int getPower() {
    //        return 125;
    //    }
    //
    //}
    //Класс Car использует getPower() в своём методе getEnginePower().
    //public class Car {
    //
    //    Engine engine;
    //
    //    public Car(Engine engine) {
    //        this.engine = engine;
    //    }
    //
    //    public int getEnginePower() {
    //        return engine.getPower(); // использует метод другого класса
    //    }
    //
    //}
    //Допустим, нужно, чтобы при тестировании метод getPower() возвращал иное значение — 500. Чтобы не менять код другого класса, можно создать стаб и написать так: Mockito.when(engine.getPower()).thenReturn(500). То есть «когда вызван метод getPower(), верни значение 500».
    //Целиком так:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Engine engine; // создали стаб
    //
    //    @Test
    //    public void test() {
    //        Car car = new Car(engine);
    //        System.out.println(car.getEnginePower()); // аннотация @Mock стирает возвращаемые значения, поэтому выведется 0
    //        Mockito.when(engine.getPower()).thenReturn(500);
    //                // теперь при вызове getPower() всегда будет возвращаться 500
    //        System.out.println(car.getEnginePower()); // выведется 500
    //    }
    //}

    //Задание 1
    //Представь, что ты тестируешь метод getFriendsCount() класса Friend. Он возвращает количество друзей.
    //import java.util.List;
    //
    //public class Friend {
    //    List<String> friends;
    //
    //    public Friend(List<String> friends) {
    //        this.friends = friends;
    //    }
    //
    //    public int getFriendsCount() {
    //        return friends.size();
    //    }
    //}
    //Создай стаб для объекта класса List, который при вызове метода size() возвращает значение 100. Используй аннотацию @Mock.
    //import org.junit.Test;
    //import org.junit.Assert;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //import java.util.List;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock // добавь аннотацию
    //    List<String> list;
    //
    //    @Test
    //    public void friendsTest() {
    //        Friend friend = new Friend(list);// создай объект класса Friend
    //        Mockito.when(friend.getFriendsCount()).thenReturn(100); // создай стаб
    //        Assert.assertEquals(100, friend.getFriendsCount());
    //    }
    //}

    //Стабы для методов с параметрами
    //Можно создать стабы и для объектов, у которых есть методы с параметрами. Например, метод getWheelsCount() принимает количество передних и задних колёс, а возвращает их сумму:
    //public class Wheel {
    //
    //    public int countWheels(int frontWheels, int backWheels) {
    //        return frontWheels + backWheels;
    //    }
    //
    //}
    //public class Car {
    //
    //    Wheel wheel;
    //
    //    public Car(Wheel wheel) {
    //        this.wheel = wheel;
    //    }
    //
    //    public int getWheelsCount(int frontWheels, int backWheels) {
    //        return wheel.countWheels(frontWheels, backWheels);
    //    }
    //
    //}
    //В коде стаба нужно указать, при каких аргументах метод должен возвращать значение. Например, стаб будет выводить 5, только если передали аргументы 2 и 2. Иначе — 0 по умолчанию:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Wheel wheel;
    //
    //    @Test
    //    public void test() {
    //        Car car = new Car(wheel);
    //        Mockito.when(wheel.countWheels(2, 2)).thenReturn(5);
    //        System.out.println(car.getWheelsCount(2,2)); // выведется 5
    //    }
    //}


    //Задание 2
    //Представь, что в тесте нужно получить определенное значение зарплаты курьера.
    // Для этого используют метод calcSalary() класса PayrollCalculator.
    // Не важно как именно будет подсчитана зарплата. Для этого можно использовать стаб.
    // public class PayrollCalculator {
    //
    //    public int calcSalary(int hours, int rate, int bonus) {
    //        return hours * rate + bonus;
    //    }
    //
    //}
    //Создай стаб для PayrollCalculator, который при вызове метода calcSalary() со значениями 0, 0, 0 будет возвращать 50000.
    //import org.junit.Test;
    //import org.junit.Assert;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class NewTest {
    //
    //    @Mock // добавь аннотацию
    //    PayrollCalculator payrollCalculator;
    //
    //    @Test
    //    public void calcSalaryTest() {
    //        Mockito.when(payrollCalculator.calcSalary(0, 0, 0)).thenReturn(50000); // опиши стаб
    //        Assert.assertEquals(50000, payrollCalculator.calcSalary(0, 0, 0));
    //    }
    //
    //}


    //Методы any для стабов
    //Со стабами тоже можно использовать методы семейства any. Например, нужно, чтобы стаб выводил значение, только когда в него передают целые числа:
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    Wheel wheel;
    //
    //    @Test
    //    public void test() {
    //        Car car = new Car(wheel);
    //        Mockito.when(wheel.countWheels(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
    //        /* Теперь стаб выведет 5, если передать в него любое целое число.
    //                Иначе - 0 */
    //                System.out.println(car.getWheelsCount(2,2)); // выведется 5
    //        System.out.println(car.getWheelsCount(3,7)); // выведется 5
    //    }


    //Задание 3
    //Вернись к стабу, который уже удалось создать — PayrollCalculator.
    // Обнови код так, чтобы метод возвращал 80000: не важно, какие именно значения для hours, rate и bonus в него передали.
    //import org.junit.Test;
    //import org.junit.Assert;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class NewTest {
    //
    //    @Mock
    //    PayrollCalculator payrollCalculator;
    //
    //    @Test
    //    public void calcSalaryTest() {
    //			  Mockito.when(payrollCalculator
    //                .calcSalary(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()))
    //                .thenReturn(80000);
    //        Assert.assertEquals(80000, payrollCalculator.calcSalary(40, 90, 0));
    //    }
    //
    //}

    //Что такое spy
    //Как ты знаешь, мок имитирует поведение объекта. Он не исполняет его методы по-настоящему: только притворяется, что вызывает их. А сам возвращает либо значение по умолчанию, либо то, которое ему сказали вернуть.
    //Вспомни пример: есть класс Delivery. Его метод возвращает значение 100.0:
    //public class Delivery {
    //
    //        ...
    //
    //    public double getDefaultWeight() {
    //        return 100.0; // возвращает 100.0
    //    }
    //
    //        ...
    //}
    //Если создать мок такого класса, метод вернёт 0.0: это значение по умолчанию.
    //Можно сделать так, чтобы метод выполнился по-настоящему: то есть getDefaultWeight() вернёт 100.0. Для этого пригодится особый вид мока: шпион.

    //🦹 Шпион, или spy — это мок, который действительно вызывает и исполняет все свои методы. Он ведёт себя так же, как реальный объект.
    //При этом у шпионов так же, как у моков:
    //можно «попросить» метод вернуть определённое значение. Например, 50 для метода getDefaultWeight();
    //можно отследить, какой метод сколько раз вызывали и вызывали ли вообще.
    //В общем, за шпионами тоже можно пристально следить: где что вызвалось и вернулось.

    // Как создать шпиона
    // Как и с моками, есть два способа — через аннотацию или метод.
    //☝🏻 Важный нюанс: мок строится на основе класса.
    // Ты создаёшь мок класса, а потом уже в нём объект. Шпион строится на основе объекта, а не класса.
    // Поэтому нужно, чтобы в классе обязательно был объект.
    //Если в классе есть конструктор без параметров, Mockito сам создаст объект — под капотом.
    // Ничего делать не нужно. Если нужны параметры, придётся создать объект явно через new.

    //Создать шпиона через аннотацию
    //Нужно добавить аннотацию @Spy перед тем, как создавать объект. Не забудь указать раннер Mockito над тестовым классом.
    //В конструкторе Example есть параметр, поэтому нужно создать объект явно:
    //public class Example{
    //  private int id;
    //  public Example(int id){
    //     this.id = id;
    //   }
    //}
    //
    //@RunWith(MockitoJUnitRunner.class)//раннер
    //public class ExampleTest{
    //@Spy // шпион
    //Example example = new Example(3); //создали объект
    ////...
    //}
    //Если в классе есть конструктор без параметров, можно явно не создавать объект. Достаточно написать так:
    //  public Example() {
    //}
    //
    //@RunWith(MockitoJUnitRunner.class)//раннер
    //public class ExampleTest{
    //@Spy
    //Example example;
    ////...
    //}

    // Второй способ: Создать шпиона через метод
    //Нужно вызвать метод spy() для объекта, за которым предстоит шпионить. Как аргумент передай сам объект:
    //Example example = new Example(3); //создали объект
    //Example exampleSpy  = Mockito.spy(example); //создали шпион объекта
    //Похоже на мок, только в случае мока аргументом будет класс — потому что он строится на классе.
    // Для мока было бы так: Example exampleMock = Mockito.mock(Example.class).

    //Лаконичнее — через аннотацию. Метод применяют, если аннотации уже заняты чем-то другим: например, параметризацией. Всё так же, как и в моках.
    //Задание
    //Пусть есть класс Cat:
    //public class Cat{
    //  private String name;
    //  public Cat(String name){
    //     this.name = name;
    //   }
    //}
    //Нужно покрыть его тестами: используй шпион. Создай тестовый класс и объяви объект шпионом с помощью аннотации.
    //Пусть у объекта для шпиона поле name равно "Пушок".
    //import org.junit.runner.RunWith;
    //import org.mockito.junit.MockitoJUnitRunner;
    //import org.mockito.Spy;
    //@RunWith(MockitoJUnitRunner.class)//напиши раннер
    //public class CatTest{
    //@Spy//напиши аннотацию
    //public Cat cat = new Cat("Пушок");//создай объект
    //
    //}


    //Когда использовать spy
    //Итак: шпион отличается от мока тем, что его методы возвращают реальный результат.
    //Обычно ты просто смотришь, вызовется ли метод и сколько раз. Но иногда этого не хватает: нужно проследить, как метод себя поведёт и что вернёт. Мок тут не поможет: его методы вернут только значения по умолчанию. Тестировать замоканный объект бесполезно. А вот шпион позволяет тестировать реальное поведение методов, но при этом отслеживать вызовы.
    //В этом уроке — о том, когда такое понадобится в тестировании.

    //Метод вызывает другой метод того же класса
    //Представь: ты тестируешь метод, а он вызывает другой метод того же класса. Пусть есть класс «Круг» —  Circle. В нём два метода, которые устанавливают цвет круга:
    //Один — чтобы установить цвет в зависимости от радиуса. Например, если радиус больше 5, круг будет синим.
    //Другой — чтобы задать цвет по умолчанию. В этом случае программа считает, что радиус равен 1.
    //public class Circle {
    //    private String colour;
    //
    //    public String getColour() {
    //        return colour;
    //    }
    //
    //    public void setColour(int radius) { // в зависимости от радиуса
    //        if (radius > 5) {colour = "BLUE");}
    //        else {colour = "RED");}
    //    }
    //
    //    public void setColour() { // без привязки к радиусу
    //      setColour(1);
    //    }
    //
    //}
    //}

    //Чтобы тест был изолирован, можно создать шпион для круга — объекта в классе Circle. Все его методы отработают как реальные. Цвет установится правильно в зависимости от радиуса.
    //При этом тест для setColor() без параметров будет изолирован. Он упадёт, только если в самом методе что-то не то:
    //
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.junit.MockitoJUnitRunner;
    //import org.mockito.Mockito;
    //import org.mockito.Spy;
    //
    //import org.junit.Assert;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class CircleTest {
    //
    //    @Spy // шпион для объекта
    //    private Circle circle;
    //
    //    @Test
    //    void setColourRadiusGreater5ReturnsBlue{
    //        circle.setColour(10);
    //        Assert.assertEquals("BLUE", circle.getColour());
    //    }
    //
    //    @Test
    //    void setColourRadiusLess5ReturnsRed() {
    //        circle.setColour(3);
    //        Assert.assertEquals("RED", circle.getColour());
    //    }
    //
    //    @Test
    //    void setColourNoParamInvokeSetColourWith1() {
    //        circle.setColour();
    //        Mockito.verify(circle, Mockito.times(1)).setColour(1);
    //    }
    //
    //}


    //Задание
    //Есть класс NameConverter. Посмотри на его методы:
    //public class NameConverter {
    //
    //    // этот метод возвращает строку фамилия + имя из переданных параметров
    //    public String getFullName(String name, String surname){
    //       if (surname != null && !surname.isBlank() && name != null && !name.isBlank()){
    //           return surname + " " + name;
    //       }
    //        if (surname != null && !surname.isBlank()){
    //            return surname;
    //        }
    //        if (name != null && !name.isBlank()){
    //            return name;
    //        }
    //        throw new RuntimeException("Не введено ни одно значение");
    //    }
    //
    //    // этот метод использует логику первого метода
    //    public String getFullNameByName(String name){
    //        return getFullName(name, null);
    //     }
    //    // этот метод использует логику первого метода
    //    public String getFullNameBySurname(String surname){
    //        return getFullName(null, surname);
    //    }
    //
    //}
    // Тебе нужно написать тесты:
    // На метод getFullNameByName. В тесте вызови метод с параметром «Тамара».
    // На метод getFullNameBySurname. В тесте вызови метод с параметром «Петрова».
    // Напиши тесты так, чтобы они были полностью изолированы. Для этого обрати внимание, какой именно метод вызывается внутри какого.
    // Прошпионь за его вызовом с нужным параметром.
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.junit.MockitoJUnitRunner;
    //import org.mockito.Mockito;
    //import org.mockito.Spy;
    //
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class NameConverterTest {
    //
    //    @Spy
    //    private NameConverter nameConverter;
    //
    //    @Test
    //    public void getFullNameByName() {
    //        nameConverter.getFullNameByName("Тамара");; // вызови тестируемый метод с параметром «Тамара»
    //        Mockito.verify(nameConverter, Mockito.times(1)).getFullName("Тамара", null); // проверь, что внутри ровно один раз
    //      //вызвался именно нужный метод
    //// c нужными параметрами
    //    }
    //
    //    @Test
    //   public void getFullNameBySurname() {
    //        nameConverter.getFullNameBySurname("Петрова"); // вызови тестируемый метод с параметром Петрова
    //        Mockito.verify(nameConverter, Mockito.times(1)).getFullName(null, "Петрова"); // проверь, что внутри ровно один раз
    ////вызвался именно нужный метод
    //// c нужными параметрами
    //    }
    //
    //}


    // Тесты должны быть атомарными и не зависить друг от друга
    //Как разорвать зависимость
    //Хороший тест должен быть изолирован. Но бывает, программе нужны данные извне. Например, нужно получить объект из внешней базы данных.
    //Во внешнем источнике бывают ошибки: база данных может упасть. Тест скажет, что ошибка в приложении: понадобится время, чтобы понять настоящую причину сбоя.
    //Программа соединяется с удалённым сервером и получает от него данные. Это внешняя связь. Программа зависит от сервера: если он не работает, код не получит нужную информацию.
    //Класс ServiceClass получает код ответа от сервера:
    //import java.io.IOException;
    //import java.net.HttpURLConnection;
    //import java.net.URL;
    //
    //public class ServiceClass {
    //
    //    public int sendGet(String requestUrl) throws IOException {
    //        /*
    //        Строка преобразуется в объект URL. Его используют, чтобы установить
    //        http/https соединение с удалённым сервером */
    //        URL url = new URL(requestUrl);
    //        // Открывается соединение между программой и удалённым сервером
    //        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    //        /* http-метод отправляется на сервер
    //        GET запрашивает информацию */
    //        connection.setRequestMethod("GET");
    //        // Приходит код ответа от сервера
    //        return connection.getResponseCode();
    //    }
    //
    //}
    //А дальше класс Server проверяет, что сервер доступен:
    //public class Server {
    //
    //    public String checkServer(int responseCode) {
    //        if (200 == responseCode) {
    //            return "Сервер доступен";
    //        } else {
    //            return "Сервер недоступен";
    //        }
    //    }
    //
    //}
    // Представь, что ты тестируешь этот код. Сервер должен обработать запрос и вернуть данные:
    //import org.junit.Assert;
    //import org.junit.Test;
    //
    //import java.io.IOException;
    //
    //public class Praktikum {
    //
    //    @Test //аннотация, которая запускает тест
    //    public void test() throws IOException {
    //        ServiceClass serviceClass = new ServiceClass();
    //        Server server = new Server();
    //        int responseCode = serviceClass.sendGet("http://www.example.com/junk");
    //        System.out.println("Код ответа от сервера: " + responseCode);
    //        String status = server.checkServer(responseCode);
    //        Assert.assertEquals("Сервер доступен", status);
    //    }
    //
    //}
    //Что-то пошло не так. Метод sendGet() вернул ошибку 404 — Not Found. Тест не прошёл:
    // Код ответа от сервера: 404
    //
    //org.junit.ComparisonFailure:
    //Expected :Сервер доступен
    //Actual   :Сервер недоступен
    //<Click to see difference>
    //
    //    at org.junit.Assert.assertEquals(Assert.java:117)
    //    at org.junit.Assert.assertEquals(Assert.java:146)
    //    at com.example.PraktikumTest.test(PraktikumTest.java:62)
    //    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    //    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    //    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    //    at java.base/java.lang.reflect.Method.invoke(Method.java:566)
    //    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
    //    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    //    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
    //    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    //    at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
    //    at org.junit.runners.BlockJUnit4ClassRunner$1.evaluate(BlockJUnit4ClassRunner.java:100)
    //    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:366)
    //    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:103)
    //    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:63)
    //    at org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)
    //    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)
    //    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)
    //    at org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)
    //    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)
    //    at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
    //    at org.junit.runners.ParentRunner.run(ParentRunner.java:413)
    //    at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
    //    at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:69)
    //    at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
    //    at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:235)
    //    at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:54)

    //Это означает, что программа не нашла сервер. Так может получиться, если его только разрабатывают, а тестировать нужно уже сейчас. Или если проблемы с сетью.
    // Чтобы протестировать код, нужно разорвать зависимость с внешним ресурсом.
    //Поможет библиотека Mockito: она сымитирует работу сервера. Понадобится создать мок и вернуть ответ:
    //import org.junit.Assert;
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //import java.io.IOException;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    // мок класса, чтобы перехватывать вызовы его методов
    //    @Mock
    //    ServiceClass serviceClass;
    //
    //    @Test
    //    public void test() throws IOException {
    //        Server server = new Server();
    //        /* Вернётся код 200,
    //        ты имитируешь корректную работу нужного ресурса */
    //        Mockito.when(serviceClass.sendGet(Mockito.anyString())).thenReturn(200);
    //        int responseCode = serviceClass.sendGet("http://www.example.com/junk");
    //        System.out.println("Код ответа от сервера: " + responseCode);
    //        String status = server.checkServer(responseCode);
    //        Assert.assertEquals("Сервер доступен", status);
    //    }
    //}
    // С помощью Mockito можно разорвать зависимость тестов от внешних данных.
    // Библиотека сымитирует ответы внешних систем. Ты сможешь проверить, как программа ведет себя в разных ситуациях.
    // Например, нужно проверить, что будет, если внешний ресурс не сработает.
    // Чаще всего не получится вызвать настоящий сбой во вешней системе, но с помощью Mockito его можно сымитировать.



    // Задание
    // Класс ServiceClass посылает запрос на адрес http://www.example.com. С сайтом нет проблем: в ответ на запрос он присылает код 200.
    // Твоя задача — протестировать метод checkServer() класса Server.
    // Сымитируй случай, когда удалённый сервер не смог обработать запрос. Для этого нужно получить код 400 (Bad Request).
    //import org.junit.Assert;
    //import org.junit.Test;
    //import org.junit.runner.RunWith;
    //import org.mockito.Mock;
    //import org.mockito.Mockito;
    //import org.mockito.junit.MockitoJUnitRunner;
    //
    //import java.io.IOException;
    //import java.net.HttpURLConnection;
    //import java.net.URL;
    //
    //@RunWith(MockitoJUnitRunner.class)
    //public class Praktikum {
    //
    //    @Mock
    //    ServiceClass serviceClass;
    //
    //    @Test
    //    public void test() throws IOException {
    //        Server server = new Server();
    //        Mockito.when(serviceClass.sendGet(Mockito.anyString())).thenReturn(400);
    //        int responseCode = serviceClass.sendGet("http://www.example.com");
    //        String status = server.checkServer(responseCode);
    //        Assert.assertEquals("Сервер недоступен", status);
    //    }
    //}
    //
    //class ServiceClass {
    //
    //    public int sendGet(String requestUrl) throws IOException {
    //        URL url = new URL(requestUrl);
    //        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    //        connection.setRequestMethod("GET");
    //        return connection.getResponseCode();
    //    }
    //
    //}
    //
    //class Server {
    //
    //    public String checkServer(int responseCode) {
    //        if (200 == responseCode) {
    //            return "Сервер доступен";
    //        } else {
    //            return "Сервер недоступен";
    //        }
    //    }
    //
    //}


    // Оценка покрытия
    //Представь: тебе удалось написать юнит-тесты. Нужно узнать, насколько полно они проверяют сервис.
    //Существует специальная метрика — оценка покрытия.
    //Руся
    //Пример
    //Сервис вычисляет зарплату менеджера по продажам. Сотрудник получает 5% со всех продаж за месяц, но не больше пятидесяти тысяч:
    //public class SalaryService {
    //
    //    public int calculateSalary(int sales) {
    //        int percent = 5;
    //        int salary = sales * percent / 100;
    //        int salaryLimit = 50_000;
    //        if (salary > salaryLimit) {
    //            salary = salaryLimit;
    //        }
    //        return salary;
    //    }
    //}
    //Тестировщик написал юнит-тест для этого сервиса:
    //import org.junit.Assert;
    //import org.junit.Test;
    //
    //public class SalaryServiceTest {
    //
    //    @Test
    //    public void shouldCalculateSalaryWhenUnderLimit() {
    //        SalaryService salaryService = new SalaryService();
    //        int actual = salaryService.calculateSalary(50_000);
    //        int expected = 2_500;
    //
    //        Assert.assertEquals(expected, actual);
    //    }
    //}
    //Нужно понять, хорошо ли метод calculateSalary покрыт тестами. Для этого понадобится оценить покрытие.
    //📌 Покрытие кода (code coverage) говорит, какой процент программы выполняется во время тестов.
    //Можно смотреть на процент покрытых строк кода, условных операторов и методов.
    //Руся
    //Подробно
    //Процент строк кода
    //Строка кода считается покрытой, если она хотя бы раз выполнилась во время теста.
    //Например, строка int salary = sales * percent / 100; покрыта. Она всегда выполняется, когда ты вызываешь метод calculateSalary. Её вызов не зависит от параметров.
    //А вот строка salary = salaryLimit; выполняется не всегда. Если зарплата не превышает лимит, код внутри if не выполняется. Эта строка не покрыта.
    //Руся
    //Дальше
    //Процент покрытых условий
    //Условие считается покрытым, если каждая ветвь решения выполнилась.
    //Например, условие if (salary > salaryLimit) покрыто частично: тест проверяет только вариант с зарплатой ниже лимита. Превышение не проверяется.
    //Руся
    //И остался?
    //Процент покрытых методов
    //Метод считается покрытым, если он выполнился при тестировании хотя бы один раз.
    //Например, метод calculateSalary вызывается в тесте. Значит, он покрыт.
    //Руся
    //Ок
    //Как считать покрытие
    //Вручную считать покрытие неудобно и долго. Помогают специальные инструменты. Один из самых популярных — плагин Jacoco.
    //Плагин — это модуль, который расширяет возможности программы. Его нужно подключать отдельно. Это похоже на расширения в браузере: например, блокировщик рекламы.
    //Вспомни Maven: он выполняет все задачи с помощью плагинов. К примеру, с помощью плагина maven-compiler-plugin запускается компиляция.
    //Руся
    //Ага
    //Чтобы подключить плагин, нужно добавить секцию build в pom.xml. В неё и записываются плагины — с помощью тега plugin:
    //<?xml version="1.0" encoding="UTF-8"?>
    //<project xmlns="http://maven.apache.org/POM/4.0.0"
    //         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    //         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    //    <modelVersion>4.0.0</modelVersion>
    //
    //    <groupId>ru.yandex.praktikum</groupId>
    //    <artifactId>coverage</artifactId>
    //    <version>1.0-SNAPSHOT</version>
    //
    //    <properties>
    //        <!--здесь настройки-->
    //    </properties>
    //
    //    <dependencies>
    //        <!--здесь зависимости-->
    //    </dependencies>
    //
    //    <build>
    //        <plugins>
    //            <plugin>
    //                <!--здесь плагин jacoco-->
    //            </plugin>
    //        </plugins>
    //    </build>
    //
    //</project>
    //Затем нужно указать groupId, artifactId, version — так же, как для dependency:
    //        <build>
    //        <plugins>
    //            <plugin>
    //                                <groupId>org.jacoco</groupId>
    //                <artifactId>jacoco-maven-plugin</artifactId>
    //                <version>0.8.7</version>
    //            </plugin>
    //        </plugins>
    //    </build>
    //Остаётся добавить конфигурацию для плагина — в теге executions.

    //Чтобы проанализировать покрытие и создать отчёт с этими данными, понадобится две цели Jacoco.
    //Цель плагина — это задача, которую он выполняет. Например, цель mvn compiler:compile — скомпилировать код.
    //Первая цель — prepare-agent. Она нужна для корректной работы плагина. Вторая — report: она генерирует отчёт.
    //<build>
    //        <plugins>
    //            <plugin>
    //                <groupId>org.jacoco</groupId>
    //                <artifactId>jacoco-maven-plugin</artifactId>
    //                <version>0.8.7</version>
    //                <executions>
    //                    <execution>
    //                        <!--id выбираешь самостоятельно-->
    //                        <id>prepare-agent</id>
    //                        <!--в какой фазе maven будет выполняться цель-->
    //                        <phase>initialize</phase>
    //                        <!--цель jacoco, которую нужно выполнить-->
    //                        <goals>
    //                            <goal>prepare-agent</goal>
    //                        </goals>
    //                    </execution>
    //                    <execution>
    //                        <id>report</id>
    //                        <phase>verify</phase>
    //                        <goals>
    //                            <goal>report</goal>
    //                        </goals>
    //                    </execution>
    //                </executions>
    //            </plugin>
    //        </plugins>
    //    </build>
    //Самый простой способ посмотреть отчёт — открыть его в браузере. Выполни команду mvn verify: для этого в IDEA нажми Ctrl дважды. Откроется окно: напиши в нём эту команду.
    //Найди в папке target/site/jacoco/ файл index.html, нажми на него правой кнопкой мыши и выбери Open In — Browser — твой браузер.
    //https://code.s3.yandex.net/qa-automation-engineer/java/schemes/paid-track/sprint2/unitTests/S2_05_15.png
    //В отчёте отображается процент покрытых строк кода — столбец Missed Instructions. В примере покрыто 90% строк.
    //Процент покрытых ветвей — столбец Missed Branches. В примере покрыто 50% ветвей.
    //Чтобы увидеть подробнее, какие именно строки и ветви не покрыты, зайди в пакет, класс и метод внутри него:
    //https://code.s3.yandex.net/qa-automation-engineer/java/schemes/paid-track/sprint2/unitTests/S2_05_16.png
    //Цвета строк означают, насколько полно тест покрыт. Зелёный — покрыто тестами, жёлтый — покрыто частично, красный — не покрыто совсем.
    //Отчёт можно посмотреть и прямо в IDEA: для этого открой Run — Show Coverage Api.Data. Нажми + (Add) и выбери файл jacoco.exec.
    //https://code.s3.yandex.net/qa-automation-engineer/java/schemes/paid-track/sprint2/unitTests/S2_05_17.png
    //После этого нажми Show Selected. У цветов слева те же значения:
    //https://code.s3.yandex.net/qa-automation-engineer/java/schemes/paid-track/sprint2/unitTests/S2_05_18.png





}

