import org.junit.Test;

import java.util.*;

public class HashMapTest {

    // Методы интерфейса Map
    // В интерфейсе Map есть основные действия, которые можно выполнять с хеш-таблицей.
    // Какие методы есть у хеш-таблиц:
    // put(K key, V value) — добавить элемент;
    // get(Object key) — получить значение по ключу;
    // values() — получить все значения;
    // keySet() — получить все ключи;
    // remove(Object key) — удалить элемент;
    // clear() — очистить хеш-таблицу;
    // containsKey(Object key) — узнать, содержит ли таблица ключ;
    // containsValue(Object value) — узнать, содержит ли таблица значение.
    // size() — получить количество элементов таблицы;
    // isEmpty() — узнать, пустая ли таблица.

    //HashMap<String, String> officeTool; // объявили хеш-таблицу
    //officeTool = new HashMap<String, String>(); // создали объект
    //officeTool = new HashMap<>(); // так тоже можно

    //Хеш-таблицы: метод put
    //Ты уже можешь объявить и проинициализировать хеш-таблицу. Теперь можно добавить в неё элементы.
    //Чтобы это сделать, нужно вызвать метод put(K key, V value) (англ. put — «поместить», key — «ключ», value — «значение»).
    //Первым аргументом нужно передать ключ, вторым — значение. Например, можно заполнить хеш-таблицу с офисным инвентарём officeTool:
    @Test
    public void putElementInHashMap() {
        HashMap<String, String> officeTool = new HashMap<>();
        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер из коридора");
        officeTool.put("N845", "Острые ножницы");
        // добавили три элемента
        System.out.println(officeTool); // напечатали элементы
        // заменили значение для ключа P342
        officeTool.put("P342", "Принтер из офиса 42");
        System.out.println(officeTool); // напечатали элементы
    }

    //Задание
    //Создай хеш-таблицу kittenWeights с весом котят. Сохрани в ней значения:
    //Пушок — 1,62 кг;
    //Снежок — 1,91 кг;
    //Черныш — 1,76 кг;
    //Ушастик — 2,02 кг;
    //Рыжик — 1,88 кг.
    //После этого измени вес Черныша: теперь он весит 1,96 кг.
    //Выведи хеш-таблицу на экран.
    @Test
    public void putElementInHashMap2() {
        HashMap<String, Double> kittenWeights = new HashMap<>();
        // добавь вес каждого котёнка
        kittenWeights.put("Пушок", 1.62);
        kittenWeights.put("Снежок", 1.91);
        kittenWeights.put("Черныш", 1.76);
        kittenWeights.put("Ушастик", 2.02);
        kittenWeights.put("Рыжик", 1.88);
        // измени вес Черныша
        kittenWeights.put("Черныш", 1.96);

        // выведи хеш-таблицу на экран
        System.out.println(kittenWeights);
    }

    // В хеш-таблицу можно помещать любые ссылочные типы — в том числе списки.
    // Это помогает сохранить несколько значений под одним ключом.
    // Представь: тебе нужно создать хеш-таблицу с ценами в ресторане.
    // Ключ — название блюда, значение — цена.
    // При этом нужно указать цену в трёх валютах: рублях, долларах и евро.
    @Test
    public void putElementInHashMapAndList() {
        HashMap<String, ArrayList<Double>> menu = new HashMap<>(); // создали хеш-таблицу
        ArrayList<Double> mohitoPrice = new ArrayList<>(); // создали список для цен на мохито
        mohitoPrice.add(350.0); // добавили в список цену в рублях
        mohitoPrice.add(15.50); // добавили в список цену в долларах
        mohitoPrice.add(13.20); // добавили в список цену в евро
        menu.put("Мохито", mohitoPrice); // добавили коктейль и список цен в хеш-таблицу

        ArrayList<Double> tiramisuPrice = new ArrayList<>(); // создали список для цен на тирамису
        tiramisuPrice.add(120.0);
        tiramisuPrice.add(4.00);
        tiramisuPrice.add(3.20);
        menu.put("Тирамису", tiramisuPrice); // добавили тирамису и список цен в хеш-таблицу

        ArrayList<Double> ramenPrice = new ArrayList<>(); // создали список для цен на рамен
        ramenPrice.add(230.0);
        ramenPrice.add(8.50);
        ramenPrice.add(7.00);
        menu.put("Рамен", ramenPrice); // добавили рамен и список цен в хеш-таблицу

        System.out.println(menu);
    }

