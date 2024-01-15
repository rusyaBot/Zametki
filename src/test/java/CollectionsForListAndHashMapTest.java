import org.junit.Test;

import java.util.*;
import java.util.ArrayList; // импортировали класс ArrayList
import java.util.Comparator; // импортировали интерфейс Comparator


public class CollectionsForListAndHashMapTest {


    //Представь: есть два метода, которые надо протестировать. Один возвращает данные в виде массива, а другой — в виде списка.
    // Тебе нужно их сравнить: для этого понадобится привести их к одному виду. Помогут методы Arrays.asList() и toArray().
    // Метод Arrays.asList()
    //Название метода Arrays.asList() переводится как «массив в виде списка».
    // Если ему передать массив элементов в виде аргумента, он превратит его в список.
    @Test
    public void ArrayAsList() {
        List<String> cities = Arrays.asList("Воронеж", "Южно-Сахалинск", "Иркутск");
        System.out.println(cities);
        //Обрати внимание: такой список создают через интерфейс List, а не класс ArrayList.
        // Если создать через ArrayList, будет ошибка компиляции.
    }


    // Метод toArray()
    // Можно превратить список обратно в массив: понадобится метод toArray(T[]). С английского переводится как «в массив».
    // В качестве аргумента нужно передать массив того типа, который нужно вернуть.
    // Достаточно передать пустой массив, который можно создать через new. Получается, в аргументе будет, например, new String[]{}.
    @Test
    public void ToArrayForList() {
        List<String> cities = Arrays.asList("Воронеж", "Южно-Сахалинск", "Иркутск"); // создали и заполнили список
        String[] citiesArray = cities.toArray(new String[]{}); // превратили список в массив
        System.out.println(cities);
        for (String city : citiesArray) {
            System.out.print(city + ", ");
        }
    }


    // Задание
    //Создай список кличек котят из массива "Пушок", "Снежок", "Черныш", "Ушастик", "Рыжик" методом Arrays.asList(). Выведи список на экран.
    //Преобразуй список кличек котят в массив. Выведи его на экран через цикл for each.
    @Test
    public void ToArrayForList2() {
        // создай список кличек котят
        List<String> kittenNamesList = Arrays.asList("Пушок", "Снежок", "Черныш", "Ушастик", "Рыжик"); // создали и заполнили список
        // выведи список на экран
        System.out.println(kittenNamesList);

        // создай массив из списка
        String[] kittenNamesArray = kittenNamesList.toArray(new String[]{}); // превратили список в массив
        // выведи массив на экран через цикл for each
        for (String kittenName : kittenNamesArray) {
            System.out.print(kittenName + ", ");
        }
    }

    // В Java можно создать список из массива ещё одним способом — через статический метод List.of().
    // Метод List.of()
    // Ему тоже нужно передать массив элементов в качестве аргумента:
    // Если создать список через List.of() или Arrays.asList(), в них уже нельзя добавить или удалить элемент.
    // Эти методы подойдут, если тебе не нужно менять список.
    @Test
    public void ListOfForList() {
        // создание и заполнение списка
        // создай список кличек котят
        List<String> kittenNamesList1 = List.of("Пушок", "Снежок", "Черныш", "Ушастик", "Рыжик");
        // выведи список на экран
        System.out.println(kittenNamesList1);

        // Если создать список из массива, подойдут оба: и List.of(), и Arrays.asList().
        //А вот если надо создать список из нескольких элементов , лучше List.of(), чем много вызовов add() подряд.
        //Например, список из задания выше можно создать с помощью пяти вызовов add():
        List<String> kittenNamesList = new ArrayList<>();
        kittenNamesList.add("Пушок");
        kittenNamesList.add("Снежок");
        kittenNamesList.add("Черныш");
        kittenNamesList.add("Ушастик");
        kittenNamesList.add("Рыжик");
        System.out.println(kittenNamesList);

        //С List.of() получается намного лаконичнее.
    }


    //Например, чтобы отсортировать список целых чисел по возрастанию, нужно:
    //Импортировать интерфейс Comparator.
    //Создать компаратор, который будет принимать на вход целое число.
    //Переопределить метод compare(), чтобы отсортировать числа по возрастанию.
    //Вызвать метод sort() — он принимает на вход компаратор.
    //Запусти код: сначала числа выведутся без сортировки, а потом — по возрастанию.

