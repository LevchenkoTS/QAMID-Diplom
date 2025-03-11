package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

import static org.hamcrest.Matchers.not;

import android.view.View;

import ru.iteco.fmhandroid.dto.NewsWithCategory;
import ru.iteco.fmhandroid.ui.Data.Helper;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class CreateNews {


    private final ViewInteraction categoryBox = Espresso.onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction titleBox = Espresso.onView(withId(R.id.news_item_title_text_input_edit_text));
    private final ViewInteraction publicationDate = Espresso.onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    private final ViewInteraction time = Espresso.onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    private final ViewInteraction description = Espresso.onView(withId(R.id.news_item_description_text_input_edit_text));
    private final ViewInteraction saveButton = Espresso.onView(withId(R.id.save_button));
    private final ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    private String NewsMessage = "Хоспис открылся";
    private String NewsMessage2 = "Хоспис открывается в январе";

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.custom_app_bar_title_text_view, 7000));
    }


    public void clickSort() {
        Allure.step("Нажатие на кнопку сортировки");
        sortButton.perform(click());
    }


    public void createEmptyNews() {
        Allure.step("Создание первой новости");
        saveButton.perform(click());
    }

    public void createNews() {
        Allure.step("Создание второй новости");
        categoryBox.perform(replaceText(Helper.getCategory(1)));
        titleBox.perform(replaceText(NewsMessage));
        publicationDate.perform(replaceText(Helper.getСurrentDate()));
        time.perform(replaceText(Helper.getСurrentTime(0)));
        description.perform(replaceText(NewsMessage2));
        closeSoftKeyboard();
        saveButton.perform(click());
    }


    public void errorMessageText(String text, View decorView) {
        Allure.step("Появление текста ошибки");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}