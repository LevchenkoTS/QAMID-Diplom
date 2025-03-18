package ru.iteco.fmhandroid.ui.page;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class About {

    private final ViewInteraction privacyPolicyLinc = onView(withId(R.id.about_privacy_policy_value_text_view));

    private final ViewInteraction termsOfUseLinc = onView(withId(R.id.about_terms_of_use_value_text_view));


    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.about_version_title_text_view, 7000));
    }

    public void clickPrivacyPolicyLinc() {
        Allure.step("Переход по ссылке /privacy-policy");
        privacyPolicyLinc.perform(click());
    }

    public void clickTermsOfUseLinc() {
        Allure.step("Переход по ссылке /terms-of-use");
        termsOfUseLinc.perform(click());
    }

}

