package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.Data.Helper;
import ru.iteco.fmhandroid.ui.page.Authorization;
import ru.iteco.fmhandroid.ui.page.Menu;
import ru.iteco.fmhandroid.ui.page.NewsFilter;
import ru.iteco.fmhandroid.ui.page.News;


@DisplayName("Тестирование функционала фильтрации на странице News")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsFilterTest {
    Authorization auth = new Authorization();
    News news = new News();
    Menu menu = new Menu();
    NewsFilter newsFilter = new NewsFilter();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menu.openNewsPage();
            news.clickFilter();
            newsFilter.waitingPageLoad();
        } catch (Exception e) {
            auth.authUser();
            menu.openNewsPage();
            news.clickFilter();
            newsFilter.waitingPageLoad();
        }
    }

    @After
    public void setUpLogOut() {
        menu.logout();
    }

    @Epic("Позитивный")
    @Description("Фильтрация новостей (id 9)")
    @Test
    public void shouldBeFilterNewsVisible() {
        newsFilter.addCategory(Helper.getCategory(1));
        newsFilter.addStartDate(Helper.generateDate(-30));
        newsFilter.addEndDate(Helper.getСurrentDate());
        newsFilter.clickFilter();
    }

}