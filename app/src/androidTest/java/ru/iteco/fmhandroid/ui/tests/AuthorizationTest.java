package ru.iteco.fmhandroid.ui.tests;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

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
import ru.iteco.fmhandroid.ui.page.Main;
import ru.iteco.fmhandroid.ui.page.Menu;

@DisplayName("Тестирование страницы авторизации")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {
    private Authorization authPage = new Authorization();
    private Menu menuBar = new Menu();
    private Main mainPage = new Main();
    private View decorView;
    private String errorEmptyText = "Login and password cannot be empty";
    private String errorTextIncorrect = "Incorrect login or password.";

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
//        try {
//            authPage.waitingPageLoad();
//        } catch (Exception e) {
//            menuBar.logout();
//            authPage.waitingPageLoad();
//        }
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }


    @Epic("Позитивный")
    @Description("Авторизация с корректными данными (id 1)")
    @Test
    public void shouldAuth() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        mainPage.pageVisible();
    }

    @Epic("Позитивный")
    @Description("Логаут пользователя (id 2)")
    @Test
    public void shouldLogOut() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        menuBar.logout();
        authPage.pageVisible();
    }

    @Epic("Негативный")
    @Description("Авторизация с некорректным логином и корректным паролем (id 3)")
    @Test
    public void shouldTryAuthWithInvalidLogin() {
        authPage.addLogin(Helper.generateInvalidLogin("en"));
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        authPage.errorMessageText(errorTextIncorrect, decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с корректным логином и некорректным паролем (id 4)")
    @Test
    public void shouldTryAuthWithInvalidPassword() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.addPassword(Helper.generateInvalidPassword("en"));
        authPage.clickButton();
        authPage.errorMessageText(errorTextIncorrect, decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с незаполненными полями Логин и Пароль (id 7)")
    @Test
    public void shouldTryAuthWithEmptyFields() {
        authPage.clickButton();
        authPage.errorMessageText(errorEmptyText, decorView);
    }

}