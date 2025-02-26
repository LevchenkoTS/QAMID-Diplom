package ru.iteco.fmhandroid.ui.Data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {

    public static Faker faker = new Faker(new Locale("en"));

    public static String getValidLogin() {
        return ("login2");
    }

    public static String getValidPassword() {
        return ("password2");
    }


    public static String generateInvalidLogin(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().username();
    }

    public static String generateInvalidPassword(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.internet().password();
    }


    public static String getCategory(int index) {
        String[] category = new String[]{
                "Объявление",
                "День рождения",
                "Зарплата",
                "Профсоюз",
                "Праздник",
                "Массаж",
                "Благодарность",
                "Нужна помощь"};
        return category[index - 1];
    }


    public static String generateDate(int shift) {
        String pattern = "dd.MM.yyyy";
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern(pattern));
        return date;
    }

    public static String getСurrentDate() {
        String pattern = "dd.MM.yyyy";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
        return date;
    }

    public static String getСurrentTime(int shift) {
        String pattern = "HH:mm";
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
        return time;
    }

}