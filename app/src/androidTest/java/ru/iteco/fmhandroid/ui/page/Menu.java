package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;


import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class Menu {
    private final ViewInteraction mainMenu = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction newsButton = onView(withText("News"));
    private final ViewInteraction aboutButton = onView(withText("About"));
    private final ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction profileButton = onView(withId(R.id.authorization_image_button));

    private final ViewInteraction logOut = onView(withText("Log out"));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.main_menu_image_button, 5000));
    }

    public News openNewsPage() {
        Allure.step("Открытие страницы News");
        waitingPageLoad();
        mainMenu.perform(click());
        newsButton.perform(click());
        return new News();
    }

    public About openAboutPage() {
        Allure.step("Отркытие страницы About");
        waitingPageLoad();
        mainMenu.perform(click());
        aboutButton.perform(click());
        return new About();
    }

    public OurMission openOurMission() {
        Allure.step("Открытие страницы Our Mission");
        waitingPageLoad();
        ourMissionButton.perform(click());
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.our_mission_title_text_view, 7000));
        return new OurMission();
    }


    public Authorization logout() {
        Allure.step("Логаут");
        waitingPageLoad();
        profileButton.perform(click());
        Utility.waitDisplayed(android.R.id.content, 7000);
        logOut.perform(click());
        return new Authorization();
    }
}