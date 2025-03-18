package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
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
import ru.iteco.fmhandroid.ui.page.About;
import ru.iteco.fmhandroid.ui.page.Authorization;
import ru.iteco.fmhandroid.ui.page.Menu;

@DisplayName("Тестирование страницы About")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {
    private Authorization auth = new Authorization();
    private Menu menu = new Menu();
    private About about = new About();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menu.openAboutPage();
        } catch (Exception e) {
//            auth.authUser();
            menu.openAboutPage();
            about.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Переход по ссылке /privacy-policy для просмотра политики конфиденциальности (id 17)")
    @Test
    public void shouldOpenPrivacyPolicyLink() {
        Intents.init();
        about.clickPrivacyPolicyLinc();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Epic("Позитивный")
    @Description("Переход по ссылке /terms-of-use для просмотра условий использования (id 18)")
    @Test
    public void shouldOpenTermsOfUseLink() {
        Intents.init();
        about.clickTermsOfUseLinc();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }
}