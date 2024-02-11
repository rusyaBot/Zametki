package Api;

import java.util.List;

//Как десериализовать объект
//Представь, что в ответ приходит JSON:
//{
//        "id": "61652",
//        "name": "Интересное место"
//}
//Тебе предстоит преобразовать его в Java-объект. Процесс похож на тот, который нужно было проделать для запроса.
//Сначала — создать класс. Его поля должны соответствовать ключам JSON — id и name. Поля приватные.
//Теперь конструкторы. Конструктор с параметрами не понадобится, потому что не нужно создавать объект.
//А вот конструктор без параметров пригодится: как ты знаешь, без него библиотека Gson не сможет работать.
// Только писать его не нужно. Других конструкторов нет, поэтому он существует и так — по умолчанию.
//Для всех полей можно написать публичные геттеры и сеттеры. Они не влияют на десериализацию,
// но так с классом будет удобнее работать. Их поможет сгенерировать среда разработки.
public class SimpleExample {
    // значение у id целое, поэтому нужен тип int
    private int id;
    // для поля name нужен тип String
    private String name;

    // для каждого из полей создали геттер и сеттер методы
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Теперь нужно указать, объект какого класса нужен как результат. Ты как будто говоришь программе: «Возьми этот JSON и представь его как объект класса Api.SimpleExample».
    //Понадобится метод as. В скобках нужно указать название класса и конструкцию .сlass. Получится as(Api.SimpleExample.class).
    //Обрати внимание на конструкцию .class. Она нужна, чтобы указать класс как аргумент. Если просто написать Api.SimpleExample в скобках, ничего не получится.
    //Теперь RestAssured поймёт, что нужно сделать: представить результат как объект типа Api.SimpleExample.
    //            Api.SimpleExample example = given()
    //                .header("Content-type", "application/json")
    //                .body(json)
    //                .post("...")
    //                .body()
    //// попросили представить результат как объект типа Api.SimpleExample
    //                .as(Api.SimpleExample.class);
    //В итоге получается обычный Java-объект example. Он содержит данные из ответа.

    //Как десериализовать сложный JSON
    //Вот сложный JSON:
    //{
    //   "id": "61652",
    //   "phone": {
    //           "home":"8-812-123-45-56",
    //           "mobile":"8-921-234-45-56"
    //   },
    //   "groups": [{
    //           "id":"1",
    //           "name": "Группа 1"
    //       },
    //       {
    //           "id":"2",
    //           "name": "Группа 2"
    //        }
    //   ]
    //}
    //Здесь есть элемент phone: он состоит из двух полей — home и mobile.
    //И есть второй сложный элемент — groups. Это массив. Составляющие массива — тоже сложные элементы.
    //Получается такая «матрёшка»: элемент в элементе, который в массиве, а сам массив — часть элемента.
    //Эту «матрёшку» тоже можно десериализовать — превратить в объекты.
    //    Сначала нужно создать классы POJO.
    //    Для элемента phone:
    public class Phone {
        // создали поле для домашнего номера
        private String home;
        // создали поле для мобильного номера
        private String mobile;

        // добавили геттеры и сеттеры для доступа к данным
        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    //    Для элемента group:
    public class Group {
        // поля
        private int id;
        private String name;

        // геттеры и сеттеры

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
//    И для общего JSON, который включает элементы обоих классов:
//            import java.util.List;

    public class User {
        private int id;
        private Phone phone;
        // список групп, потому что в исходном JSON — массив элементов
        private List<Group> groups;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Phone getPhone() {
            return phone;
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;

        }
    }
    //Теперь осталось написать код, чтобы вызвать запрос через RestAssured.
    //Получится ответ в виде объекта этого класса:
    //            Api.User user = given()
    //                .header("Content-type", "application/json")
    //                .get("...")
    //                .body().as(Api.User.class);
    //В итоге в объекте user будут лежать все данные из JSON: всё сделают RestAssured и Gson.

}
