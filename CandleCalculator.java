package Fi06.candles;

public class CandleCalculator {
    private final Candle candle;

    public CandleCalculator(Candle candle) {
        this.candle = candle;
    }

    public Candle getCandle() {
        return candle;
    }

    public String getTimeLeft() {
        Time time = new Time();
        time.calcWithDecimals(calcDuration());
        return time.toString();
    }

    double calcWeight(){
        if(this.candle.getWeight() == 0) {
            double vol = calcVolume();
            this.candle.setWeight(
                    this.candle.getMaterial().getDensity() * vol
            );
        }
        return this.candle.getWeight();
    }

    private double calcVolume(){
        double rad = (this.candle.getDiameter() / 2.0);
        return Math.PI * Math.pow(rad, 2) * candle.getLength();
    }

    double calcDuration(){
        if (this.candle.getMaterial() != null) {
            calcWeight();
            return candle.getWeight() / candle.getMaterial().getBurnSpeed();
        }
        return 0.0;
    }
}
