package ru.iteco.fmhandroid.ui.tests;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
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
import ru.iteco.fmhandroid.ui.page.Authorization;
import ru.iteco.fmhandroid.ui.page.CreateNews;
import ru.iteco.fmhandroid.ui.page.ControlPanel;
import ru.iteco.fmhandroid.ui.page.Menu;
import ru.iteco.fmhandroid.ui.page.News;


@DisplayName("Тестирование функционала создания новостей на странице ControlPanel")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreateNewsTest {
    private Authorization auth = new Authorization();
    private News news = new News();
    private Menu menu = new Menu();
    private ControlPanel controlPanel = new ControlPanel();
    private ru.iteco.fmhandroid.ui.page.CreateNews createNews = new CreateNews();
    private String NewsMessage = "Хоспис открывается";
    private String toastMessage = "Fill empty fields";

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before

    public void setUp() {
        try {
            menu.openNewsPage();
            news.clickControlPanel();
            controlPanel.clickCreate();
            createNews.waitingPageLoad();
        } catch (Exception e) {
            auth.authUser();
            menu.openNewsPage();
            news.clickControlPanel();
            controlPanel.clickCreate();
            createNews.waitingPageLoad();
        }
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }


    @Epic("Позитивный")
    @Description("Добавление новой новости (id 8)")
    @Test
    public void shouldBeCreateNews() {
        createNews.createNews();
        controlPanel.titleNewsVisible(NewsMessage);
    }

    @Epic("Негативный")
    @Description("Создание новости с пустыми полями (id 19)")
    @Test
    public void shouldBeCreateEmptyNews() {
        createNews.createEmptyNews();
        createNews.errorMessageText(toastMessage, decorView);
    }
}