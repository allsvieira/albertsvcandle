package Fi06.candles;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    static class TimeTest {

        private Time time;

        @BeforeEach
        void setUp() {
            time = new Time();
        }

        @Test
        @DisplayName("1 => 1 hour  0 min")
        void getOneHour(){
            time.calcWithDecimals(1);
            assertEquals(1,time.getHours() );
            assertEquals(0,time.getMinutes() );
        }

        @Test
        @DisplayName("200 => 200 hour")
        void get200Hour(){
            time.calcWithDecimals(200.13);
            assertEquals(200,time.getHours() );
        }
        @Test
        @DisplayName("1.5 => 1 hour 30 min")
        void getOneAHalfHour(){
            time.calcWithDecimals(1.5);
            assertEquals(1,time.getHours() );
            assertEquals(30,time.getMinutes() );
        }

        @Test
        @DisplayName("0.1 => 0 hour 6 min")
        void getSixMinutes(){
            time.calcWithDecimals(0.1);
            assertEquals(0,time.getHours() );
            assertEquals(6,time.getMinutes() );
        }

        @Test
        @DisplayName("-1.1 => 0 hour 0 min")
        void getNegative(){
            time.calcWithDecimals(-1.1);
            assertEquals(0,time.getHours() );
            assertEquals(0,time.getMinutes() );
        }
    }
}