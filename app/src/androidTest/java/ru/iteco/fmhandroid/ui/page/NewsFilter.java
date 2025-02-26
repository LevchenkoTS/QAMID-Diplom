package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class NewsFilter {

    private final ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction startDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private final ViewInteraction endDate = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    private final ViewInteraction filterButton = onView(withId(R.id.filter_button));
    private final ViewInteraction cancelButtonFilter = onView(withId(R.id.cancel_button));


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.filter_news_title_text_view, 7000));
    }


    public void addCategory(String data) {
        Allure.step("Выбор категории");
        category.perform(replaceText(data));
    }

    public void addStartDate(String value) {
        Allure.step("Выбор даты начала");
        startDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void addEndDate(String value) {
        Allure.step("Выбор даты окончания");
        endDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void clickFilter() {
        Allure.step("Нажатие на кнопку FILTER");
        filterButton.perform(click());
    }

}