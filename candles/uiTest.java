package Fi06.candles;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.anything;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class uiTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void performInput(){
        String mLengthString = "20";
        String mDiameterString = "3.5";

            //Select stearin as material
            Espresso.onView(withId(R.id.candleSpinner)).perform(ViewActions.click());
            Espresso.onData(anything()).atPosition(1).perform(ViewActions.click());

            //Input candle-data
            Espresso.onView(withId(R.id.lengthInput))
                    .perform(ViewActions.typeText(mLengthString));
            Espresso.onView(withId(R.id.diameterInput)).perform(ViewActions.typeText(mDiameterString), ViewActions.closeSoftKeyboard());

            //calcBtn.click()
            Espresso.onView(withId(R.id.calcBtn)).perform(ViewActions.click());
    }

    @Test
    public void calcDuration() {
        String mDurationResult = "27:31";

        //Assert durationResult = 27:31
        Espresso.onView(withId(R.id.durationResult)).check(ViewAssertions.matches(ViewMatchers.withText(mDurationResult)));
    }

    @Test
    public void resetForm(){
        //resetBtn.click() => every input-field cleared
        Espresso.onView(withId(R.id.resetBtn)).perform(ViewActions.click());
        Espresso.onView(withId(R.id.durationResult)).check(ViewAssertions.matches(ViewMatchers.withText("")));
        Espresso.onView(withId(R.id.diameterInput)).check(ViewAssertions.matches(ViewMatchers.withText("")));
        Espresso.onView(withId(R.id.lengthInput)).check(ViewAssertions.matches(ViewMatchers.withText("")));
    }
}