    //В хеш-таблице kittenWeightFood нужно сохранить информацию о котятах:
    //Кличка	Вес, кг	Съедает корма в день, кг
    //Пушок	    1.62	0.095
    //Снежок	1.91	0.092
    //Черныш	1.96	0.098
    //Ушастик	2.02	0.105
    //Рыжик	    1.88	0.098
    //Создай список каждому котёнку и сохрани в нём вес и количество корма.
    // Добавь эти данные в хеш-таблицу: ключ — кличка котёнка, а значение — список с информацией о нём.
    //Выведи хеш-таблицу на экран.
    @Test
    public void putElementInHashMapAndList2() {
        // создай хеш-таблицу
        HashMap<String, ArrayList<Double>> kittenWeightFood = new HashMap<>();

        // создай список для информации о Пушке
        ArrayList<Double> pushok = new ArrayList<>();
        // добавь в список вес Пушка
        pushok.add(1.62);
        // добавь в список количество корма, которое съел Пушок
        pushok.add(0.095);
        // добавь информацию о Пушке в хеш-таблицу
        kittenWeightFood.put("Пушок", pushok);

        // создай список для информации о Снежке
        ArrayList<Double> snezhok = new ArrayList<>();
        // добавь в список вес Снежка
        snezhok.add(1.91);
        // добавь в список количество корма, которое съел Снежок
        snezhok.add(0.092);
        // добавь информацию о Снежке в хеш-таблицу
        kittenWeightFood.put("Снежок", snezhok);

        // создай список для информации о Черныше
        ArrayList<Double> chernysh = new ArrayList<>();
        // добавь в список вес Черныша
        chernysh.add(1.96);
        // добавь в список количество корма, которое съел Черныш
        chernysh.add(0.098);
        // добавь информацию о Черныше в хеш-таблицу
        kittenWeightFood.put("Черныш", chernysh);

        // создай список для информации об Ушастике
        ArrayList<Double> ushastik = new ArrayList<>();
        // добавь в список вес Ушастика
        ushastik.add(2.02);
        // добавь в список количество корма, которое съел Ушастик
        ushastik.add(0.105);
        // добавь информацию об Ушастике в хеш-таблицу
        kittenWeightFood.put("Ушастик", ushastik);

        // создай список для информации о Рыжике
        ArrayList<Double> ryzhik = new ArrayList<>();
        // добавь в список вес Рыжика
        ryzhik.add(1.88);
        // добавь в список количество корма, которое съел Рыжик
        ryzhik.add(0.098);
        // добавь информацию о Рыжике в хеш-таблицу
        kittenWeightFood.put("Рыжик", ryzhik);

        // выведи хеш-таблицу на экран
        System.out.println(kittenWeightFood);
    }

    //Хеш-таблицы: методы get, values и keySet
    //В этом уроке ты узнаешь, как получить элементы хеш-таблицы.
    //Метод get(Object key)
    //Получить значение из хеш-таблицы можно по ключу: понадобится метод get(Object key). Он принимает в качестве аргумента ключ.
    //Например, тебе нужно найти значение по ключу "N845":
    @Test
    public void getElementInHashMap() {
        HashMap<String, String> officeTool = new HashMap<>();
        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер");
        officeTool.put("N845", "Острые ножницы");

        String tool = officeTool.get("N845");
        System.out.println(tool);
    }

