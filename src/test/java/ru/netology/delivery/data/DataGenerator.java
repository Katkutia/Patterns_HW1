
package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    public static String generateDate(int shift) {
        var date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String[] city = {"Абакан", "Анадырь", "Архангельск", "Астрахань",
                "Барнаул", "Белгород", "Биробиджан", "Благовещенск", "Брянск",
                "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж",
                "Горно-Алтайск", "Грозный",
                "Екатеринбург",
                "Иваново", "Ижевск", "Иркутск",
                "Йошкар-Ола",
                "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл",
                "Липецк",
                "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Мурманск",
                "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск",
                "Омск", "Орёл", "Оренбург",
                "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков",
                "Ростов-на-Дону", "Рязань",
                "Салехард", "Самара", "Санкт-Петербург", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар",
                "Тамбов", "Тверь", "Томск", "Тула", "Тюмень",
                "Улан-Удэ", "Ульяновск", "Уфа",
                "Хабаровск", "Ханты-Мансийск",
                "Чебоксары", "Челябинск", "Черкесск", "Чита",
                "Элиста",
                "Южно-Сахалинск",
                "Якутск", "Ярославль"};
        return city[new Random().nextInt(city.length -1)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

        public String getCity() {
            return city;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}