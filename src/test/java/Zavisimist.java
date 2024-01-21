public class Zavisimist {


    // Чтобы переписать код с инъекцией зависимости, нужно:
    // Создать интерфейс для класса-зависимости. Здесь их сразу два — HorizonLamp и SuperLamp.
    // Поэтому пусть интерфейс называется Lamp.
    // Создать в зависимом классе поле того же типа, что и интерфейс. По принципу инкапсуляции, его нужно сделать приватным.
    // Например, private Lamp lamp в классе Fridge.
    // Создать конструктор с параметром того же типа, что и интерфейс. Например, public Fridge(Lamp lamp).
    // Внутри конструктора передать значение параметра в созданное поле: this.lamp = lamp.
    // Шаг 1. Создали общий интерфейс Lamp, который
// будут реализовывать классы HorizonLamp и SuperLamp
//    public interface Lamp {
//        void switchLightOn();
//    }
//
//    public class HorizonLamp implements Lamp {
//        // метод включает свет лампочкой «Горизонт»
//        @Override
//        public void switchLightOn() {
//            System.out.println("Я включаю лампочку марки «Горизонт»");
//        }
//    }
//
//    public class SuperLamp implements Lamp {
//        // метод включает свет лампочкой «Суперлампа»
//        @Override
//        public void switchLightOn() {
//            System.out.println("Я включаю лампочку марки «Суперлампа» и сияю на ура!");
//        }
//    }
//    public class Fridge {
//        // Шаг 2. Создали в классе Fridge приватное поле типа Lamp
//        // теперь объект lamp — это поле класса Fridge
//        private Lamp lamp;
//
//        // Шаг 3. Объект horizonLamp передаётся в конструктор. Он создан извне класса
//        public Fridge(Lamp lamp) {
//            this.lamp = lamp; // объект попадает в переменную класса
//        }
//
//        public void openDoor() {
//            // объект класса horizonLamp используют, чтобы включить свет
//            lamp.switchLightOn();
//            // дальше может быть код, который выполняется после открытия дверцы
//        }
//    }


    // Задание
    // Измени и дополни код так, чтобы зависимости Author и Publisher (Издатель) класса Book внедрялись при помощи конструктора.

    // класс Main, в котором создаются объекты для внедрения в класс Book
//    public class Main {
//        public static void main(String[] args) {
//            IAuthor author = new FantasyAuthor();
//            IPublisher publisher = new OldPublisher();
//            Book book = new Book(author, publisher);
//            book.printBookInfo();
//        }
//    }
//
//    // интерфейс для издательств
//    public interface IPublisher {
//        int foundationYear();
//    }
//
//    public class OldPublisher implements IPublisher {
//        @Override
//        // метод, который возвращает год основания издательства
//        public int foundationYear() {
//            return 1950;
//        }
//    }
//
//    // интерфейс для авторов
//    public interface IAuthor {
//        String getName();
//    }
//
//    // класс для автора фентези
//    public class FantasyAuthor implements IAuthor {
//        @Override
//        public String getName() {
//            return "Фрэнк Герберт";
//        }
//    }
//
//    public class Book {
//        // переменные author и publisher внутри класса
//        private IAuthor author;
//        private IPublisher publisher;
//
//        // здесь допиши внедрение зависимости author и publisher через конструктор
//        public Book(IAuthor author, IPublisher publisher) {
//            this.author = author; // объект попадает в переменную класса
//            this.publisher = publisher; // объект попадает в переменную класса
//        }
//
//        // методы из классов author и publisher
//        public void printBookInfo() {
//            System.out.println("Автор: " + author.getName());
//            System.out.println("Год основания издательства: " + publisher.foundationYear());
//        }
//    }
}
