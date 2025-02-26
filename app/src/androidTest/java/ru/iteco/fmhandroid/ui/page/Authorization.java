package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Helper;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class Authorization {


    private final ViewInteraction title = onView(withText("Authorization"));
    private final ViewInteraction loginField = onView(withHint("Login"));
    private final ViewInteraction passwordField = onView(withHint("Password"));
    private final ViewInteraction button = onView(withId(R.id.enter_button));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.enter_button, 5000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        passwordField.check(matches(isDisplayed()));
        button.check(matches(isDisplayed()));
        button.check(matches(ViewMatchers.withText("SIGN IN")));
    }


    public void addLogin(String login) {
        Allure.step("Ввод логина");
        loginField.perform(replaceText(login), closeSoftKeyboard());
    }


    public void addPassword(String password) {
        Allure.step("Ввод пароля");
        passwordField.perform(replaceText(password), closeSoftKeyboard());
    }


    public void authUser() {
        Allure.step("Авторизация пользователя");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.login_text_input_layout, 5000));
        addLogin(Helper.getValidLogin());
        addPassword(Helper.getValidPassword());
        clickButton();
    }

    public void clickButton() {
        Allure.step("Нажатие кнопки SIGN IN");
        button.perform(click());
    }

    public void errorMessageText(String text, View decorView) {
        Allure.step("Появление текста ошибки");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}