//Напиши тест с вызовом ручки в классе Praktikum. Получи ответ в виде объекта класса. Проверь, что объект не равен null.

package Api;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.hamcrest.MatcherAssert;

public class UserTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkUserName() {
        User user = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTc4YWI0MTQ0MDY3YjAwM2Q3NDk2ZTQiLCJpYXQiOjE3MDcwNTM4OTcsImV4cCI6MTcwNzY1ODY5N30.Y6COPrnhhT-1imuDchX4ESMu31NjjAaHCiGwlJTviCc")
                .get("/api/users/me")
                .body().as(User.class); // напиши код для десериализации ответа в объект типа User
        MatcherAssert.assertThat(user, notNullValue());
    }

}