package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class News {

    private final ViewInteraction titleContainer = onView(withId(R.id.container_list_news_include));
    private final ViewInteraction title = onView(withText("News"));
    private final ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    private final ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    private final ViewInteraction controlPanelButton = onView(withId(R.id.edit_news_material_button));
//    private final ViewInteraction cardNews = onView(withId(R.id.news_item_material_card_view));
//    private final ViewInteraction imageNews = onView(withId(R.id.category_icon_image_view));
//    private final ViewInteraction dateNews = onView(withId(R.id.news_item_date_text_view));
//    private final ViewInteraction titleNews = onView(withId(R.id.news_item_title_text_view));
//    private final ViewInteraction textNews = onView(withId(R.id.news_item_description_text_view));
//    private final ViewInteraction viewNewsImage = onView(withId(R.id.view_news_item_image_view));
    private final ViewInteraction viewNewsButton = onView(withId(R.id.news_list_recycler_view));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.container_list_news_include, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        titleContainer.check(matches(isDisplayed()));
        title.check(matches(isDisplayed()));
        sortButton.check(matches(isDisplayed()));
        filterButton.check(matches(isDisplayed()));
        controlPanelButton.check(matches(isDisplayed()));
        viewNewsButton.check(matches(isDisplayed()));
    }
//
//    public void clickView(int position) {
//        Allure.step("Разворачивание/сворачивание карточки новости по заданной позиции");
//        viewNewsButton.perform(actionOnItemAtPosition(position, scrollTo()));
//        viewNewsButton.perform(actionOnItemAtPosition(position, click()));
//    }
//
//    public void textNewsInvisible() {
//        Allure.step("Проверка невидимости текста новости после сворачивания блока новости");
//        textNews.check(matches(not(isDisplayed())));
//    }

    public NewsFilter clickFilter() {
        Allure.step("Открытие фильтра");
        filterButton.perform(click());
        return new NewsFilter();
    }

    public void clickSort() {
        Allure.step("Нажатие на кнопку сортировки");
        sortButton.perform(click());
    }

    public ControlPanel clickControlPanel() {
        Allure.step("Открытие страницы Сontrol Panel");
        controlPanelButton.perform(click());
        return new ControlPanel();
    }

}