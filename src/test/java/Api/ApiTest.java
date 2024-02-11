package Api;
// импортируем RestAssured

import io.restassured.RestAssured;
import io.restassured.response.Response;
// импортируем Before
import org.junit.Before;
// импортируем Test
import org.junit.Test;
// дополнительный статический импорт нужен, чтобы использовать given(), get() и then()
import java.io.File;

import static io.restassured.specification.ProxySpecification.auth;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ApiTest {
    String MyKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTc4YWI0MTQ0MDY3YjAwM2Q3NDk2ZTQiLCJpYXQiOjE3MDcwNTM4OTcsImV4cCI6MTcwNzY1ODY5N30.Y6COPrnhhT-1imuDchX4ESMu31NjjAaHCiGwlJTviCc";

    // аннотация Before показывает, что метод будет выполняться перед каждым тестовым методом
    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
        // если в классе будет несколько тестов, указывать её придётся только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    // Из чего состоит запрос:
    // Метод given() помогает добавить метод авторизации к запросу.
    // Метод auth().oauth2() указывает, как будет проходить авторизация. Сайт Mesto использует протокол OAuth2, поэтому после auth() нужно указать метод oauth2().
    // В него передают параметр — токен авторизации. О том, как получить токен, ты знаешь из урока про Postman.
    // Метод get() отправляет GET-запрос на ручку, которая указана как параметр. В ответ вернётся объект класса Response.
    // Метод then() валидирует ответ. В RestAssured можно сразу указать, что именно нужно проверить: сложные конструкции с assertThat() могут и не понадобиться.
    // Например, можно проверить статус-код через statusCode() или время ответа через time().
    // создаём метод автотеста
    @Test
    public void getMyInfoStatusCode() {
        // метод given() помогает сформировать запрос
        given()
                // указываем протокол и данные авторизации
                .auth().oauth2(MyKey)
                // отправляем GET-запрос с помощью метода get, недостающую часть URL (ручку) передаём в него в качестве параметра
                .get("/api/users/me")
                // проверяем, что статус-код ответа равен 200
                .then().statusCode(200);
    }
    // Запрос нужно отправлять так же, как и в прошлый раз:
    // given() поможет создать запрос;
    // auth().oauth2() нужен для авторизации в приложении;
    // get() указывает тип запроса, в качестве параметра нужно передать ручку.
    // Работа с ответом начинается с метода then(): then().assertThat().body("data.name", equalTo("здесь_укажи_имя_своего_пользователя")).
    // С assertThat() тебе уже удалось познакомиться: он сравнивает значения.
    // Обрати внимание: в теле ответа лежит JSON. В нём есть ключ data. Значение, которое соответствует ключу, — ещё один JSON.
    // RestAssured позволяет получить значение из вложенного JSON: нужно указать ключи через знак .
    // Для имени пользователя путь будет выглядеть так: data.name.

    // Команда body("data.name",equalTo("имя_пользователя")) получает из JSON значение, которое соответствует ключу name. Она сравнивает его
    // с именем пользователя, которое указано в матчере equalTo.
    // Программа и отправляет запрос, и проверяет ответ. В этом плюс RestAssured: всё коротко и похоже на обычную речь. Если «перевести» код,
    // получится «авторизация по методу auth().oauth2(), запрос GET. Проверяем, что в теле ответа поле name равно имя_пользователя».
    @Test
    public void checkUserName() {
        given()
                .auth().oauth2(MyKey)
                .get("/api/users/me")
                .then().assertThat().body("data.name", equalTo("Аристарх Сократович"));
    }

    //Можно сохранить ответ на запрос в переменную и дальше работать уже с ней — например, вывести в консоль.
    @Test
    public void checkUserNameAndPrintResponseBody() {
        // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
        Response response = given()
                .auth().oauth2(MyKey)
                .get("/api/users/me");
        // проверяет, что в теле ответа ключу name соответствует нужное имя пользователя
        response.then().assertThat().body("data.name", equalTo("Аристарх Сократович"));
        // выводит тело ответа на экран
        System.out.println(response.body().asString());
    }
    // Сперва появляется переменная response — это экземпляр класса Response библиотеки RestAssured. В неё сохранили ответ на запрос.
    // Запрос отправляется точно так же, как и в предыдущем примере: given().auth().oauth2("введи_сюда_свой_токен").get("/api/users/me");
    // Текст в теле ответа на запрос можно проверить: response.then().assertThat().body("data.name",equalTo("здесь_укажи_имя_своего_пользователя"));
    // Чтобы вывести тело ответа на экран, нужно преобразовать его в строку. Вот так: response.body().asString()


    //---------Подстановка файла JSON------------
    // Чтобы добавить файл в код, понадобится конструктор класса File. Он связывает файл на компьютере и объект класса File.
    // В качестве аргумента нужно передать относительный путь к JSON-файлу и сохранить его в переменной json:
    // Строка header("Content-type", application/json) указывает, что данные в теле запроса передаются в формате JSON.
    // Строка с .auth — это авторизация с токеном.
    // В строке .body(json) файл передают в тело запроса.
    // Дальше код отличается от GET-запроса только названием — post и кодом ответа.
    // Когда ты создаёшь новую сущность, сервер обычно возвращает 201 Created.
    @Test
    public void createNewPlaceAndCheckResponse() {
        File json = new File("src/test/resources/newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2(MyKey)
                        .and()
                        .body(json)
                        .when()
                        .post("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }

    //Если JSON небольшой, его можно передать в тело запроса через строковую переменную, а не в файле.
//    @Test
//    public void createNewPlaceAndCheckResponse(){
//        String json = "{\"name\": \"Очень интересное место\", \"link\": \"https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg\"}";;
//        Response response =
//                given()
//                        .header("Content-type", "application/json")
//                        .auth().oauth2(MyKey)
//                        .and()
//                        .body(json)
//                        .when()
//               ...
//    }

    // Вспомни: POST-запрос обычно добавляет данные, а PATCH — обновляет.
    // PATCH-запрос может обновить объект целиком или только некоторые поля.
    // PATCH-запросы тоже передают данные в виде JSON, поэтому код будет похожим.
    // Представь, что у ручки /api/cards есть метод PATCH. Тогда получился бы такой код:
    @Test
    public void createNewPlaceAndCheckResponse2() {
        File json = new File("src/test/resources/newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2(MyKey)
                        .and()
                        .body(json)
                        .when()
                        .patch("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }

    // Задание
    //Тебе нужно обновить информацию о профиле PATCH-запросом на ручку /api/users/me.
    //В теле запроса нужно передать такой JSON:
    //{
    //  "name": "Василий Васильев",
    //  "about": "Самый крутой исследователь"
    //}
    //По условию этот файл хранится в src/test/resources под именем updateProfile.json.
    //JSON, который придёт в ответ на корректный вызов, выглядит так:
    //{
    //  "data": {
    //     "name": "Василий Васильев",
    //     "about": "Самый крутой исследователь",
    //     "avatar": "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png",
    //     "_id": "6578ab4144067b003d7496e4",
    //     "email": "mahmudov29@gmail.com"
    //   }
    //}
    //Напиши тест, который отправляет PATCH-запрос на ручку /api/users/me и проверяет, что:
    //Статус ответа — 200.
    //Значения поля name такое же, как имя в JSON-файле.
    @Test
    public void updateProfileAndCheckStatusCode() {
        File json = new File("src/test/resources/updateProfile.json"); // запиши файл в файловую переменную
        Response response =
                given()
                        .header("Content-type", "application/json") // заполни header
                        .auth().oauth2(MyKey)
                        .and()
                        .body(json) // заполни body
                        .when()
                        .patch("/api/users/me"); // отправь запрос на ручку
        response.then().assertThat()
                .body("data.name", equalTo("Василий Васильев"))
                .and().body("data.about", equalTo("Самый крутой исследователь"))
                .and().body("data.avatar", equalTo("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png"))
                .and().body("data._id", equalTo("6578ab4144067b003d7496e4"))
                .and().body("data.email", equalTo("mahmudov29@gmail.com"))
                .and().statusCode(200);
    }


    //Как сериализовать объект
    //Для этого есть много библиотек. Одна из самых популярных — Gson. Именно для её работы пригодится конструктор без параметров.
    //Нужно сделать только одно — подключить библиотеку к проекту:
    //    <dependency>
    //<groupId>com.google.code.gson</groupId>
    //<artifactId>gson</artifactId>
    //<version>2.8.9</version>
    //</dependency>
    //Вот и всё. Теперь RestAssured сериализует объект, когда ты подставишь его в метод body:
    //               given()
    //                .header("Content-type", "application/json")
    //                .auth().oauth2("подставь_сюда_свой_токен")
    //                .and()
    //// сюда передали созданный объект с нужными значениями полей
    //                .body(card)
    //                .when()
    //                .post("/api/cards")
    //                .then()...;
    //Никакого дополнительного кода писать не нужно.

    //Как сериализовать массив
    //Представь, что предстоит передать в тело запроса JSON в виде массива данных. Например, отправить не одну карточку Mesto, а несколько.
    //Чтобы это сделать, нужно создать пустой список и добавить в него все элементы массива. А после — передать его в тело:
    //// создали пустой список
    //List<Api.Card> cards = new ArrayList<Api.Card>();
    //// добавили элементы
    //cards.add(new Api.Card("имя1", "линк1"));
    //cards.add(new Api.Card("имя2", "линк2"));
    //cards.add(new Api.Card("имя3", "линк3"));
    //
    // given()
    //                .header("Content-type", "application/json")
    //                 and()
    //// передали сформированный список в body
    //                .body(cards)
    //                .when()
    //                .post("...")
    //                .then()...;


    @Test
    public void likeTheFirstPhoto() {
        String oauthToken = "введи_сюда_свой_токен";

        // получение списка фотографий и сохранение _id первой фотографии
        String photoId = given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .get("/api/cards") // отправка GET-запроса
                .then().extract().body().path("data[0]._id"); // получение ID фотографии из массива данных

        // лайк первой фотографии
        given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .put("/api/cards/{photoId}/likes", photoId) // отправка PUT-запроса
                .then().assertThat().statusCode(200); // проверка, что сервер вернул код 200

        // снять лайк с первой фотографии
        given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .delete("/api/cards/{photoId}/likes", photoId) // отправка DELETE-запроса
                .then().assertThat().statusCode(200); // проверка, что сервер вернул код 200
    }

}


