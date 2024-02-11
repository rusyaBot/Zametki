package Api;
// Задача
    // Вспомни GET-запрос, который был в прошлых уроках. Это ручка api/users/me. Она возвращает такой JSON:
    //{
    //    "data":
    //    {
    //     "name": "Jacques Cousteau",
    //      "about": "Sailor, researcher",
    //      "avatar": "https://pictures.s3.yandex.net/frontend-developer/ava.jpg",
    //      "_id": "e20537ed11237f86bbb20ccb",
    //      "email": "jacquescousteau@yandex.ru"
    //    }
    //}
    //Тебе нужно десериализовать этот ответ.
    //Первое задание — создать класс для вложенного объекта, который хранится в data.
    //Сгенерировать геттеры и сеттеры поможет среда разработки: Generate → Getter and Setter. Можно скопировать код в IDEA, а потом обратно в тренажёр.

public class Data {
    private String name;
    private String about;
    private String avatar;
    private String _id;
    private String email;

    public Data(String name, String about, String avatar, String _id, String email) {
        this.name = name;
        this.about = about;
        this.avatar = avatar;
        this._id = _id;
        this.email = email;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
