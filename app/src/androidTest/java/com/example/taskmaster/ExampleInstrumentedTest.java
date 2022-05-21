package com.example.taskmaster;

import android.content.Context;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import androidx.test.rule.ActivityTestRule;

import com.example.taskmaster.Activities.MainActivity;


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity =
            new ActivityTestRule<>(MainActivity.class);

//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.taskmaster", appContext.getPackageName());
//    }

    @Test
    public void AddTaskTest() {
        RecyclerView recyclerView = mainActivity.getActivity().findViewById(R.id.rere);
        int Count1 = recyclerView.getAdapter().getItemCount();
        Espresso.onView(withId(R.id.ADDTASK)).perform(click());
        onView(withId(R.id.Tasknamee)).perform(typeText("Test 1234"), closeSoftKeyboard());
        onView(withId(R.id.Taskbodyy)).perform(typeText("Body 1234"), closeSoftKeyboard());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ADDTASKA)).perform(click());
        int Count2 = recyclerView.getAdapter().getItemCount();
        System.out.println(Count1);
        System.out.println(Count2);
    }
    @Test
    public void EditUsernameSettingsTest() {
        Espresso.onView(withId(R.id.Settings)).perform(click());
        onView(withId(R.id.Write_your_username)).perform(typeText("User-Test"), closeSoftKeyboard());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_submit)).perform(click());
        onView(withId(R.id.username)).check(matches(withText("User-Test")));
        Espresso.pressBack();

    }
    @Test
    public void TaskClickTest() {
        onView(withId(R.id.rere)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(R.id.Task_name)).check(matches(withText("new")));
        onView(withId(R.id.Task_Body)).check(matches(withText("Do ")));
    }

    @Test
    public void UI_elementsTest() {

        onView(withId(R.id.Settings)).check(matches(isDisplayed()));
        onView(withId(R.id.ADDTASK)).check(matches(isDisplayed()));
        onView(withId(R.id.AllTasks)).check(matches(isDisplayed()));
        onView(withId(R.id.rere)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }




}