    //В таблице хранятся клички котят и их вес.
    // Выведи на экран вес Снежка и Ушастика.
    @Test
    public void getElementInHashMap2() {
        HashMap<String, Double> kittenWeights = new HashMap<>();

        kittenWeights.put("Пушок", 1.62);
        kittenWeights.put("Снежок", 1.91);
        kittenWeights.put("Черныш", 1.96);
        kittenWeights.put("Ушастик", 2.02);
        kittenWeights.put("Рыжик", 1.88);

        // выведи на экран вес Снежка
        System.out.println("Вес Снежка: " + kittenWeights.get("Снежок") + " кг");
        //выведи на экран вес Ушастика
        System.out.println("Вес Ушастика: " + kittenWeights.get("Ушастик") + " кг");
    }

    // Если передать в качестве аргумента ключ, которого нет в хеш-таблице,
    // Java вернёт null — нужного значения нет.
    // Тогда возникнет ошибка NullPointerException (англ. «ошибка ссылки на null»).
    // Например, в таблице orders хранятся заказы в интернет-магазине: ключ — имя клиента, значение — список его заказов.
    // Попробуй запустить код:
    @Test
    public void getElementInHashMap3() {
        HashMap<String, ArrayList<Integer>> orders = new HashMap<>();

        ArrayList<Integer> ordersNum = new ArrayList<>(); // создали новый список
        ordersNum.add(1);
        ordersNum.add(5);
        ordersNum.add(6);
        orders.put("Иван И.", ordersNum); // добавили имя клиента и список его заказов

        /* Для нового клиента нужно создать новый список.
           Можно использовать ту же переменную - ordersNum.*/
        ordersNum = new ArrayList<>();
        ordersNum.add(2);
        ordersNum.add(4);
        ordersNum.add(3);
        orders.put("Ольга С.", ordersNum);

        // переменная для списка заказов конкретного клиента
        ArrayList<Integer> customerOrders = orders.get("Ольга С.");
        for (int orderNum : customerOrders) {
            System.out.println("Заказ № " + orderNum); // напечатали номера заказов клиента
        }
    }

    // Метод values()
    // Обычно элементы хеш-таблицы ищут по ключу.
    // Если он неизвестен, поможет цикл for each и метод values(): он выводит все значения из таблицы.
    // Тип переменной итерирования в цикле должен совпадать с типом значений в хеш-таблице, а её имя может быть любым.
    // Например, нужно найти и вывести в консоль значение "Острые ножницы".
    // В цикле for each нужно перебрать все значения методом values() и выбрать те, которые равны строке "Острые ножницы":
    @Test
    public void valuesElementInHashMap3() {
        HashMap<String, String> officeTool = new HashMap<>();
        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер");
        officeTool.put("N845", "Острые ножницы");

        for (String tool : officeTool.values()) {
            if (tool.equals("Острые ножницы")) {
                System.out.println(tool); // выведется "Острые ножницы"
            }
        }
    }


    // Представь, что нужно рассчитать общий вес котят из хеш-таблицы.
    // Создай переменную kittenWeightsSum со значением 0.
    // В цикле for each получи вес каждого котёнка oneKittenWeight и добавь его к общему весу.
    @Test
    public void valuesElementInHashMap4() {
        HashMap<String, Double> kittenWeights = new HashMap<>();
        kittenWeights.put("Пушок", 1.62);
        kittenWeights.put("Снежок", 1.91);
        kittenWeights.put("Черныш", 1.96);
        kittenWeights.put("Ушастик", 2.02);
        kittenWeights.put("Рыжик", 1.88);
        // создай переменную kittenWeightsSum со значением 0
        double kittenWeightsSum = 0;
        // получи вес каждого котёнка oneKittenWeight
        // и прибавь его к переменной суммарного веса
        for (double oneKittenWeight : kittenWeights.values()) {
            kittenWeightsSum = kittenWeightsSum + oneKittenWeight;
        }
        // выведи на экран суммарный вес котят
        System.out.println("Суммарный вес котят: " + kittenWeightsSum + " кг");
    }


