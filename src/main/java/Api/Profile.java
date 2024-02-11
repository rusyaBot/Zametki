package Api;

//  Задание
    // В прошлом уроке тебе удалось написать запрос к ручке PATCH. JSON попадал в тело запроса в виде файла.
    //  Вспомни условие задачи: нужно обновить информацию о профиле PATCH-запросом на ручку api/users/me.
    //  В теле запроса нужно передать такой JSON:
    //  {
    //  "name": "Василий Васильев",
    //  "about": "Самый крутой исследователь"
    //  }
    //  Напиши такой же запрос, но в этот раз используй сериализацию.
    //  Сначала создай класс, который описывает входной JSON. Не забудь добавить геттеры и сеттеры: как ты знаешь, они не влияют на сериализацию, но лучше писать код сразу с ними.
    //  Сгенерировать геттеры и сеттеры поможет среда разработки: Generate → Getter and Setter. Можно скопировать код в IDEA, а потом обратно в тренажёр.
    //  Напиши тест с вызовом ручки /api/users/me в классе Praktikum.
public class Profile {
    private String name;
    private String about;

    public Profile(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
