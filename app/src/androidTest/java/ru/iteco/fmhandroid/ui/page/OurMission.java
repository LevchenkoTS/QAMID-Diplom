package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.Data.Utility;

public class OurMission {


    private final ViewInteraction materialCard = onView(allOf(withId(R.id.our_mission_item_list_recycler_view), Utility.
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
    private final ViewInteraction itemTextCard = onView(allOf(withId(R.id.our_mission_item_description_text_view),
            withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
            isDisplayed()));

    public void waitingPageLoad() {
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.our_mission_title_text_view, 7000));
    }

    public void clickView(int position) {
        Allure.step("Разворачивание карточки цитаты");
        materialCard.perform(actionOnItemAtPosition(position, click()));
    }

    public void textCardVisible(String text) {
        Allure.step("Проверка видимости текста цитаты");
        itemTextCard.check(matches(withText(text)));
        itemTextCard.check(matches(isDisplayed()));
    }
}