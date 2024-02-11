package Api;

import Api.Profile;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProfileTest {

    String MyKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTc4YWI0MTQ0MDY3YjAwM2Q3NDk2ZTQiLCJpYXQiOjE3MDcwNTM4OTcsImV4cCI6MTcwNzY1ODY5N30.Y6COPrnhhT-1imuDchX4ESMu31NjjAaHCiGwlJTviCc";

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void updateProfile() {
        Profile profile = new Profile("Василий Васильев", "Самый крутой исследователь"); // создай объект, который соответствует JSON
        given()
                .header("Content-type", "application/json") // заполни header
                .auth().oauth2(MyKey)
                .and()
                .body(profile) // заполни body
                .when()
                .patch("/api/users/me"); // отправь запрос на ручку
    }

    //Запрос данных у приложения
    //Например, ты тестируешь метод, который ставит лайк на фотографию в Mesto.
    // Чтобы не добавлять фотографии для проверки самостоятельно, можно получить список фотографий от приложения.
    //Для этого нужно:
    //Вызвать метод, который возвращает фотографии.
    //Сохранить параметр _id первой фотографии из списка.
    //Вызвать метод, который ставит лайк, и передать параметр.
    //Вызвать метод, который удаляет лайк, и передать параметр.
    //В коде это выглядит так:
    @Test
    public void likeTheFirstPhoto() {
        String oauthToken = MyKey;

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