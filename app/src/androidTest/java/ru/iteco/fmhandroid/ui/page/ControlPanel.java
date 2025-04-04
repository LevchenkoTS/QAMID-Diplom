package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class ControlPanel {

    private final ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    private final ViewInteraction createButton = onView(withId(R.id.add_news_image_view));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.sort_news_material_button, 7000));
    }


    public void titleNewsVisible(String title) {
        Allure.step("Видимость заголовка новости");
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.news_item_title_text_view), withText(title),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView2.check(matches(withText(title)));
    }


    public void clickSort() {
        Allure.step("Нажатие на кнопку сортировки");
        sortButton.perform(click());
    }


    public CreateNews clickCreate() {
        Allure.step("Открытие страницы создания новости");
        createButton.perform(click());
        return new CreateNews();
    }


}