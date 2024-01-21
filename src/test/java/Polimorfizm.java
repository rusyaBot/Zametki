public class Polimorfizm {

//    class Animal {
//        public String say() {
//            return "Я животное!";
//        }
//    }
//
//    class Dog extends Animal {
//
//        @Override
//        public String say() {
//            return "Я пёсик!";
//        }
//    }
//
//    class Main {
//        public static void main(String[] args) {
//            Animal dog = new Dog();
//            System.out.println("Собака говорит: " + dog.say());
//            // выведется "Собака говорит: Я пёсик!"
//        }
//    }

    // Задание:
    // Повар решил приготовить десерт с фруктами.
    // Фрукты нужно подготовить: очистить от косточек. Если это груша Pear, повар должен получить подсказку "Нужно удалить косточки ложкой".
    // А для любого другого фрукта — "Нужно удалить косточки ножом".
    // Создай класс Pear и переопредели в нём метод или методы так, чтобы программа печатала:
    // Нужно удалить косточки ложкой
    // Фрукт готов к использованию
//    public class Praktikum {
//
//        public static void main(String[] args) {
//            Pear pear = new Pear();
//            pear.processFruit();
//        }
//    }
//
//    public class Fruit {
//
//        public void processFruit() {
//            removeStone();
//            System.out.println("Фрукт готов к использованию");
//        }
//
//        public void removeStone() {
//            System.out.println("Нужно удалить косточки ножом");
//        }
//    }
//
//    public class Pear extends Fruit {
//        public void removeStone() {
//            System.out.println("Нужно удалить косточки ложкой");
//        }
//    }


    //Полиморфизм означает, что у методов с одним названием могут быть разные реализации.
    //Проявления полиморфизма — переопределение и перегрузка.
    //Переопределение методов означает, что один и тот же метод может вести себя по-разному в классах-наследниках.
    // Например, метод eat() — «жевать листья» для жирафа и «есть корм» для кошки.
    //Перегрузка означает, что метод ведёт себя по-разному в зависимости от аргументов. Например, add() ставит элемент в конец списка или на определённое место.
    //Все классы подчиняются полиморфизму, потому что у них есть общий предок Object().



    // Задача
    // Начинающий разработчик хочет написать программу, которая пополняет баланс телефона.
    // У него получилось написать её только для целых чисел.
    // Но ведь на счёт можно положить не только целое число рублей, но и дробное — с копейками.
    // Помоги закончить программу: доработай класс Account так, чтобы он мог пополнять баланс и дробными числами.
//    public class Praktikum {
//
//        public static void main(String[] args) {
//            Account account = new Account(100.65);
//            account.add(10);
//            account.add(10.10);
//            System.out.println(account.getBalance());
//        }
//    }
//
//    public class Account {
//        private double balance;
//
//        public Account(double balance) {
//            this.balance = balance;
//        }
//
//        public void add(int money) {
//            balance = balance + money;
//        }
//        public void add(double money) {
//            balance = balance + money;
//        }
//
//        public double getBalance() {
//            return balance;
//        }
//    }
}

