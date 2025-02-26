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
import ru.iteco.fmhandroid.ui.page.Authorization;
import ru.iteco.fmhandroid.ui.page.Menu;
import ru.iteco.fmhandroid.ui.page.OurMission;

@DisplayName("Тестирование страницы OurMission")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class OurMissionTest {
    private Authorization authPage = new Authorization();
    private Menu menuBar = new Menu();
    private OurMission ourMissionPage = new OurMission();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openOurMission();
            ourMissionPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openOurMission();
            ourMissionPage.waitingPageLoad();
        }
    }

    @After
    public void setUpLogOut() {
        menuBar.logout();
    }

    @Epic("Позитивный")
    @Description("Разворацивание карточки цитаты (id 16)")
    @Test
    public void shouldBeTextVisibleOnPosition() {
        ourMissionPage.clickView(1);
        ourMissionPage.textCardVisible("Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.");
    }
}