    //Метод keySet()
    //Если нужно получить все ключи хеш-таблицы, понадобится метод keySet() (англ. «набор ключей») и цикл for each.
    //Например, так можно вывести все ключи из хеш-таблицы офисного инвентаря:
    @Test
    public void keySetElementInHashMap1() {
        HashMap<String, String> officeTool = new HashMap<>();
        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер");
        officeTool.put("N845", "Острые ножницы");
        for (String inventory : officeTool.keySet()) {
            System.out.println(inventory);
        }
    }

    // Задание
    // Выведи на экран клички всех котят из хеш-таблицы.
    // Используй цикл for each с переменной итерирования kittenName — кличка котёнка.
    @Test
    public void keySetElementInHashMap2() {
        HashMap<String, Double> kittenWeights = new HashMap<>();

        kittenWeights.put("Пушок", 1.62);
        kittenWeights.put("Снежок", 1.91);
        kittenWeights.put("Черныш", 1.96);
        kittenWeights.put("Ушастик", 2.02);
        kittenWeights.put("Рыжик", 1.88);
        // пройди по хеш-таблице в цикле и выведи на экран каждый ключ
        for (String kittenName : kittenWeights.keySet()) {
            System.out.println(kittenName);
        }
    }


    // Хеш-таблицы: методы remove и clear
    // Метод remove()
    // Тебе уже знаком метод remove() в списках.
    // Элемент хеш-таблицы можно удалить методом remove(Object key) (англ. remove — «удалить»).
    // В качестве аргумента нужно передать ключ элемента, который ты хочешь удалить:
    @Test
    public void removeElementInHashMap() {
        HashMap<String, String> officeTool = new HashMap<>();
        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер");
        officeTool.put("N845", "Острые ножницы");
        officeTool.remove("P342");
        System.out.println(officeTool.get("P342"));
    }

    // Метод clear()
    // Чтобы полностью очистить хеш-таблицу, нужен метод clear() (англ. «очистить») — как и в списках.
    // В него не нужно передавать аргументы:
    @Test
    public void clearElementInHashMap() {
        HashMap<String, String> officeTool = new HashMap<>();
        officeTool.put("S234", "Большой степлер");
        officeTool.put("P342", "Чёрно-белый принтер");
        officeTool.put("N845", "Острые ножницы");
        officeTool.clear(); // в хеш-таблице больше нет элементов
        System.out.println(officeTool);
    }

    //Задание
    //В хеш-таблице dinner хранится список блюд на обед. Удали из неё элементы: следуй инструкции в коде.
    @Test
    public void removeAndClearElementInHashMap() {
        HashMap<String, String> dinner = new HashMap<>();
        dinner.put("Салат", "Оливье");
        dinner.put("Первое", "Борщ");
        dinner.put("Второе", "Котлеты");
        dinner.put("Гарнир", "Пюре");
        dinner.put("Напиток", "Кисель");
        // выведи хеш-таблицу на экран, чтобы проверить список блюд
        System.out.println(dinner);
        // удали из хеш-таблицы салат
        dinner.remove("Салат");
        // выведи хеш-таблицу на экран, чтобы проверить, что салата нет
        System.out.println(dinner);
        // удали из хеш-таблицы первое блюдо
        dinner.remove("Первое");
        // выведи хеш-таблицу на экран, чтобы проверить, что первого нет
        System.out.println(dinner);
        // очисти хеш-таблицу
        dinner.clear();
        // выведи хеш-таблицу на экран, чтобы проверить, что ничего не осталось
        System.out.println(dinner);
    }


    // Хеш-таблицы: методы containsKey и containsValue
    // Ты уже можешь добавить, получить и удалить элемент хеш-таблицы.
    // В этом уроке ты освоишь ещё два метода — containsKey и containsValue.

