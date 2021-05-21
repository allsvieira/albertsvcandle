package Fi06.candles;

public class Time {
    private int hours;
    private int minutes;

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    public void calcWithDecimals(double hours){
        hours = hours > 0 ? hours : 0;
        this.hours = (int) hours;
        this.minutes = (int) (60 * hours - (this.hours*60));
    }

    @Override
    public String toString() {
        return hours + ":"+ minutes;
    }
}
