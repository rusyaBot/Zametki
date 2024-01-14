import org.junit.Test;

import java.util.ArrayList;

public class TestsList {

    @Test
    public void addElement() {
        ArrayList<Double> expenses = new ArrayList<>();
        expenses.add(32.2);
        expenses.add(0, 55.6); // добавили трату на первое место в списке
        expenses.add(55.6); // добавили трату на первое место в списке
        expenses.add(55.2); // добавили трату на первое место в списке
        expenses.add(55.3); // добавили трату на первое место в списке
        System.out.println(expenses);
        // add
        // создай список
        ArrayList<String> kittenNames = new ArrayList<>();
        // добавь кличку Пушок
        kittenNames.add("Петушок");
        // добавь кличку Ушастик
        kittenNames.add("Ушастик");
        // добавь кличку Рыжик
        kittenNames.add("Рыжик");
        // добавь кличку Снежок на второе место в списке
        kittenNames.add(1, "Снежок");
        // выведи список на экран
        System.out.println(kittenNames);

        ArrayList<Double> expenses2 = new ArrayList<>();
        expenses2.add(120.3); // добавили трату, её индекс - 0
        expenses2.add(1356.43); // добавили трату, её индекс - 1
        expenses2.add(549.7); // добавили трату, её индекс - 2
        System.out.println(expenses2); // напечатали текущий список трат
        double myExpense = expenses2.set(0, 134.3); // присвоили первому элементу новое значение
        System.out.println(expenses2); // напечатали обновлённый список трат
    }

    @Test
    public void setElement() {
        ArrayList<String> kittenNames2 = new ArrayList<>();
        kittenNames2.add("Пушок");
        kittenNames2.add("Ушастик");
        kittenNames2.add("Рыжик");
        // добавили Снежка на второе место в списке
        kittenNames2.add(1, "Снежок");
        // добавили Черныша на третье место в списке
        kittenNames2.add(2, "Черныш");

        // поменяй кличку Черныш на Черныш-крепыш
        kittenNames2.set(2, "Черныш-крепыш");
        // поменяй кличку Снежок на Снежок-красавчик
        kittenNames2.set(1, "Снежок-красавчик");
        // выведи список на экран
        System.out.println(kittenNames2); // напечатали обновлённый список трат
    }


    @Test
    public void getElement() {
        ArrayList<String> kittenNames = new ArrayList<>();
        kittenNames.add("Пушок");
        kittenNames.add("Ушастик");
        kittenNames.add("Рыжик");
        kittenNames.add(1, "Снежок");
        // добавь кличку Черныш на третье место в списке
        kittenNames.add(2, "Черныш");
        // выведи на экран последнюю кличку в списке
        System.out.println(kittenNames.get(4));
        // выведи на экран предпоследнюю кличку в списке
        System.out.println(kittenNames.get(3));
        // выведи на экран третью кличку в списке
        System.out.println(kittenNames.get(2));
    }

    @Test
    public void sizeElement() {
        ArrayList<Double> expenses = new ArrayList<>();
        System.out.println("Размер списка: " + expenses.size() + " значений.");
        expenses.add(120.43);
        System.out.println("Размер списка: " + expenses.size() + " значение.");
        expenses.add(290.5);
        System.out.println("Размер списка: " + expenses.size() + " значения.");
        expenses.add(420.49);
        System.out.println("Размер списка: " + expenses.size() + " значения.");

        ArrayList<Double> expenses4 = new ArrayList<>(); // создали список
        expenses4.add(120.47); // добавили элемент
        expenses4.add(290.24); // добавили элемент
        expenses4.add(420.78); // добавили элемент

        System.out.println("Сейчас в списке: ");
        for (int i = 0; i < expenses4.size(); i++) { // i строго меньше размера списка
            System.out.println("Трата " + i + ": " + expenses4.get(i) + " руб.");
            // напечатали траты и их индексы в списке
        }

        ArrayList<Double> kittenWeights = new ArrayList<>();
        // добавь в список вес каждого котёнка
        kittenWeights.add(1.62);
        kittenWeights.add(1.91);
        kittenWeights.add(1.76);
        kittenWeights.add(2.02);
        // определи максимальный вес в списке
        double max = 0;
        for (int i = 0; i < kittenWeights.size(); i++) {
            if (kittenWeights.get(i) > max) {
                max = kittenWeights.get(i);
            }
        }
        // вывод самого большого веса
        System.out.println("Максимальный вес: " + max + " кг");

        // второй способ через for
        System.out.println("Сейчас в списке: ");
        for (Double element : kittenWeights) {
            System.out.println("Максимальный вес: " + element + " кг");
        }
    }

    @Test
    public void averageElement() {
        // Рассчитай средний вес котёнка: используй цикл for each и метод size(). Выведи результат на экран.
        ArrayList<Double> kittenWeights = new ArrayList<>();
        kittenWeights.add(1.62);
        kittenWeights.add(1.91);
        kittenWeights.add(1.76);
        kittenWeights.add(2.02);
        kittenWeights.add(1.88);

        // рассчитай сумму весов всех котят
        double sum = 0;
        for (Double weight : kittenWeights) {
            // сложи значения в списке
            sum = sum + weight;
        }
        // рассчитай средний вес котёнка
        double averageWeight = sum / kittenWeights.size();
        // выведи результат на экран
        System.out.println("Средний вес котёнка: " + averageWeight + " кг");
    }

