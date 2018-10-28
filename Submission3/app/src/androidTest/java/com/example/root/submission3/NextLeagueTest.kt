package com.example.root.submission3

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.swipeDown
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.root.submission3.R.id.*
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NextLeagueTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testRecyclerViewBehaviour() {
        onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())
        Thread.sleep(6000)
        onView(withId(recycler_view_team)).check(matches(isDisplayed()))
        onView(withId(R.id.swipe_refresh_layout_team)).perform(swipeDown())
        Thread.sleep(6000)
        onView(withId(recycler_view_team)).check(matches(isDisplayed()))
        onView(withId(recycler_view_team)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
        onView(withId(recycler_view_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))
    }

    @Test
    fun testDetailBehaviour() {
        onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())
        Thread.sleep(6000)

        onView(withId(recycler_view_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))
        Thread.sleep(6000)

        onView(withId(date_events_detail)).check(matches(isDisplayed()))
        onView(withId(date_events_detail)).check(matches(isDisplayed()))
        onView(withId(ll_score_detail)).check(matches(isDisplayed()))
        onView(withId(image_home_detail)).check(matches(isDisplayed()))
        onView(withId(tv_image_home_detail)).check(matches(isDisplayed()))
        onView(withId(image_home_detail)).check(matches(isDisplayed()))
        onView(withId(score_detail)).check(matches(isDisplayed()))
        onView(withId(image_away_detail)).check(matches(isDisplayed()))
        onView(withId(tv_image_away_detail)).check(matches(isDisplayed()))
        onView(withId(date_events_detail)).check(matches(isDisplayed()))
        onView(withId(view_line_goals)).check(matches(isDisplayed()))
        onView(withId(home_goal_details)).check(matches(isDisplayed()))
        onView(withId(away_goal_details)).check(matches(isDisplayed()))
        onView(withId(view_line_goals)).check(matches(isDisplayed()))
        onView(withId(home_shots_detail)).check(matches(isDisplayed()))
        onView(withId(away_shots_detail)).check(matches(isDisplayed()))
        onView(withId(view_line_up_goals)).check(matches(isDisplayed()))
        onView(withId(line_ups)).check(matches(isDisplayed()))
        onView(withId(home_line_up_goal_keeper)).check(matches(isDisplayed()))
        onView(withId(away_line_up_goal_keeper)).check(matches(isDisplayed()))
        onView(withId(home_line_up_defense)).check(matches(isDisplayed()))
        onView(withId(away_line_up_defense)).check(matches(isDisplayed()))

        onView(withId(R.id.home_lineup_substitutes)).perform(ViewActions.scrollTo())
        Thread.sleep(2000)

        onView(withId(home_line_up_midfield)).check(matches(isDisplayed()))
        onView(withId(away_lineup_midfield)).check(matches(isDisplayed()))
        onView(withId(home_lineup_forward)).check(matches(isDisplayed()))
        onView(withId(away_lineup_forward)).check(matches(isDisplayed()))
        onView(withId(home_lineup_substitutes)).check(matches(isDisplayed()))
        onView(withId(away_lineup_substitutes)).check(matches(isDisplayed()))
    }


    @Test
    fun testTeamNextLeagueFavoriteBehaviour() {
        onView(ViewMatchers.withId(R.id.next_match)).perform(ViewActions.click())
        Thread.sleep(6000)

        onView(withId(recycler_view_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        Thread.sleep(6000)
        onView(withId(add_to_favorite)).check(matches(isDisplayed()))
        onView(withId(add_to_favorite)).perform(click())
        onView(withText("Added to Favorite"))
                .inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()))
        Thread.sleep(4000)

        onView(withId(add_to_favorite)).perform(click())
        onView(withText("Removed to Favorite"))
                .inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()))
        Thread.sleep(4000)

        onView(withId(add_to_favorite)).perform(click())
        onView(withText("Added to Favorite"))
                .inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()))
        Thread.sleep(2000)

        pressBack()

        onView(withId(bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(favorites)).perform(click())
        Thread.sleep(3000)

        onView(withId(recycler_view_team)).check(matches(isDisplayed()))
        onView(withId(recycler_view_team)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(6000)

        onView(withId(add_to_favorite)).perform(click())
        onView(withText("Removed to Favorite"))
                .inRoot(withDecorView(not(activityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()))
        Thread.sleep(3000)

        pressBack()

        onView(withId(R.id.swipe_refresh_layout_team)).perform(swipeDown())

    }
}