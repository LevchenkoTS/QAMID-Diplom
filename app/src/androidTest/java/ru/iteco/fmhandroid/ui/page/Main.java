package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class Main {
    private final ViewInteraction title = onView(withText("News"));
    private final ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));

    private final ViewInteraction viewAllNewsButton = onView(withId(R.id.expand_material_button));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.all_news_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));

        allNewsButton.check(matches(isDisplayed()));
        allNewsButton.check(matches(withText("ALL NEWS")));
        viewAllNewsButton.check(matches(isDisplayed()));

    }

}