    // Оба метода помогают выяснить, есть ли элемент в хеш-таблице.
    // Метод containsKey(Object key) (англ. «содержит ключ») ищет в таблице ключ, а containsValue(Object value) (англ. «содержит значение») — значение.
    // В качестве аргумента нужно передать ключ или значение. Если такой элемент есть в таблице, метод вернёт true, если нет — false.
    // Например, в хеш-таблице statesCapitals хранятся ключи — названия стран и значения — их столицы.
    // Можно найти страны методом containsKey, а столицы — методом containsValue:

    @Test
    public void containsKeyElementInHashMap() {
        HashMap<String, String> statesCapitals = new HashMap<>();
        statesCapitals.put("Россия", "Москва");
        statesCapitals.put("Франция", "Париж");
        statesCapitals.put("Италия", "Рим");
        System.out.println(statesCapitals.containsKey("Италия")); // выведется true
        System.out.println(statesCapitals.containsKey("Германия")); // выведется false
        System.out.println(statesCapitals.containsValue("Париж")); // выведется true
        System.out.println(statesCapitals.containsValue("Пекин")); // выведется false
    }


    // Удали блюда из хеш-таблицы dinner и проверь, что их больше нет. Следуй инструкции в коде.
    @Test
    public void containsKeyElementInHashMap2() {
        HashMap<String, String> dinner = new HashMap<>();
        dinner.put("Салат", "Оливье");
        dinner.put("Первое", "Борщ");
        dinner.put("Второе", "Котлеты");
        dinner.put("Гарнир", "Пюре");
        dinner.put("Напиток", "Кисель");
        // выведи хеш-таблицу на экран, чтобы проверить список блюд
        System.out.println(dinner);
        // проверь по ключу, что в обед входит напиток
        System.out.println(dinner.containsKey("Напиток"));
        // удали из хеш-таблицы салат
        dinner.remove("Салат");
        // проверь по ключу, что салата нет
        System.out.println(dinner.containsKey("Салат"));
        // удали из хеш-таблицы первое блюдо
        dinner.remove("Первое");
        // проверь по значению, что борща нет
        System.out.println(dinner.containsValue("Борщ"));
        // очисти хеш-таблицу
        dinner.clear();
        // проверь по ключу, что второго блюда нет
        System.out.println(dinner.containsKey("Второе"));
        // проверь по ключу, что гарнира нет
        System.out.println(dinner.containsKey("Гарнир"));
        // проверь по значению, что киселя нет
        System.out.println(dinner.containsValue("Кисель"));
    }