    @Test
    public void removeElement() {
        ArrayList<Double> expenses = new ArrayList<>();
        expenses.add(120.23);
        expenses.add(290.32);
        expenses.add(420.03);
        System.out.println(expenses);
        expenses.remove(1); // удалили элемент с индексом 1
        System.out.println("удалили элемент с индексом 1 " + expenses);

        // В качестве аргумента можно передать не индекс, а значение элемента, который нужно удалить.
        // Например, можно удалить трату в 120.23 рублей:
        ArrayList<Double> expenses2 = new ArrayList<>();
        expenses2.add(120.23);
        expenses2.add(290.32);
        expenses2.add(420.03);
        System.out.println("Было: " + expenses2);
        expenses2.remove(120.23);
        System.out.println("удалили значение 120.23 осталось:  " + expenses2);
    }


    //    Метод clear()
//    Метод remove() удаляет только один элемент списка.
//    Чтобы удалить все элементы, понадобится метод clear() (англ. «очистить»):
    @Test  // Метод clear()
    public void clearElement() {
        ArrayList<Double> expenses = new ArrayList<>();
        expenses.add(120.23);
        expenses.add(290.32);
        expenses.add(420.03);
        System.out.println("Элементов в списке - " + expenses.size());
        expenses.clear();
        System.out.println("Элементов в списке - " + expenses.size());
    }


    //    Метод isEmpty()
    //    Метод isEmpty() (англ. «пустой ли») помогает проверить, есть ли в списке элементы.
    //    Он возвращает true, если список пустой, и false, если в нём есть хотя бы один элемент.
    @Test
    public void isEmptyElement() {
        ArrayList<Double> expenses = new ArrayList<>();
        expenses.add(120.23);
        expenses.add(290.32);
        expenses.add(420.03);
        System.out.println("Список: " + expenses);
        if (expenses.isEmpty()) { // проверка, есть ли элементы в списке
            System.out.println("Нет сохранённых трат.");
        } else {
            System.out.println("Трат в списке - " + expenses.size());
        }
        System.out.println("Очищаем список через expenses.clear()");
        expenses.clear();
        if (expenses.isEmpty()) { // проверка, есть ли элементы в списке
            System.out.println("Нет сохранённых трат.");
        } else {
            System.out.println("Трат в списке - " + expenses.size());
        }
    }

    // Метод contains(E e)
    // Методом contains(E e) (англ. «содержит») можно проверить, есть ли элемент в списке.
    // Он возвращает true или false. В качестве аргумента передаётся элемент, который нужно найти.
    // Например, можно проверить, сохранилась ли трата в 290.32 рублей:
    @Test
    public void containsElement() {
        ArrayList<Double> expenses = new ArrayList<>();
        expenses.add(120.23);
        expenses.add(420.03);
        boolean isExp = expenses.contains(290.32); // проверка наличия элемента
        if (isExp == false) {
            expenses.add(1, 290.32); // если элемента нет, его нужно добавить
            System.out.println("Трата " + expenses.get(1) + " рублей добавлена!");
        } else {
            System.out.println("Все расходы учтены!");
        }
        // Перепроверка после добавления
        System.out.println("Перепроверка после добавления");
        boolean newisExp = expenses.contains(290.32); // проверка наличия элемента
        if (newisExp == false) {
            expenses.add(1, 290.32); // если элемента нет, его нужно добавить
            System.out.println("Трата " + expenses.get(1) + " рублей добавлена!");
        } else {
            System.out.println("Все расходы учтены!");
        }
    }

    // Задание: Представь, что тебе нужно накормить котят: они должны заходить на кухню и уходить, когда поели.
    // Создай список kittensInTheKitchen. В нём будут храниться клички котят, которые пришли на кухню: Пушок, Снежок, Черныш, Ушастик и Рыжик.
    // Проверь, что никто из них не прокрался на кухню до тебя.
    // Добавь клички котят в список и проверь, сколько их теперь на кухне. Удаляй котят из списка по инструкции в коде.
    @Test
    public void Element() {
        // создай список kittensInTheKitchen
        ArrayList<String> kittensInTheKitchen = new ArrayList<>();
        // проверь, есть ли котята на кухне
        if (kittensInTheKitchen.size() < 1) {
            System.out.println("На кухне нет котят");
        } else {
            // если на кухне есть котята, посчитай их
            System.out.println("Котят на кухне: " + kittensInTheKitchen.size());
        }
        // добавь в список каждого котёнка
        kittensInTheKitchen.add("Пушок");
        kittensInTheKitchen.add("Снежок");
        kittensInTheKitchen.add("Черныш");
        kittensInTheKitchen.add("Ушастик");
        kittensInTheKitchen.add("Рыжик");
        // проверь, есть ли котята на кухне
        if (kittensInTheKitchen.size() < 1) {
            System.out.println("На кухне нет котят");
        } else {
            // если на кухне есть котята, посчитай их
            System.out.println("Котят на кухне: " + kittensInTheKitchen.size());
        }
        // удали Пушка из списка по индексу
        kittensInTheKitchen.remove(0);
        // удали Снежка из списка по имени
        kittensInTheKitchen.remove("Снежок");
        // проверь, пропал ли Снежок из списка
        if (kittensInTheKitchen.contains("Снежок")){
            System.out.println("Снежок ещё на кухне");
        } else{
            System.out.println("Снежок уже ушёл");
        }
        // удали Черныша из списка по имени
        kittensInTheKitchen.remove("Черныш");
        // проверь, пропал ли Черныш из списка
        if (kittensInTheKitchen.contains("Черныш")){
            System.out.println("Черныш ещё на кухне");
        } else{
            System.out.println("Черныш уже ушёл");
        }
        // удали оставшихся котят из списка
        kittensInTheKitchen.clear();
        // проверь, сколько теперь котят на кухне
        if (kittensInTheKitchen.size() < 1){
            System.out.println("На кухне нет котят");
        } else{
            // если на кухне остались котята, посчитай их
            System.out.println("Котят на кухне: " + kittensInTheKitchen.size());
        }
    }

    //    @Test
//    public void Element(){
//
//    }

}
