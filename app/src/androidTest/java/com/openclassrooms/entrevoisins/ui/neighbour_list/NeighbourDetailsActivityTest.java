package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class NeighbourDetailsActivityTest {

    private static int idNeighbourToTest = 6;

    private ListNeighbourActivity mActivity;
    private NeighbourApiService mService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
        assertThat(mActivity, notNullValue());

        mService = DI.getNewInstanceApiService();
        assertThat(mService, notNullValue());
    }

    @Test
    public void neighbourDetailsActivity_isDisplayed() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(idNeighbourToTest, click()));

        onView(withId(R.id.activity_neighbours_details)).check(matches(isDisplayed()));
    }

    @Test
    public void neighbourDetailsActivity_nameIsDisplayed() {
        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(actionOnItemAtPosition(idNeighbourToTest, click()));

        onView(withId(R.id.activity_neighbours_details)).check(matches(isDisplayed()));
        onView(withId(R.id.activity_neighbour_details_toolbar_txt)).check(matches(withText(mService.getNeighbours().get(idNeighbourToTest).getName())));
        onView(withId(R.id.infos_card_title_txt)).check(matches(withText(mService.getNeighbours().get(idNeighbourToTest).getName())));
    }
}
