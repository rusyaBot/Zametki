import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Isklyucheniya {

    //Программа читает информацию из файла. Нужно обработать исключение: оно появляется, когда указали путь до несуществующего файла.
    //Действие — вывести текст "Произошла ошибка!". Класс для обработки ошибки — Exception:
//    public static void main(String[] args) {
//        try {
//            // путь к несуществующему файлу
//            Files.lines(Paths.get("Путь до несуществующего файла"), StandardCharsets.UTF_8).forEach(System.out::println);
//        } catch (Exception exception) { // класс исключения
//            // код, который выполнится, если произойдёт исключение
//            System.out.println("Произошла ошибка!");
//        }
//    }

    //    Конструкция try...catch может обрабатывать сразу несколько исключений. Нужно добавить ещё один блок catch:
//    try {
//        // опасный код, из-за которого может произойти исключение
//    } catch (ExceptionFirstType exception) {
//        // код, который выполнится, если произойдёт исключение первого типа
//    } catch (ExceptionSecondType exception) {
//        // код, который выполнится, если произойдёт исключение второго типа
//    } catch (ExceptionThirdType exception) {
//        // код, который выполнится, если произойдёт исключение третьего типа
//    }


    // Задание
    // Добавь обработку исключений для случаев:
    // файл не найден — NoSuchFileException;
    // файл найден, но к нему нет доступа. Например, нет разрешения на чтение — AccessDeniedException;
    // для всех остальных ошибок — IOException.
    // Для первого и второго случаев выведи текст "Проблемы с доступом к файлу", а для последнего — "Неизвестная ошибка".
    // Нужно обработать исключения в таком порядке: NoSuchFileException, AccessDeniedException, IOException.
//    public static void main(String[] args) {
//        try {
//            // Путь к несуществующему файлу, чтобы произошло исключение
//            Files.lines(Paths.get("Путь до несуществующего файла"), StandardCharsets.UTF_8).forEach(System.out::println);
//        } catch (NoSuchFileException exception) {
//            System.out.println("Проблемы с доступом к файлу");
//        } catch (AccessDeniedException exception) {
//            System.out.println("Проблемы с доступом к файлу");
//        } catch (IOException exception) {
//            System.out.println("Неизвестная ошибка");
//        }
//    }

    //Несколько однотипных действий в блоках catch можно объединять в одно. Пригодится оператор |.
    //Посмотри на предыдущее задание. Программа два раза печатает сообщение "Проблемы с доступом к файлу".
    //Вот запись с двумя catch:
//    try {
//        // опасный код, из-за которого может произойти исключение
//    } catch (ExceptionFirstType exception) {
//        // однотипное действие
//    } catch (ExceptionSecondType exception) {
//        // однотипное действие
//    }
//    Её можно заменить на такую:
//    try {
//        // опасный код, из-за которого может произойти исключение
//    } catch (ExceptionFirstType | ExceptionSecondType exception) {
//        // однотипное действие
//    }

    // В блок finally зашито действие: в консоли появляется текст "Этот код выполняется вне зависимости от произошедшего".
    // Если указать неверный путь до файла, программа отловит исключение.
    // Сначала появится сообщение об ошибке из блока catch, а потом — сообщение из блока finally:
//    public static void main(String[] args) {
//        try {
//            Files.lines(Paths.get("C:\\Praktikum.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
//        } catch (NoSuchFileException exception) {
//            System.out.println("Файл не найден");
//        } catch (IOException exception) {
//            System.out.println("Неизвестная ошибка");
//        } finally {
//            System.out.println("Этот код выполняется вне зависимости от произошедшего");
//        }
//    }

    //Задание
    //Потренируйся использовать finally без catch. Проверь, как обработается непроверяемое исключение NullPointerException.
    //Оберни код внутри метода в блок try. Добавь блок finally: в нём будет выводиться текст "Этот код выполняется вне зависимости от произошедшего".
    //После блока try...finally добавь вывод сообщения "Завершение программы".

//    public static void main(String[] args) {
//        try {
//            String string = null;
//            string.length();
//            System.out.println("Код отработал без ошибок");}
//        finally {
//            System.out.println("Этот код выполняется вне зависимости от произошедшего");
//        }
//        System.out.println("Завершение программы");
//    }

    // Ключевое слово throws
    // Слово throws сообщает, что метод или конструктор может сгенерировать исключение.
    // catch обрабатывает исключения, а throws просто предупреждает о них.
    // Его нужно написать после параметров метода:
    // public void methodWithException() throws CheckedException { // показывает, что в коде может быть исключение CheckedException
    //    // код программы
    //
    //}

    //Это ключевое слово нужно отличать от другого — throw.
    //throw понадобится, когда нужно выбросить исключение. throws же говорит лишь о возможности исключения, но оно может никогда не возникнуть.
    //public void methodWithException() throws CheckedException { // показывает, что в коде может быть исключение CheckedException
    //    // код программы
    //    if (someCondition) { // при определённом условии
    //        throw new CheckedException(); // код выдаст исключение CheckedException
    //    }
    //    // ещё код
    //}

    //Можно описать несколько ошибок сразу. Например, когда пользователь не ввёл символы в пароле или ввёл слишком много.
    //Нужно перечислить названия ошибок через запятую:
//    public void methodWithMultipleExceptions() throws FirstCheckedException, SecondCheckedException {
//        // код
//        if (someCondition) {
//            throw new FirstCheckedException();
//        }
//        // код
//        if (someCondition) {
//            throw new SecondCheckedException();
//        }
//        // код
//    }

}