    // Вспомни, как работают методы хеш-таблиц.
    // Посмотри на таблицу с любимыми игрушками котят:
    // Кличка котёнка	Любимые игрушки
    // Пушок	Мяч
    // Снежок	Бантик
    // Черныш	Мышка, Носок
    // Ушастик	Бантик, Клубок
    // Рыжик	Мяч, Рыбка-пищалка
    // Создай пустую хеш-таблицу kittenToys. В ней будут храниться ключи — имена котят и значения — списки их любимых игрушек.
    // Для каждого котёнка создай список любимых игрушек и помести этот список в хеш-таблицу. Создавай списки методом Arrays.asList().
    // Проверь, что в хеш-таблице есть игрушки Снежка.
    // Проверь, что игрушки всех котят попали в хеш-таблицу: посчитай количество списков в хеш-таблице.
    // Выведи на экран любимые игрушки Снежка.
    // Выведи на экран все игрушки из хеш-таблицы.
    // Очисть хеш-таблицу и проверь, что она пустая.
    @Test
    public void containsKeyElementInHashMap3() {
        // создай хеш-таблицу
        HashMap<String, List<String>> kittenToys = new HashMap<>();
        // создай список любимых игрушек Пушка
        List<String> pushokToys = Arrays.asList("Мяч");
        // добавь игрушки Пушка в хеш-таблицу
        kittenToys.put("Пушок", pushokToys);

        // создай список любимых игрушек Снежка
        List<String> snezhokToys = Arrays.asList("Бантик");
        // добавь игрушки Снежка в хеш-таблицу
        kittenToys.put("Снежок", snezhokToys);

        // создай список любимых игрушек Черныша
        List<String> chernyshToys = Arrays.asList("Мышка", "Носок");
        // добавь игрушки Черныша в хеш-таблицу
        kittenToys.put("Черныш", chernyshToys);

        // создай список любимых игрушек Ушастика
        List<String> ushastikToys = Arrays.asList("Бантик", "Клубок");
        // добавь игрушки Ушастика в хеш-таблицу
        kittenToys.put("Ушастик", ushastikToys);

        // создай список любимых игрушек Рыжика
        List<String> ryzhikToys = Arrays.asList("Мяч", "Рыбка-пищалка");
        // добавь игрушки Рыжика в хеш-таблицу
        kittenToys.put("Рыжик", ryzhikToys);

        // проверь, что игрушки Снежка внесены в хеш-таблицу
        System.out.println("Игрушки Снежка есть в таблице: " + kittenToys.containsKey("Пушок"));

        // проверь количество списков в хеш-таблице
        System.out.println("В таблице есть игрушки " + kittenToys.size() + " котят");

        // проверь, игрушки каких котят есть в таблице
        System.out.println("В таблице есть игрушки котят: " + kittenToys.keySet());

        // выведи на экран любимые игрушки Снежка
        System.out.println("Любимые игрушки Снежка: " + kittenToys.get("Снежок"));

        // выведи на экран список всех игрушек
        System.out.println("В таблице есть игрушки: " + kittenToys.values());

        // очисть хеш-таблицу
        kittenToys.clear();

        // проверь, очистилась ли таблица
        System.out.println("Хеш-таблица пуста: " + kittenToys.isEmpty());
    }

    // Элементы уникальны. В списке элементы могут повторяться, а в множество не получится добавить один объект несколько раз.
    // Поэтому множества применяют, когда нужно создать набор данных без дубликатов — например, уникальные логины пользователей.
    // Порядок элементов не определён. Если проитерироваться по элементам множества, они выведутся в произвольном порядке.
    // Например, так можно создать множество colorsSet:
    // Элементы в множество добавляют так же, как в список, — методом add().
    @Test
    public void HashSetHashMap() {
        HashSet<String> colorsSet = new HashSet<>(); // создали множество
        colorsSet.add("Синий");
        colorsSet.add("Красный");
        colorsSet.add("Зелёный");
        colorsSet.add("Фиолетовый");
        colorsSet.add("Оранжевый"); // добавили цвета
        System.out.println(colorsSet); // вывели множество на экран. Элементы выведутся в произвольном порядке — не так, как они добавлены в код.
    }
    // Методы интерфейса Set
    // Тебе уже знакомы методы, которые помогают работать со списками и хеш-таблицами. Для множеств понадобятся те же методы:
    // add(E e) — добавить элемент.
    //
    // В множествах этот метод возвращает значение типа boolean. Если метод вернул true, элемент добавился. Если false — множество уже содержит этот элемент: заново он не добавится;
    // contains(Object o) — узнать, есть ли объект в множестве;
    // remove(Object o) — удалить элемент. Если такого объекта в множестве нет, ничего не произойдёт;
    // isEmpty() — узнать, пустое ли множество;
    // size() — узнать количество элементов в множестве.

    // Например, есть список логинов пользователей, которые заходили на сайт — siteVisitsList.
    // Некоторые логины в нём повторяются: это значит, что пользователь заходил на сайт несколько раз.
    // Из списка можно сделать множество, а затем получить статистику посещений без дубликатов. Понадобятся методы size() и contains():