    // создание компаратора:
    private static Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) { // метод принимает на вход два объекта с типом Integer - o1 и o2
            return o1 - o2;
        } // переопределили метод compare(), чтобы посчитать разницу между объектами
    };

    @Test
    public void sortForList() {
        ArrayList<Integer> numbers = new ArrayList<>(); // список целых чисел
        numbers.add(4);
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        System.out.println(numbers); // вывели список до сортировки
        numbers.sort(INTEGER_COMPARATOR); // отсортировали список
        System.out.println(numbers); // вывели список после сортировки

        //Метод reversed()
        //Можно отсортировать элементы в обратном порядке, для этого есть метод reversed().
        numbers.sort(INTEGER_COMPARATOR.reversed());
        System.out.println(numbers); // вывели список после сортировки по убыванию
    }


    // Сортировка строк
    // В Java есть готовые реализации интерфейса Comparator<T> для строк.
    // Например, можно отсортировать строки в алфавитном порядке без учёта регистра.
    // Понадобится статическая переменная CASE_INSENSITIVE_ORDER класса String.
    // Запусти код: названия фруктов отсортируются по алфавиту.
    @Test
    public void sortForlines() {
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Банан");
        fruit.add("Апельсин");
        fruit.add("Яблоко");
        fruit.add("Груша");
        System.out.println(fruit);
        fruit.sort(String.CASE_INSENSITIVE_ORDER); // отсортировали элементы по алфавиту
        System.out.println(fruit);
        //Метод reversed() работает и со строками. Cделать обратную сортировку:
        fruit.sort(String.CASE_INSENSITIVE_ORDER.reversed()); // отсортировали элементы по алфавиту в обратной сортировке
        System.out.println(fruit);
    }

    // Задание
    // В списке children хранятся имена и рост детей. Отсортируй их по возрастанию роста:
    // Напиши компаратор CHILD_COMPARATOR.
    // Его метод compare() принимает два объекта класса Child — Child o1 и Child o2 и возвращает разницу между их ростом —o1.height и o2.height.
    // Вызови метод sort(). Передай компаратор в качестве аргумента.

    // напиши свой компаратор:
    private static Comparator<Child> CHILD_COMPARATOR = new Comparator<Child>() {
        @Override
        public int compare(Child o1, Child o2) { // метод принимает на вход два объекта с типом Integer - o1 и o2
            return o1.height - o2.height;
        } // переопределили метод compare(), чтобы посчитать разницу между объектами
    };

    @Test
    public void sortForlines2() {

        Child petya = new Child("Петя", 120);
        Child vasya = new Child("Вася", 130);
        Child ilia = new Child("Илья", 110);

        ArrayList<Child> children = new ArrayList<>();
        children.add(petya);
        children.add(vasya);
        children.add(ilia);

        // вызови метод сортировки у списка детей и передай в него компаратор
        children.sort(CHILD_COMPARATOR); // отсортировали список
        System.out.println(children); // вывели список после сортировки
    }


    public class Child {
        String name;
        int height;

        public Child(String name, int height) {
            this.name = name;
            this.height = height;
        }

        /* чтобы получить строковое представление объекта класса Child в консоли,
    нужно переопределить метод toString() класса Object */
        @Override
        public String toString() {
            return "Child{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    '}';
        }
    }

    // Метод thenComparing()
    // Теперь ты можешь отсортировать элементы списка по возрастанию или убыванию.
    // Чтобы добавить несколько вариантов сортировки, можно создать разные реализации интерфейса Comparator.
    // Например, товар в интернет-магазине представлен классом Item.
    // У него есть поля: name (название), price (цена) и popularity (популярность).
    public class Item {
        private final String name;
        private final int price;
        private final int popularity;

        public Item(String name, int price, int popularity) {
            this.name = name;
            this.price = price;
            this.popularity = popularity;
        }
        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", popularity=" + popularity +
                    '}';
        }
        // компаратор по названию товара:
        public final Comparator<Item> ITEM_NAME_CASE_INSENSITIVE_COMPARATOR = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
            }
        };
        // компаратор по цене товара по возрастанию:
        public final Comparator<Item> ITEM_PRICE_COMPARATOR = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.price - o2.price;
            }
        };
        @Test
        public void test(String[] args) {
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item("Рубашка", 6, 4));
            items.add(new Item("Носки", 5, 10));
            items.add(new Item("Носки", 7, 9));
            items.add(new Item("Носки", 3, 13));
            System.out.println(items);
            items.sort(ITEM_NAME_CASE_INSENSITIVE_COMPARATOR.thenComparing(ITEM_PRICE_COMPARATOR));
            System.out.println(items);
        }
    }



}