    // список логинов пользователей, которые посещали сайт за день
    @Test
    public void HashSetHashMap2() {
        ArrayList<String> siteVisitsList = new ArrayList<>();

        siteVisitsList.add("legioner");
        siteVisitsList.add("hanna7");
        siteVisitsList.add("lono_sun");
        siteVisitsList.add("hurocan");
        siteVisitsList.add("indie_woker");
        siteVisitsList.add("sonya2035");
        siteVisitsList.add("lono_sun");
        siteVisitsList.add("legioner");
        siteVisitsList.add("hanna7");
        siteVisitsList.add("futur100");
        siteVisitsList.add("legioner");

        // статистика посещения сайта:
        System.out.println("Все визиты: " + siteVisitsList);
        System.out.println("Всего визитов: " + siteVisitsList.size());

    /* Список можно превратить в множество: вызвать конструктор HashSet
    и передать в него список */
        HashSet<String> siteVisitsSet = new HashSet<>(siteVisitsList);

        // статистика уникальных посещений сайта:
        System.out.println("Уникальные визиты: " + siteVisitsSet);
        System.out.println("Всего уникальных визитов: " + siteVisitsSet.size());

        // проверка, заходили ли на сайт отдельные пользователи:
        System.out.println("Заходил ли пользователь 'futur100' сегодня на сайт? Ответ: " + siteVisitsSet.contains("futur100"));
        System.out.println("Заходил ли пользователь 'lucky_kitten' сегодня на сайт? Ответ: " + siteVisitsSet.contains("lucky_kitten"));
    }


    // Вспомни таблицу с любимыми игрушками котят:
    // Кличка котёнка	Любимые игрушки
    // Пушок	Мяч
    // Снежок	Бантик
    // Черныш	Мышка, Носок
    // Ушастик	Бантик, Клубок
    // Рыжик	Мяч, Рыбка-пищалка
    // Все игрушки котят хранятся в списке favoriteToys.
    // Создай из списка favoriteToys множество, чтобы избавиться от дубликатов.
    // Посчитай общее количество любимых игрушек в множестве.
    // Добавь в множество новые игрушки: пакет и коробку.
    // Проверь, есть ли в множестве бантик и ботинок.
    // Удали носок из множества.
    // Выведи множество на экран.
    @Test
    public void HashSetHashMap3() {
        ArrayList<String> favoriteToys = new ArrayList<String>(); // создали список всех любимых игрушек

        favoriteToys.add("Мяч"); // добавили любимые игрушки Пушка в список

        favoriteToys.add("Бантик"); // добавили любимые игрушки Снежка в список

        favoriteToys.add("Мышка");
        favoriteToys.add("Носок"); // добавили любимые игрушки Черныша в список

        favoriteToys.add("Бантик");
        favoriteToys.add("Клубок"); // добавили любимые игрушки Ушастика в список

        favoriteToys.add("Мяч");
        favoriteToys.add("Рыбка-пищалка"); // добавили любимые игрушки Рыжика в список

        // создай из списка множество любимых игрушек
        HashSet<String> uniqueFavoriteToys = new HashSet<>(favoriteToys);

        // посчитай количество игрушек в множестве
        System.out.println("Разных игрушек у котят: " + uniqueFavoriteToys.size());

        // добавь в множество пакет и коробку
        uniqueFavoriteToys.add("Пакет");
        uniqueFavoriteToys.add("Коробка");

        // проверь, есть ли в множестве "Бантик"
        System.out.println("Бантик есть в списке любимых игрушек: " + uniqueFavoriteToys.contains("Бантик"));

        // проверь, есть ли в множестве "Ботинок"
        System.out.println("Ботинок есть в списке любимых игрушек: " + uniqueFavoriteToys.contains("Ботинок"));

        // убери "Носок" из множества
        uniqueFavoriteToys.remove("Носок");

        // выведи множество на экран
        System.out.println(uniqueFavoriteToys);
    }
}
